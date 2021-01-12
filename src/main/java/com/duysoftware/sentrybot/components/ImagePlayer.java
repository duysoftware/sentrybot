package com.duysoftware.sentrybot.components;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Play
 * @author Duy N
 * @author Jack T
 *
 */
public class ImagePlayer extends AbstractComponent {
	private static String path = "src/main/java/com/duysoftware/sentrybot/gifs/";
	
	//=========================================================================
	// Constructors
	//=========================================================================
	/**
	 * 
	 */
	public ImagePlayer() {
		super();
		setSuccessStatus(true);
	}
	
	//=========================================================================
	// Methods
	//=========================================================================
	/**
	 * Opens a gif file and plays it.
	 * @param fileName Name of the gif file as "nameOfGif.gif"
	 */
	public void play(String fileName) {
		setSuccessStatus(false);
		
        try {
        	File imageFile = new File(path + fileName);
        	
        	Icon icon = new ImageIcon(imageFile.toURI().toURL());
        	JLabel label = new JLabel(icon);
        	
        	// The Frame part
            JFrame frame = new JFrame();	
            frame.setUndecorated(true);
            frame.getContentPane().add(label);
            
            // resizes the window
            //frame.pack();
            
            //frame.setSize(1920, 1080);
            frame.setVisible(true);  
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);

            
            setSuccessStatus(true);
        } catch (Exception e) {
        	System.out.println("Video player didnt work");
        	e.printStackTrace();
        }
	}
}
