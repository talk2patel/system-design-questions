package com.dharmendra.traffic.light.controller;

public enum Lamp {
	// Express line lamp 
	S2N("N2S", "S2W", false), S2W("N2E", "E2W", false), E2W("W2E", "E2S", false), E2S("W2N", "S2N", false),
	N2S(null, null, false), N2E(null, null, false), W2E(null, null, false), W2N(null, null, false),
	S2E(null, null, true), E2N(null, null, true), N2W(null, null, true), W2S(null, null, true);

	// The corresponding direction lamp
	private String oppsite;
	// The lamp to light the next
	private String next;
	// The current state, trueExpressed as green
	private boolean light;

	Lamp(String oppsite, String next, boolean light) {
		this.oppsite = oppsite;
		this.next = next;
		this.light = light;
	}

	// lightUpSaid the light 39:
	public void lightUp() {
		light = true;
		System.out.println(name() + " The green light");
		// If the lamp is not empty, At the same time, change direction lamp is
		// corresponding to the state 
		if (oppsite != null) {
			Lamp.valueOf(oppsite).lightUp();
		}
	}

	// lightDownSaid the red light
	public Lamp lightDown() {
		light = false;
		System.out.println(name() + " The red light");
		// If the lamp is not empty, At the same time, change direction lamp is
		// corresponding to the state
		if (oppsite != null)
			Lamp.valueOf(oppsite).lightDown();
		// Returns the next direction of the lamp :
		if (next != null)
			return Lamp.valueOf(next);
		return null;
	}

	// Get the current state
	public boolean isLight() {
		return light;
	}
}