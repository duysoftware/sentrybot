package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pi4j.io.gpio.RaspiPin;

public class SoundSensorTest {

	@Test
	public void testSoundSensor() {
		if (System.getProperty("os.name").equals("Linux")) {
			SoundSensor testSensors = new SoundSensor(RaspiPin.GPIO_02);
			assertEquals(true, testSensors.wasSuccessful());
		} else {
			System.out.println("Don't run this test on windows or if the bot is not connected.");
			System.out.println("If this is the bot's OS, uncomment the code below.");
			
			//SoundSensor testSensors = new SoundSensor(RaspiPin.GPIO_02);
			//assertEquals(testSensors.wasSuccessful(), true);
			
			assert(true);
		}
	}
	
	@Test
	public void testTrigger() {
		if (System.getProperty("os.name").equals("Linux")) {
			SoundSensor testSensors = new SoundSensor(RaspiPin.GPIO_02);
			testSensors.testSensor();
			
			assertEquals(true, testSensors.querySensors());
		} else {	
			
			assert(true);
		}
	}
}
