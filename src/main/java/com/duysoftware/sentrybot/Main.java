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
		System.out.println("Starting main program...");
		
		//===================================================================== 
		// creates the robot and its ai system
		System.out.println("Loading AI...");
		Robot spiderBot = new Robot();
		AI ai = new AI(spiderBot);
		
		// creates the stand alone SoundSensor 
		SoundSensor sensor = new SoundSensor(RaspiPin.GPIO_02);
		
		//=====================================================================
		// creates a thread for user inputs
		System.out.println("Loading User Input Thread...");
		InputRunnable inputRunnable = new InputRunnable(ai);
		Thread inputThread = new Thread(inputRunnable);
		
		//=====================================================================
		// main program
		boolean onButton = true;
		System.out.println("Awaiting command...");
		
		inputThread.start();
		while (onButton == true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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
