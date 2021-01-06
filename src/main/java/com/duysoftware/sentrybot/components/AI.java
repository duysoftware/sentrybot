package com.duysoftware.sentrybot.components;

import java.util.HashMap;
import java.util.Random;

public class AI extends AbstractComponent {

	private HashMap<String, Runnable> decisions;
	
	private Robot robot;
	
	private boolean sentryMode;
	private boolean busy;
	private String status;
	
	private boolean searching;
	
	private String[] jokeBank = {"joke1.wav", "joke2.wav", "joke3.wav"};
	
	/**
	 * Forms a new AI unit and connects it to some robotic framework.
	 */
	public AI(Robot robot) {
		this.robot = robot;
		
		this.sentryMode = true;
		this.busy = false;
		this.status = "standby";
		
		this.searching = false;
		
		// loading available decisions of ai
		createDecisionMap();
	}
	
	/**
	 * Checks to see if bot is in sentry mode.
	 * @return true if bot is in sentry mode.
	 */
	public boolean onSentryMode() {
		return sentryMode;
	}
	/**
	 * Returns the current status of the unit.
	 * @return status - a string describing what the unit is doing or has done.
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Returns whether ai is busy.
	 * @return busy - boolean variable that is true when ai is running a process.
	 */
	public boolean isBusy() {
		return busy;
	}
	
	/**
	 * Changes the busy and status variable depending on whether this is called
	 * at the start or end of the ai's action.
	 * @param startOrEnd String that denotes whether the ai's action is
	 * 		  starting or completed.
	 * @param process Name of the method currently being called.
	 */
	private void update(String startOrEnd, String process) {
		if ("start".equals(startOrEnd)) {
			busy = true;
			this.status = "RUNNING " + process;
		} else if ("end".equals(startOrEnd)) {
			busy = false;
			this.status = "COMPLETED " + process;
		}
		
		System.out.println(this.status);
	}
	
	/**
	 * Forms the decisions map and loads it with available actions.
	 * New actions will be added to this as we develop them.
	 */
	private void createDecisionMap() {
		decisions = new HashMap<String, Runnable>();
		
		decisions.put("raiseAlarm", () -> raiseAlarm());
		decisions.put("mourn", () -> mourn());
		decisions.put("joke", () -> joke());
		decisions.put("greet", () -> greet());
		decisions.put("insult", () -> insult()); 
	}
	
	/**
	 * Makes a decision based on given input.
	 * @param input Can be a command, sensory data from sensors, etc.
	 */
	public void parse(String input) {
		if (!busy) {	
			if (decisions.containsKey(input)) {
				decisions.get(input).run();
			} else {
				System.out.print("AI COMMAND: " + input + " NOT RECOGNIZED");
			}
		}
	}
	//####################### SUBROUTINES #######################
	
	/**
	 * A routine to check and search for intruders.
	 */
	public void alarmSubroutine() {
		// Temporary value for intruder
		int temporaryLoop = 0;
		
		while (temporaryLoop++ < 5) {
			raiseAlarm();
			
			search();
		}
	}
	
	/**
	 * A routine when the robot is chilling.
	 */
	public void idleSubroutine() {
		idle();
	}
	
	/**
	 * A routine to apprehend an intruder.
	 */
	public void holdTheLineSubroutine() {
		update("start", "hold the line");
		playSound("shallnotpass.wav");
		update("end", "hold the line");
	}
		
		// Your plans from main
				/**
				 * //Bot has detected an intruder
					while (gpIOSignal)
					{
						spiderBot.raiseAlarm("stepbrobot.wav");
						
						//Ideally, signal is lost wants to play an extra ten seconds of the alarm
						if (!gpIOSignal)
						{
							lostTarget = true;
							spiderBot.raiseAlarm("shallnotpass.wav");
						}
					}
					
					//After ten seconds passes, goes to search mode(?) and creates this alarm for maybe 15-30 seconds
					//Can think of this as a cat & mouse chase
					if (!gpIOSignal && lostTarget)
					{
						spiderBot.searchMode();
						spiderBot.raiseAlarm("ara-ara.wav"); //Continuously plays
					}
					
					//If the bot finds something/someone
					else
					{
						lostTarget = false;
						spiderBot.raiseAlarm("alert.wav"); //Ideally, Jack wants this to just use this alarm once and repeat the while loop
						
						while (gpIOSignal)
						{
							spiderBot.raiseAlarm("succ.wav");
						}
					}
				 */
	
	//######################### ACTIONS #########################
	/**
	 * A generic method for the robot to play sound in subroutines.
	 * @param filename
	 */
	public void playSound (String filename) {
		robot.playSound(filename);
	}
	
	/**
	 * Make the robot play audio files to simulate an alarm.
	 */
	public void raiseAlarm() {
		update("start", "raiseAlarm");
		
		robot.playSound("nani.wav");
		
		searching = true;
		
		update("end", "raiseAlarm");
	}
	
	/**
	 * Make the robot search around an area(?) while playing "search" alarm.
	 */
	public void search() {
		int loop = 0;
		while (searching && loop++ < 5) {
			update("start", "search");
			
			// TODO Print out "Robot is searching" and play some sound
			robot.playSound("ara-ara.wav");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			update("end", "search");
		}
	}
	
	/**
	 * Make the robot wait and standby for a specific amount of time.
	 */
	public void idle() {
		//TODO idle with non-stop movement and play a sound until the user tells it to stop being in idle
		// Do we want this to be a command thing or a certain amount of time thing?
		
		/**
		 * while (movement == true)
		 * {
		 * 		robot.playSound("idle.wav");
		 * }
		 */
		
	}
	
	/**
	 * Make the robot greet its user
	 */
	public void greet() {
		update("start", "greet");
		
		//TODO greet using sound and having an action during or after the sound
		
		/**
		 * Ideally
		 * while (robot.playSound("hello.wav");
		 * {
		 * 		[Waves Arm Here];
		 * }
		 */
		robot.playSound("hello.wav");
		
		update("end", "greet");
	}
	
	/**
	 * Make the robot tell a joke to its user.
	 */
	public void joke() {
		//TODO Have it tell a joke and have it laugh at its own joke with some sort of action.
		
		update("start", "joke");
		
		Random rand = new Random();
		robot.playSound(jokeBank[rand.nextInt(jokeBank.length)]);
		
		robot.playSound("laugh.wav");
		/**
		 * while (robot.playSound("watcha.wav") {
		 * 		[bops its head/body here];
		 * }
		 */
		
		update("end", "joke");
	}
	
	/**
	 * Make the robot mourn with perhaps an action.
	 */
	public void mourn() {
		update("start", "mourn");
		robot.playSound("caesar.wav");
		update("end", "mourn");
	}
	
	/**
	 * Make the robot insult something or somebody.
	 */
	public void insult() {
		update("start", "insult");
		robot.playSound("insult1.wav");
		update("end", "insult");
	}
	//#########################################################################
}