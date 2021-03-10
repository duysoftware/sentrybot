package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pi4j.io.gpio.RaspiPin;

/**
 * Unit test for the Sound Sensor class.
 * @author Duy N
 * @author Jack T
 *
 */
public class SensorTest {
	Sensor testSensors;
	
	@Before
    public void init() {
		if (System.getProperty("os.name").equals("Linux")) {
			testSensors = new Sensor(RaspiPin.GPIO_02);
		} else {
			System.out.println("SoundSensor tests won't fully run on windows or if the bot is not connected.");
			
			//If this is the bot's OS, uncomment the code below.
			// testSensors = new SoundSensor(RaspiPin.GPIO_02);
		}
	}
	
	@Test
	public void testSoundSensor() {
		if (System.getProperty("os.name").equals("Linux")) {
			assertEquals(true, testSensors.wasSuccessful());
		} else {
			assert(true);
		}
	}
}
