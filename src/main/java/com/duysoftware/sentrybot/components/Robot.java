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
	 * Play the given sound file
	 * @param fileName String of the name of the soundfile in media.
	 */
	public void playSound(String fileName) {
		setSuccessStatus(false);
		try {
			mediaPlayer.playSound(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSuccessStatus(mediaPlayer.wasSuccessful());
	}
	
	/**
	 * Show the given image.
	 * @param fileName String of the name of the image file in media.
	 */
	public void showImage(String fileName) {
		setSuccessStatus(false);
		try {
			mediaPlayer.playImage(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSuccessStatus(mediaPlayer.wasSuccessful());
	}
	
	/**
	 * Play the given video.
	 * @param videoName Name of video to be shown.
	 */
	public void playVideo(String videoName) {
		setSuccessStatus(false);
		try {
			mediaPlayer.playVideo(videoName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSuccessStatus(mediaPlayer.wasSuccessful());
	}
	
	/**
	 * Play the given video and loop it.
	 * @param videoName Name of video to be shown.
	 */
	public void playVideoWithLoops(String videoName) {
		setSuccessStatus(false);
		try {
			mediaPlayer.playVideoWithLoop(videoName);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
