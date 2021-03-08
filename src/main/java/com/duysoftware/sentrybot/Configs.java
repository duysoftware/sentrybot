package com.duysoftware.sentrybot;

public class Configs {
	
	/* cleanVersion = false will allow bot to use more meme videos for its actions. */
	public static boolean cleanVersion = false;
	
	/* Size for the display screen of Raspberry Pi
	 * Default screenWidth = 800, screenHeight = 480 
	 */
	public static int screenWidth = 800;
	public static int screenHeight = 480;
	
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
	
}
