package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for the robot frame. 
 * @author Duy N
 * @author Jack T
 *
 */
public class RobotTest {
	Robot robot;
	
	@Before
    public void init() {
		robot = new Robot();
		
		// Comment out below line if you need to hear the audio
		robot.setDebugModeOn();
	} 
	
	@Test
	public void testIfSpeakerIsAttached() {
		assertEquals(true, robot.wasSuccessful());
	}

}
