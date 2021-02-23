package com.duysoftware.sentrybot.components;

/**
 * Interface for a typical Listener/Observer class. Just need to implement the update method.
 * @author Duy N
 * @author Jack T
 *
 */
public interface IListener {
	
	/**
	 * Notifying the listeners/observers will call this method.
	 * Update will usually call methods from classes that was waiting on the
	 * listener.
	 */
	public void update();
}
