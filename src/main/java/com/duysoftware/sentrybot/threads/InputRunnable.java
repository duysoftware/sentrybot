package com.duysoftware.sentrybot.threads;

import java.util.Scanner;

import com.duysoftware.sentrybot.components.AI;

public class InputRunnable implements Runnable {

	private AI ai;
	
	public InputRunnable(AI ai) {
		this.ai = ai;
	}
	
	
	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		boolean close = false;
		while (!close) {
			System.out.println("Enter Command: ");
			String command = scan.next();
			
			ai.parse(command);
			
			if (command.equals("close")) {
				System.out.println("Input commands closed!");
				close = true;
				scan.close();
			}
		}
	}
}
