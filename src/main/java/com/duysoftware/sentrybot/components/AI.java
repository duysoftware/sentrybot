package com.duysoftware.sentrybot.components;

import java.util.*;

public class AI extends AbstractComponent {
	private Robot robot;
	
	private boolean sentryMode;
	private boolean busy;
	private boolean searching;
	private boolean alarmOn;
	private String status;

	private Set<String> userInputs;
	private HashMap<String, Runnable> decisions;
	private String[] jokeBank = {"joke1.wav", "joke2.wav", "joke3.wav"};
	
	/**
	 * Forms a new AI unit and connects it to some robotic framework.
	 */
	public AI(Robot robot) {
		this.robot = robot;
		
		this.sentryMode = true;
		this.busy = false;
		this.searching = false;
		this.alarmOn = false;
		this.status = "standby";

		createAvailableUserInputs();
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
	
	public boolean isAlarmOn() {
		return alarmOn;
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
			setSuccessStatus(false);
		} else if ("end".equals(startOrEnd)) {
			busy = false;
			this.status = "COMPLETED " + process;
			setSuccessStatus(robot.wasSuccessful());
		}
		
		System.out.println(this.status);
	}
	/**
	 * Creates a set of user inputs. Commands from here are allowed to
	 * interrupt currently running actions or subroutines.
	 */
	private void createAvailableUserInputs() {
		userInputs = new HashSet<String>();
		
		userInputs.add("alarmOff");
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
		decisions.put("kiss", () -> kiss());
		decisions.put("goodbye", () -> goodbye());
		
		// user input buttons
		decisions.put("alarmOff", () -> alarmOff());
		
		// subroutines
		decisions.put("redAlert", () -> alarmSubroutine());
	}
	
	/**
	 * Makes a decision based on given input.
	 * @param input Can be a command, sensory data from sensors, etc.
	 */
	public void parse(String input) {
		if (!busy || userInputs.contains(input)) {	
			if (decisions.containsKey(input)) {
				decisions.get(input).run();
			} else {
				System.out.print("AI COMMAND: " + input + " NOT RECOGNIZED");
			}
		}
	}
	
	//####################### SUBROUTINES #######################
	
	/**
	 * An alarm that loops for some amount of time.
	 */
	public void alarmSubroutine() {
		// Temporary value for intruder
		int loop = 100;
		alarmOn = true; 
		
		while (alarmOn && loop-- > 0) {
			raiseAlarm();
			
			
			
			
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
		playSound("shallnotpass.wav");
	}
	
	/**
	 * A routine to bid the user farewell and simulating kiss.
	 */
	public void goodbyeSubroutine() {
		goodbye();
		kiss();
	}
	
	//######################### ACTIONS #########################
	/**
	 * A generic method for the robot to play sound in subroutines.
	 * @param filename
	 */
	public void playSound (String filename) {
		update("start", filename);
		robot.playSound(filename);
		update("end", filename);
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
	
	public void alarmOff() {
		alarmOn = false;
		System.out.println("alarmOn is now " + alarmOn);
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
	
	/**
	 * Make the robot kiss the user or an object.
	 */
	public void kiss() {
		update("start", "kiss");
		robot.playSound("kiss.wav");
		update("end", "kiss");
	}
	
	/**
	 * Make the robot bid the user or object farewell.
	 */
	public void goodbye() {
		update("start", "goodbye");
		robot.playSound("goodbye.wav");
		update("end", "goodbye");
	}
	
	//#########################################################################
}