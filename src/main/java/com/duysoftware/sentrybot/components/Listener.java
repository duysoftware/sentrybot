package com.duysoftware.sentrybot.components;

/**
 * Interface for a typical Listener/Observer class. Just need to implement the update method.
 * @author Duy N
 * @author Jack T
 *
 */
public interface Listener {
	
	/**
	 * Will ping the AI that is waiting on this listener. Make sure the AI is connected before
	 * calling this.
	 */
	public void update();
	
	/**
	 * Attaches the AI with this listener
	 * @param ai
	 */
	public void setAI(AI ai);
}
