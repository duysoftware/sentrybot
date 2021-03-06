package com.duysoftware.sentrybot.components;

import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;


/**
 * Implements the Listener and GpioPinListenerDigital interface.
 * This Listener is attached to the AI and notifies it when the SoundSensor changes state.
 * @author Duy N
 * @author Jack T
 *
 */
public class SensorListener implements Listener, GpioPinListenerDigital {
	private AI ai;
	private SensorID sensorId;
	
	public SensorListener(AI ai, SensorID id) {
		this.ai = ai;
		this.sensorId = id;
	}
	
	//=========================================================================
    // Setters and Getters
	//=========================================================================
	public void setAI(AI ai) {
		this.ai = ai;
	}
	
	//=========================================================================
    // Functional Methods
	//=========================================================================
	@Override
	public void update() {
		ai.alertAi(sensorId);
	}
	
	@Override
	public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
		if (event.getState().isHigh()) {
			update();
		}
	}
}
