package com.duysoftware.sentrybot;

import com.duysoftware.sentrybot.components.*;
import com.duysoftware.sentrybot.threads.InputRunnable;

import com.pi4j.io.gpio.RaspiPin;
/**
 * 
 * @author Duy Nguyen
 * @author Jack Ta
 */
public class Main {
	public static void main(String[] args) {
		//===================================================================== 
		// Robot and AI Initialization
		//=====================================================================
		System.out.println("Starting main program...");
		System.out.println("Loading AI...");
		Robot spiderBot = new Robot();
		AI ai = new AI(spiderBot);
		
		// creates the stand alone SoundSensor, can't connect to robot for ease
		// of development in non-Raspberry Pi environments.
		SoundSensor sensor = new SoundSensor(RaspiPin.GPIO_02);
		
		//=====================================================================
		// Thread for User Input
		//=====================================================================
		System.out.println("Loading User Input Thread...");
		InputRunnable inputRunnable = new InputRunnable(ai);
		Thread inputThread = new Thread(inputRunnable);
		
		//=====================================================================
		// Main
		//=====================================================================
		boolean onButton = true;
		System.out.println("Awaiting command...");
		
		inputThread.start();
		while (onButton == true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// call on alarm subroutine
			if (ai.onSentryMode() && sensor.querySensors()) {
				ai.parse("redAlert");
				sensor.reset();
				System.out.println("Awaiting next command...");
			}
		}
	}
}
