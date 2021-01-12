package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MediaPlayerTest {

	MediaPlayer testMedia;
	
	@Before
	public void init() {
		testMedia = new MediaPlayer();
		
		// Comment out below if you want the full videos
		//testMedia.setDebugModeOn();
	}
	
	@Test
	public void testPlayVideoForRaiseAlarm() {
		testMedia.playVideo("raiseAlarm");
		assertEquals(true, testMedia.wasSuccessful());
	}
	
	@Test
	public void testPlayVideoForGoodbye() {
		testMedia.playVideo("goodbye");
		assertEquals(true, testMedia.wasSuccessful());
	}
	
	@Test
	public void testPlaySoundOnly() {
		testMedia.playSound("raiseAlarm");
		assertEquals(true, testMedia.wasSuccessful());
	}
	
	@Test
	public void testPlayImageOnly() {
		testMedia.playImage("search");
		assertEquals(true, testMedia.wasSuccessful());
	}
	
	@Test
	public void testPlayLaughVideo() {
		testMedia.playVideo("laugh");
		assertEquals(true, testMedia.wasSuccessful());
	}
	
	@Test
	public void testPlayVideoForSearching() {
		testMedia.playVideo("search");
		assertEquals(true, testMedia.wasSuccessful());
	}
	
	@Test
	public void testIfPlayVideoMultipleTimesWillClip() {
		testMedia.playVideo("search");
		testMedia.playVideo("goodbye");
	}
}
