package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VideoPlayerTest {

	VideoPlayer testVideoPlayer;
	
	@Before
	public void init() {
		testVideoPlayer = new VideoPlayer();
		
		// Comment if you want video to play during testing.
		//testVideoPlayer.setDebugModeOn();
	}
	
	@Test
	public void testPlay() {
		testVideoPlayer.play("heheh.gif");
		
		assertEquals(true, testVideoPlayer.wasSuccessful());
	}

}
