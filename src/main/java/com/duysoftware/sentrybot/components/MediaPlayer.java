package com.duysoftware.sentrybot.components;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MediaPlayer extends AbstractComponent {
	private static String path = "src/main/java/com/duysoftware/sentrybot/media/";
	
	JFrame frame;
	
	//=========================================================================
	// Constructors
	//=========================================================================
	public MediaPlayer() {
		super();
			
		setSuccessStatus(true);
	}
	
	//=========================================================================
	// Methods
	//=========================================================================	
	/**
	 * Opens and plays the video.
	 * @param fileName Name of the file without the extension.
	 * @param showImage If true, will show the image.
	 * @param showSound If true, will play sound.
	 */
	public void playVideo(String fileName, boolean showImage, boolean allowSound) {
		setSuccessStatus(false);
		System.out.println("PLAYING " + fileName 
							+ ", with Image: " + showImage
							+ ", with Audio: " + allowSound);
		// TODO find better place to put this.
		JFrame frame = new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Image portion
		if (showImage) {
			try {
				File imageFile = new File(path + fileName + ".gif");
	        	
	        	Icon icon = new ImageIcon(imageFile.toURI().toURL());
	        	JLabel label = new JLabel(icon);
	        	
	        	// Adds our image to this frame	
	            frame.getContentPane().add(label);
	            
	            //frame.setSize(1920, 1080);
	            frame.setVisible(true);  
	            frame.pack();
	            frame.setLocationRelativeTo(null);
	            
	            // changed to false to show image has been loaded.
	            showImage = false;
			} 
			catch (Exception e) {
				System.out.println("ERROR: Image failed to load.");
				e.printStackTrace();
			}
			
		}
		
		// Sound Portion
		if (allowSound) {
			try {
				File soundFile = new File(path + fileName + ".wav");
				
				Clip clip = AudioSystem.getClip(null);
				clip.open(AudioSystem.getAudioInputStream(soundFile));
				clip.start();
				
				// If debug is on, sound will not play. Image won't show too.
				if (!isDebugModeOn()) {
					Thread.sleep(clip.getMicrosecondLength()/1000); 
				}
				
				clip.close();
				
				// changed to false to show sound has been loaded.
				allowSound = false;
			} 
			catch (Exception e) {
				System.out.println("ERROR: Sound failed to load.");
				e.printStackTrace();
			}
		}
		
		frame.dispose();
		
		System.out.println("Closing file " + fileName);
		setSuccessStatus(!showImage && !allowSound);
	}
	
	/**
	 * Plays the video with both sound and image enabled.
	 * @param fileName
	 */
	public void playVideo(String fileName) {
		playVideo(fileName, true, true);
	}
	
	/**
	 * Shows only the image with no sounds.
	 * @param fileName
	 */
	public void playImage(String fileName) {
		playVideo(fileName, true, false);
	}
	
	/**
	 * Plays only the sound.
	 * @param fileName
	 */
	public void playSound(String fileName) {
		playVideo(fileName, false,  true);
	}
}
