package com.duysoftware.sentrybot.threads;

import com.duysoftware.sentrybot.components.AI;

public class StopActionsRunnable implements Runnable{
	private AI ai;
	
	public StopActionsRunnable(AI ai) {
		this.ai = ai;
	}
	
	@Override
	public void run() {
		while (true) {
			if (ai.isAlarmOn()) {
				ai.parse("alarmOff");
			}
		}
	}
}
