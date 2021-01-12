package com.duysoftware.sentrybot.components;

/**
 * The frame of the robot. This class controls the components that are attached to it. 
 * @author Duy N
 * @author Jack T
 *
 */
public class Robot extends AbstractComponent {
	private MediaPlayer mediaPlayer;
	
	//=========================================================================
	// Constructors
	//=========================================================================
	public Robot() {
		super();
		this.mediaPlayer = new MediaPlayer();
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
		mediaPlayer.playSound(fileName);
		setSuccessStatus(mediaPlayer.wasSuccessful());
	}
	
	/**
	 * Calls on the image player to show the given file.
	 * @param fileName String of the name of the image file in gifs.
	 */
	public void showImage(String fileName) {
		setSuccessStatus(false);
		mediaPlayer.playImage(fileName);
		setSuccessStatus(mediaPlayer.wasSuccessful());
	}
	
	/**
	 * Combines playSound and showImage to simulate a video.
	 * @param videoName Name of video to be shown.
	 */
	public void playVideo(String videoName) {
		setSuccessStatus(false);
		mediaPlayer.playVideo(videoName);
		setSuccessStatus(mediaPlayer.wasSuccessful());
	}
	
	
	//=========================================================================
	// Override Methods
	//=========================================================================
	@Override
	public void setDebugModeOn() {
		super.setDebugModeOn();
		
		mediaPlayer.setDebugModeOn();
	}
	
}
