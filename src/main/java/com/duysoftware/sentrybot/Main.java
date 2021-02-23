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
		
		/*  Creates the SoundSensor and adds a listener from the ai to it. */
		SoundSensor sensor = new SoundSensor(RaspiPin.GPIO_02);
		sensor.addListener(ai.getSoundListener());
		
		//=====================================================================
		// Thread for User Input
		//=====================================================================
		System.out.println("Loading User Input Thread...");
		InputRunnable inputRunnable = new InputRunnable(ai);
		Thread inputThread = new Thread(inputRunnable);
		
		//=====================================================================
		// Main
		//=====================================================================
		System.out.println("Awaiting command...");
		boolean onButton = true;
		
		/* Thread stuff */
		inputThread.start();
		
		/* main process */
		while (onButton == true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
