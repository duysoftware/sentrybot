package com.duysoftware.sentrybot.components;

/**
 * All components will share a "successful" variable to use for testing.
 * @author Duy N
 * @author Jack T
 *
 */
public abstract class AbstractComponent {
	private boolean successful;
	
	//=========================================================================
	// Methods
	//=========================================================================
	/**
	 * Mostly used by test to check whether components ran correctly
	 * @return true if component ran
	 */
	public boolean wasSuccessful() {
		return successful;
	}
	
	public void setSuccessStatus(boolean value) {
		successful = value;
	}
}
