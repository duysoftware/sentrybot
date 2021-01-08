package com.duysoftware.sentrybot.components;

/**
 * The frame of the robot. This class controls the components that are attached to it. 
 * @author Duy N
 * @author Jack T
 *
 */
public class Robot extends AbstractComponent {
	private Speaker speaker;
	
	//=========================================================================
	// Constructors
	//=========================================================================
	public Robot() {
		this.speaker = new Speaker();
		
		setSuccessStatus(true);
	}
	
	//=========================================================================
	// Actions
	//=========================================================================
	/** 
	 * Calls on the attached speakers to play the given file.
	 * @param fileName String of the name of the soundfile in sounds.
	 */
	public void playSound(String fileName) {
		setSuccessStatus(false);
		speaker.play(fileName);
		setSuccessStatus(speaker.wasSuccessful());
	}
}
