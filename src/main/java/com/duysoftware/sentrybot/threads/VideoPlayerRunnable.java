package com.duysoftware.sentrybot.threads;

import com.duysoftware.sentrybot.components.AI;

public class VideoPlayerRunnable implements Runnable {

private AI ai;
	
	//=========================================================================
	// Constructors
	//=========================================================================
	public VideoPlayerRunnable(AI ai) {
		this.ai = ai;
	}
	
	//=========================================================================
	// Methods
	//=========================================================================
	@Override
	public void run() {
		while (true) {
			if (ai.getStatus().equals("RUNNING raiseAlarm")) {
				// TODO
				System.out.println("Playing video for raiseAlarm");
			}
		}
	}
}
