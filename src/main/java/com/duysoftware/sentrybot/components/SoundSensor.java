package com.duysoftware.sentrybot.components;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public final class SoundSensor extends AbstractComponent {
	final private GpioController gpio;
	final private GpioPinDigitalInput input;
	
	private boolean detected;
	
	public SoundSensor(Pin pin) {
		this.gpio = GpioFactory.getInstance();
		
		// makes the digital input pin with the given pinNumber
		this.input = gpio.provisionDigitalInputPin(pin, PinPullResistance.PULL_DOWN);
		
		input.setShutdownOptions(true);
		
		 // create and register gpio pin listener
        input.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
                if (event.getState().isHigh()) {
                	detected = true;
                }        
            }
        });
        
		detected = false;
		
		setSuccessStatus(true);
	}
	
	/**
	 * Changes the detected variable back to false;
	 */
	public void reset() {
		detected = false;
	}
	
	/**
	 * Checks the state of the sensors to see if it detected anything.
	 * 
	 * @return true if sensor has detected something.
	 */
	public boolean querySensors() {
		return detected;
	}
}
