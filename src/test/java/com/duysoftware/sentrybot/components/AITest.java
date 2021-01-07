package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Test;

public class AITest {

	Robot robot = new Robot();
	AI testAI = new AI(robot);
	
	@Test
	public void testPlaySound() {
		testAI.playSound("hello.wav");
		assertEquals(true, testAI.wasSuccessful());
	}
	
	@Test
	public void testAlarmSubroutine() {
		testAI.alarmSubroutine();
		assertEquals(true, testAI.wasSuccessful());
	}
	
	@Test
	public void testHoldTheLine() {
		testAI.holdTheLineSubroutine();
		assertEquals(true, testAI.wasSuccessful());
	}
}
