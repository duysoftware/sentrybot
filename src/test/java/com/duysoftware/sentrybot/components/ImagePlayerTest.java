package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ImagePlayerTest {

	ImagePlayer testImagePlayer;
	
	@Before
	public void init() {
		testImagePlayer = new ImagePlayer();
		
		// Comment if you want video to play during testing.
		// testVideoPlayer.setDebugModeOn();
	}
	
	@Test
	public void testPlay() {
		testImagePlayer.play("raise_alarm.gif");
		
		assertEquals(true, testImagePlayer.wasSuccessful());
	}

}
