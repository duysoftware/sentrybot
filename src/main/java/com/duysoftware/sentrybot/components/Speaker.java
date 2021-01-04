package com.duysoftware.sentrybot.components;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Speaker extends AbstractComponent {
	private static String pathForLinux = "sounds/files/";
	private static String pathForWindows = "src/main/java/com/duysoftware/sentrybot/sounds/";
	private static String path;
	
	public Speaker() {
		if (System.getProperty("os.name").equals("Linux")) {
			path = pathForLinux;
		} else {
			path = pathForWindows;
		}
		
		setSuccessStatus(false);
	}
	
	/**
	 * Opens and plays the sound file.
	 * @param fileName The name of the file as .wav file. Example = "file.wav"
	 */
	public void play(String fileName) {
		setSuccessStatus(false);
		
		try {
			File soundFile = new File(path + fileName);
			
			Clip clip = AudioSystem.getClip(null);
			clip.open(AudioSystem.getAudioInputStream(soundFile));
			clip.start();
			
			System.out.println("PLAYING " + fileName);
			
			Thread.sleep(clip.getMicrosecondLength()/1000); 
			
			clip.close();
			System.out.println("CLOSED " + fileName);
			
			setSuccessStatus(true);
		} 
		catch (Exception e) {
			File current = new File(".");
			System.out.printf("%nCurrentLocation is: %s %n%n", current.getAbsolutePath());
			e.printStackTrace(System.out);
		}
	}
}
