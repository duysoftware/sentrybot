package com.duysoftware.sentrybot;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

public class Configs {
	/* Size for the display screen of Raspberry Pi
	 * Default screenWidth = 800, screenHeight = 480 
	 */
	public static int screenWidth = 800;
	public static int screenHeight = 480;
	
	/* cleanVersion = false will allow bot to use more meme videos for its actions. */
	public static boolean cleanVersion = false;
	
	public static Pin soundSensorPin = RaspiPin.GPIO_02;
	public static Pin infraredSensorPin = RaspiPin.GPIO_03;
	
	//=========================================================================
    // Setters and Getters
	//=========================================================================
	/**
	 * Sets the size of the display screen
	 * @param screenWidth pixel count of width
	 * @param screenHeight pixel count of height
	 */
	public static void setScreenSize(int screenWidth, int screenHeight) {
		if (screenWidth >= 1 && screenHeight >= 1) {
			Configs.screenWidth = screenWidth;
			Configs.screenHeight = screenHeight;
		}
	}
	
	/**
	 * False will make bot play more memes. True for standard usage.
	 * @param b set to true or false depending on which version
	 */
	public static void setToCleanVersion(boolean b) {
		Configs.cleanVersion = b;
	}
	
	/**
	 * Sets the soundSensorPin to p;
	 * @param p Use Raspi.GPIO_02 or wherever you plugged in the sensor.
	 */
	public static void setSoundPin(Pin p) {
		Configs.soundSensorPin = p;
	}
	
	/**
	 * Sets the infraredSensorPin to p;
	 * @param p Use Raspi.GPIO_03 orr wherever you plugged in the sensor.
	 */
	public static void setInfraredPin(Pin p) {
		Configs.infraredSensorPin = p;
	}
	
}
