package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Test;

import com.duysoftware.sentrybot.threads.InputRunnable;

public class AITest {

	Robot robot = new Robot();
	AI testAI = new AI(robot);
	
	@Test
	public void testPlaySoundWhichPlaySpecifiedWavFile() {
		testAI.playSound("goodbye.wav");
		assertEquals(true, testAI.wasSuccessful());
	}
	
	//@Test
	//public void testAlarmSubroutine() {
		//testAI.alarmSubroutine();
		//assertEquals(true, testAI.wasSuccessful());
	//}
	
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
		InputRunnable inputRunnable = new InputRunnable(testAI);
		Thread inputThread = new Thread(inputRunnable);
		inputThread.start();
		
		//testAI.parse("redAlert");
	
		assertEquals(false, testAI.alarmOn);
		
	}
}
