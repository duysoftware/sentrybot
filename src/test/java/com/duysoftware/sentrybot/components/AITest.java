package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.duysoftware.sentrybot.threads.StopActionsRunnable;

public class AITest {

	SentryBot robot;
	AI testAI;

	@Before
    public void init() {
		System.out.println("Running AITest...");
		robot = new SentryBot();
		testAI = robot.getAI();
		
		// Comment out below line if you need to hear the audio
		robot.setDebugModeOn();
	}   
        
	@Test
	public void testPlaySoundWhichPlaySpecifiedWavFile() {
		testAI.playSound("goodbye");
		assertEquals(true, testAI.wasSuccessful());
	}
	
	@Test
	public void testHoldTheLineSubroutinePlayingYouShallNotPassWav() {
		testAI.holdTheLineSubroutine();
		assertEquals(true, testAI.wasSuccessful());
	}
	
	@Test
	public void testGoodbyeBuddySmooch() {
		testAI.goodbyeSubroutine();
		assertEquals(true, testAI.wasSuccessful());
	}
	
	@Test
	public void testAlarmTurningOff() {
		StopActionsRunnable stop = new StopActionsRunnable(testAI);
		Thread thread = new Thread(stop);
		thread.start();
		
		testAI.parse("redAlert");
		
		assertEquals(false, testAI.isAlarmOn());	
	}
	
	@Test
	public void testRaiseAlarm() {
		testAI.parse("raiseAlarm");
		assertEquals(true, testAI.wasSuccessful());
	}
	
	@Test
	public void testReminderSeeingIfItCyclesThroughTheBank() {
		testAI.parse("joke");
		assertEquals(true, testAI.wasSuccessful());
	}
}
