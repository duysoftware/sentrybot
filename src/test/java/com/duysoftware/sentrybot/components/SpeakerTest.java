package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpeakerTest {

	@Test
	public void testPlay() {
		Speaker testSpeakers = new Speaker();
		
		testSpeakers.play("autotune.wav");
		
		assertEquals(true, testSpeakers.wasSuccessful());
	}

}
