package com.dharmendra.traffic.light.controller;

public class MainClass {
	public static void main(String[] args) {
		// The controller starts to work
		new LampControler().start();
		// create 12 routes the instance of
		Lamp[] lamps = Lamp.values();
		for (int i = 0; i < lamps.length; i++) {
			new Road(lamps[i].name());
		}
	}
}
