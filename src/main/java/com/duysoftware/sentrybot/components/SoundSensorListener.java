package com.duysoftware.sentrybot.components;

import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/**
 * Implements the IListener and GpioPinListenerDigital interface.
 * This Listener is attached to the AI and notifies it when the SoundSensor changes state.
 * @author Duy N
 * @author Jack T
 *
 */
public final class SoundSensorListener implements IListener, GpioPinListenerDigital {
	private AI ai;
	
	public SoundSensorListener(AI ai) {
		this.ai = ai;
	}
	
	//=========================================================================
	// Methods
	//=========================================================================
	
	/**
	 * Tells the AI to raise its alarm if its not already on.
	 */
	public void update() {
		if (!ai.isAlarmOn()) {
			ai.parse("redAlert");
		}
	}

	/**
	 * This method will call on update when the pin in the raspberry pi reaches a "HIGH" state.
	 */
	@Override
	public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
		if (event.getState().isHigh()) {
			update();
		}
	}

}
