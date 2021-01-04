package com.duysoftware.sentrybot.components;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/**
 * Class that handles the interaction between the actual sound sensor device 
 * and the io of the raspberry Pi. This class object should be queried 
 * constantly to see if its detected variable has changed.
 * @author Duy N
 * @author Jack T
 *
 */
public final class SoundSensor extends AbstractComponent {
	final private GpioController gpio;
	final private GpioPinDigitalInput input;
	
	private boolean detected;
	
	/**
	 * Creates the sensor object and adds a listener for when the device picks
	 * up loud sounds.
	 * @param pin - default is RaspiPin.GPIO_02. Check the Raspberry Pi 3 IO
	 * chart to see which pin the sound sensor is connected to.
	 */
	
	public SoundSensor(Pin pin) {
		// creates an instance of the gpio controller
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
