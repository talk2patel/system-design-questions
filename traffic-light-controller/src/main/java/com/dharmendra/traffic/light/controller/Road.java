package com.dharmendra.traffic.light.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Road {
	// Route name
	private String name;
	// storage of vehicles set
	private List<String> vechicles = new LinkedList<String>();

	public Road(String name) {
		this.name = name;
		// A thread pool, Every1-5Seconds to produce a car
		ExecutorService pool = Executors.newSingleThreadExecutor();
		pool.execute(()-> {
				for (int i = 0; i < 1000; i++) {
					try {
						Thread.sleep((new Random().nextInt(5) + 1) * 1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					vechicles.add(Road.this.name + "_" + i);
				}
			}
		);
		
		// Timer
		ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
		// Every second to determine the state of a current line lamp
		timer.scheduleAtFixedRate(()-> {
				// If a car on the road
				if (vechicles.size() > 0) {
					// If the lights are green
					if (Lamp.valueOf(Road.this.name).isLight()) {
						// Through a car
						String car = vechicles.remove(0);
						System.out.println(car + " has passed");
					}
				}
		}, 1, 1, TimeUnit.SECONDS);
	}
}