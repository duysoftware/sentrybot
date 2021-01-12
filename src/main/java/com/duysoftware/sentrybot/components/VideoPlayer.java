package com.duysoftware.sentrybot.components;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.duysoftware.sentrybot.Main;

/**
 * 
 * @author Duy N
 * @author Jack T
 *
 */
public class VideoPlayer extends AbstractComponent {
	private static String path = "gifs/";
	
	//=========================================================================
	// Constructors
	//=========================================================================
	/**
	 * 
	 */
	public VideoPlayer() {
		super();
		setSuccessStatus(true);
	}
	
	//=========================================================================
	// Methods
	//=========================================================================
	/**
	 * 
	 * @param fileName
	 */
	public void play(String fileName) {
		setSuccessStatus(false);
		
        try {
        	URL url = Main.class.getResource(path + fileName);
        	System.out.println(url.getPath());
        	Icon icon = new ImageIcon(url);
        	JLabel label = new JLabel(icon);
        	
        	// The Frame part
            JFrame frame = new JFrame();	
            frame.setUndecorated(true);
            frame.getContentPane().add(label);
            
            // resizes the window
            //frame.pack();
            
            frame.setSize(1920, 1080);
            frame.setVisible(true);  
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            
            if (!isDebugModeOn()) {
            	Thread.sleep(5000);	
            }
            
            setSuccessStatus(true);
        } catch (Exception e) {
        	System.out.println("Video player didnt work");
        	e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		VideoPlayer vid = new VideoPlayer();
		vid.play("heheh.gif");
	}
}
