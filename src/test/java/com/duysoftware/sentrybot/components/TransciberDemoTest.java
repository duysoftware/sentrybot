package com.duysoftware.sentrybot.components;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransciberDemoTest {

	@Test
	public void testRun() {
		try {
			TranscriberDemo.run("jokecommand.wav");
			assert(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assert(false);
		}
	}

}
