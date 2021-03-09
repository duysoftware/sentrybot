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
		// User Configs - Feel free to change!
		//=====================================================================
		Configs.setScreenSize(800, 480); 		  // Default = (800, 480)
		Configs.setToCleanVersion(false); 		  // Default = false;
		Configs.setSoundPin(RaspiPin.GPIO_02);	  // Default = RaspiPin.GPIO_02
		Configs.setInfraredPin(RaspiPin.GPIO_03); // Default = RaspiPin.GPIO_03
		
		//===================================================================== 
		// Robot and AI Initialization
		//=====================================================================
		System.out.println("Starting main program...");
		System.out.println("Loading AI...");
		Robot spiderBot = new Robot();
		AI ai = new AI(spiderBot);
		
		/*  Creates the SoundSensor and adds a listener from the ai to it. */
		SoundSensor sensor = new SoundSensor(Configs.soundSensorPin);
		sensor.addSensorListener(new SensorListener(ai));
		
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
