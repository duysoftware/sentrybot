package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MediaPlayerTest {

	MediaPlayer testMedia;
	
	@Before
	public void init() {
		System.out.println("Running MediaPlayerTest...");
		testMedia = new MediaPlayer();
		
		/* Comment out below if you want the full videos */
		testMedia.setDebugModeOn();
	}
	
	@Test
	public void testPlayVideoForRaiseAlarm2() {
		try {
			testMedia.playVideo("raiseAlarm2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(true, testMedia.wasSuccessful());
	}
	
	@Test
	public void testPlayVideoForGoodbye() {
		try {
			testMedia.playVideo("goodbye");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(true, testMedia.wasSuccessful());
	}
	
	@Test
	public void testPlayImageOnly() {
		try {
			testMedia.playImage("search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(true, testMedia.wasSuccessful());
	}
	
	@Test
	public void testPlayLaughVideo() {
		try {
			testMedia.playVideo("laugh");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(true, testMedia.wasSuccessful());
	}
	
	@Test
	public void testPlayVideoForSearching() {
		try {
			testMedia.playVideo("search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(true, testMedia.wasSuccessful());
	}
	
	@Test
	public void testIfPlayVideoMultipleTimesWillClip() {
		try {
			testMedia.playVideo("search");
			testMedia.playVideo("goodbye");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
