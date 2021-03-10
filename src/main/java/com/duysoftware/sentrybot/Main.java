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
		// User Configurations - Feel free to change!
		//=====================================================================
		System.out.println("Loading configurations...");
		Configs.setScreenSize(800, 480); 		  // Default = (800, 480)
		Configs.setToCleanVersion(false); 		  // Default = false;
		
		Configs.setSoundPin1(RaspiPin.GPIO_02);	  // Default = RaspiPin.GPIO_02
		Configs.setInfraredPin1(RaspiPin.GPIO_03); // Default = RaspiPin.GPIO_03
		Configs.setInfraredPin2(RaspiPin.GPIO_04); // Default = RaspiPin.GPIO_04
		
		//===================================================================== 
		// Robot, AI, and Sensor Initializations
		//=====================================================================
		System.out.println("Loading Bot...");
		SentryBot sentryBot = new SentryBot();

		//=====================================================================
		// Thread for User Input
		//=====================================================================
		System.out.println("Loading User Input Thread...");
		InputRunnable inputRunnable = new InputRunnable(sentryBot.getAI());
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
