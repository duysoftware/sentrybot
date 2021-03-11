package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pi4j.io.gpio.RaspiPin;

/**
 * Unit test for the robot frame. 
 * @author Duy N
 * @author Jack T
 *
 */
public class SentryBotTest {
	SentryBot robot;
	
	@Before
    public void init() {
		System.out.println("Running SentryBotTest...");
		robot = new SentryBot();
		// Comment out below for full video
		robot.setDebugModeOn();
	} 
	
	@Test
	public void testIfSpeakerIsAttached() {
		assertEquals(true, robot.wasSuccessful());
	}
	
	@Test 
	public void testShowImageJustByItSelf() {
		robot.showImage("laugh");
		assertEquals(true, robot.wasSuccessful());
	}
	
	@Test
	public void testPlayVideoWithImageAndSound() {
		robot.playVideo("raiseAlarm");
		assertEquals(true, robot.wasSuccessful());		
	}
	
	@Test
	public void testForVideosPlayedAfterOneAnother() {
		robot.playVideo("raiseAlarm2");
		robot.playVideo("goodbye");
		assertEquals(true, robot.wasSuccessful());
	}
	
	

}
