package com.dharmendra.traffic.light.controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LampControler {
	// Said the first light cycle control,Also for the light
	private Lamp currentLamp = Lamp.S2N;

	// Provides methods to control of traffic lights
	public void start() {
		// The lights green
		currentLamp.lightUp();
		// Timer 12:
		ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
		// Every10Second change status
		timer.scheduleAtFixedRate(() -> {
			// The lamp dimming, And get the next set of lights to quote
			currentLamp = currentLamp.lightDown();
			// the next set of lights green
			currentLamp.lightUp();
		}, 10, 10, TimeUnit.SECONDS);
	}
}