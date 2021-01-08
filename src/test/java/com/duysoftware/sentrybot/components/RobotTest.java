package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {

	@Test
	public void testIfSpeakerIsAttached() {
		Robot robot = new Robot();
		assertEquals(true, robot.wasSuccessful());
	}

}
