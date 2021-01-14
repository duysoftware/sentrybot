package com.duysoftware.sentrybot.components;

import java.io.File;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author Duy N
 * @author Jack T
 *
 */
public class MediaPlayer extends AbstractComponent {
	private static String path = "src/main/java/com/duysoftware/sentrybot/media/";
	
	private boolean loop;
	
	//=========================================================================
	// Constructors
	//=========================================================================
	/**
	 * Creates a media player capable to playing videos, images, and sounds.
	 */
	public MediaPlayer() {
		super();
		this.loop = false;
		setSuccessStatus(true);
	}
	
	//=========================================================================
	// Accessors
	//=========================================================================	
	public void setLoop(boolean val) {
		loop = val;
	}
	
	public boolean isLooping() {
		return loop;
	}
	
	//=========================================================================
	// Methods
	//=========================================================================	
	/**
	 * Opens and plays the video.
	 * @param fileName Name of the file without the extension.
	 * @param showImage If true, will show the image.
	 * @param showSound If true, will play sound.
	 * @throws Exceptions: MalformedURL, LineUnavailable, IO, Interrupt
	 */
	public void playVideo(String fileName, 
						  boolean showImage, 
						  boolean allowSound) throws Exception {		
		setSuccessStatus(false);
		System.out.println("PLAYING " + fileName);
		
		/* Image Loading Portion */
		File imageFile = new File(path + fileName + ".gif");
		Icon icon = new ImageIcon(imageFile.toURI().toURL());
    	JLabel label = new JLabel(icon);
		JFrame frame = new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(label);
        frame.pack();
        frame.setSize(800, 480);
        frame.setLocationRelativeTo(null);

        /* Sound Loading Portion */
		File soundFile = new File(path + fileName + ".wav");	
		Clip clip = AudioSystem.getClip(null);
		clip.open(AudioSystem.getAudioInputStream(soundFile));
		
		/* If debug is on, sound will not play. Image won't show too. */
		if (!isDebugModeOn()) {
			
			/* Whether to show the image or not. */
			frame.setVisible(showImage);
			
			/* Whether to allow sound or not. */
			if (allowSound) {
				clip.start();
				/* Loop the video if user called playVideoWithLooping. */
				while (isLooping()) {
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				}
			}
			
			/* This thread will wait while the audio is playing. */
			Thread.sleep(clip.getMicrosecondLength()/1000); 
		}
		
		/* Closing and Cleanup */
		clip.close();
		frame.dispose();	
		System.out.println("Closing " + fileName);
		setSuccessStatus(true);
	}
	
	/**
	 * Plays the video with both sound and image enabled.
	 * @param fileName
	 * @throws Exception 
	 */
	public void playVideo(String fileName) throws Exception {
		playVideo(fileName, true, true);
	}
	
	/**
	 * Plays the video with looping enabled.
	 */
	public void playVideoWithLoop(String fileName) throws Exception {
		setLoop(true);
		playVideo(fileName, true, true);
		setLoop(false);
	}
	
	/**
	 * Shows only the image with no sounds.
	 * @param fileName
	 * @throws Exception 
	 */
	public void playImage(String fileName) throws Exception {
		playVideo(fileName, true, false);
	}
	
	/**
	 * Plays only the sound.
	 * @param fileName
	 * @throws Exception 
	 */
	public void playSound(String fileName) throws Exception {
		playVideo(fileName, false,  true);
	}
}
