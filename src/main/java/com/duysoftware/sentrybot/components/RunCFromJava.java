package com.duysoftware.sentrybot.components;

public class RunCFromJava {
	public native void helloC();
	
	static {
		System.loadLibrary("HelloWorld");
	}
	
	public static void main(String[] args) {
		new RunCFromJava().helloC();
	}
 }
