package com.duysoftware.sentrybot.components;

/**
 * All components will share a "successful" variable and a debugMode 
 * to use for testing.
 * @author Duy N
 * @author Jack T
 *
 */
public abstract class AbstractComponent {
	private boolean successful;
	private boolean debugModeOn;
	
	//=========================================================================
	// Constructors
	//=========================================================================
	/**
	 * Sets variables successful, debugModeOn to: false.
	 */
	protected AbstractComponent() {
		this.successful = false;
		this.debugModeOn = false;
	}
	
	//=========================================================================
	// Accessors
	//=========================================================================
	/**
	 * Mostly used by test to check whether components ran correctly
	 * @return true if component ran
	 */
	public boolean wasSuccessful() {
		return successful;
	}
	
	/**
	 * Set to false if the component failed to use its function.
	 * @param value
	 */
	public void setSuccessStatus(boolean value) {
		successful = value;
	}
	
	/**
	 * See if component is in debug mode.
	 * @return
	 */
	public boolean isDebugModeOn() {
		return debugModeOn;
	}
	
	/**
	 * Turn debug mode on. Usually components with this mode on will not play
	 * videos or sound. Allows for easier unit testing.
	 */
	public void setDebugModeOn() {
		debugModeOn = true;
	}	
}
