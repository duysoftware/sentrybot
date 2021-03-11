package com.duysoftware.sentrybot.components;

import com.duysoftware.sentrybot.Configs;
import com.pi4j.io.gpio.RaspiPin;

/**
 * The frame of the robot. This class controls the components that are attached to it. 
 * @author Duy N
 * @author Jack T
 *
 */
public class SentryBot extends AbstractComponent {
	
	private AI ai;
	private MediaPlayer mediaPlayer;
	
	private Sensor soundSensor01;
	private Sensor infraredSensor01;
	
	//=========================================================================
	// Constructors
	//=========================================================================
	public SentryBot() {
		super();
		
		this.ai = new AI(this);
		this.mediaPlayer = new MediaPlayer();
		
		// Loading these sensors require the Pi libraries
		if (System.getProperty("os.name").equals("Linux")) {
			this.soundSensor01 = new Sensor(RaspiPin.GPIO_02);
			this.infraredSensor01 = new Sensor(RaspiPin.GPIO_03);
			
			soundSensor01.addListener(new SensorListener(ai, SensorID.Sound01));
			infraredSensor01.addListener(new SensorListener(ai, SensorID.Infra01));
		} 
		
		setSuccessStatus(true);
	}
	
	//=========================================================================
	// Setters and Getters
	//=========================================================================
	/**
	 * Returns this bot's AI
	 * @return
	 */
	public AI getAI() {
		return ai;
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
