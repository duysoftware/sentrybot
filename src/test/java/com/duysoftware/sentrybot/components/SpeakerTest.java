package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for the speakers.
 * @author Duy N
 * @author Jack T
 *
 */
public class SpeakerTest {
	Speaker testSpeakers;
	
	@Before
    public void init() {
		testSpeakers = new Speaker();
		
		// Comment out below line if you need to hear the audio
		testSpeakers.setDebugModeOn();
	} 
	
	@Test
	public void testPlay() {
		testSpeakers.play("autotune.wav");
		
		assertEquals(true, testSpeakers.wasSuccessful());
	}

}
