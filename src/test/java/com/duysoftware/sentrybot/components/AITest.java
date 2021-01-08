package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Test;

import com.duysoftware.sentrybot.threads.StopActionsRunnable;

public class AITest {

	Robot robot = new Robot();
	AI testAI = new AI(robot);
	
	@Test
	public void testPlaySoundWhichPlaySpecifiedWavFile() {
		testAI.playSound("goodbye.wav");
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
		StopActionsRunnable  stop = new StopActionsRunnable(testAI);
		Thread thread = new Thread(stop);
		thread.start();
		
		testAI.parse("redAlert");
		
		thread.stop();
		assertEquals(false, testAI.isAlarmOn());	
	}
}
