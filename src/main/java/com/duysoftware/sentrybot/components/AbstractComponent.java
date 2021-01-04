package com.duysoftware.sentrybot.components;

public abstract class AbstractComponent {
	private boolean successful;
	
	public boolean wasSuccessful() {
		return successful;
	}
	
	public void setSuccessStatus(boolean value) {
		successful = value;
	}
}
