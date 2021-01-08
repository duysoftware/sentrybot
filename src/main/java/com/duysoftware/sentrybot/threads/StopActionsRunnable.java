package com.duysoftware.sentrybot.threads;

import com.duysoftware.sentrybot.components.AI;

public class StopActionsRunnable implements Runnable{
	private AI ai;
	
	//=========================================================================
	// Constructors
	//=========================================================================
	public StopActionsRunnable(AI ai) {
		this.ai = ai;
	}
	
	//=========================================================================
	// Methods
	//=========================================================================
	@Override
	public void run() {
		while (true) {
			if (ai.isAlarmOn()) {
				ai.parse("alarmOff");
			}
		}
	}
}
