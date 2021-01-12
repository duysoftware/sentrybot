package com.duysoftware.sentrybot.threads;

import com.duysoftware.sentrybot.components.AI;

public class ImagePlayerRunnable implements Runnable {

private AI ai;
	
	//=========================================================================
	// Constructors
	//=========================================================================
	public ImagePlayerRunnable(AI ai) {
		this.ai = ai;
	}
	
	//=========================================================================
	// Methods
	//=========================================================================
	@Override
	public void run() {
		while (true) {
			if (ai.getStatus().equals("RUNNING raiseAlarm")) {
				// TODO play video if status is playing a sound
				System.out.println("FROM THREAD: PLAYING VIDEO FOR SOUND FILE");
				
				// TODO to stop the spamming, will remove when video player is
				// implemented
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				// TODO maybe stop the video  abruptly if sound is over
			}
		}
	}
}
