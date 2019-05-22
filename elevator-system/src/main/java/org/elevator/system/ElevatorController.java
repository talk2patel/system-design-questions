package org.elevator.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

public class ElevatorController {
	// Assuming each elevator has same capacity
	private List<ElevatorImpl> elevators = Collections.EMPTY_LIST;
	private Set<ElevatorImpl> elevatorsGoingUp = new HashSet<>();
	private Set<ElevatorImpl> elevatorsGoingDown = new HashSet<>();
	private Set<ElevatorImpl> idleElevators = new HashSet<>();

	// total floors in the building
	private int totalFloors;

	// Queue of all available floors
	private Queue<ElevatorImpl> availableElevators;
	// all the floors from where an elevator was requested
	private Queue<ElevatorRequest> upRequests = new LinkedBlockingDeque<>();
	private Queue<ElevatorRequest> downRequests = new LinkedBlockingDeque<>();
	private Set<ElevatorRequest> allRequests = Collections.synchronizedSet(new HashSet<ElevatorRequest>());

	public ElevatorController(int numberOfElevators, int numberOfFloors) {
		this.elevators = initialiseElevators(numberOfElevators);
		this.totalFloors = numberOfFloors;
	}

	public ElevatorImpl getNearestAvailableElevator(int floorNumber) {
		return null;
	}

	public void notifyManager(int floorNumber, String direction) {
		ElevatorRequest newRequest = new ElevatorRequest(floorNumber, direction);
		if (direction.equals("UP") && allRequests.contains(newRequest)) {
			upRequests.add(newRequest);
		} else if (direction.equals("DOWN") && allRequests.contains(newRequest)) {
			downRequests.add(newRequest);
		} else {
			// Do nothing. Can throw exception also
		}
		allRequests.add(newRequest);
	}

	private List<ElevatorImpl> initialiseElevators(int numberOfElevators) {
		List<ElevatorImpl> elevators = new ArrayList<>();
		for (int i = 0; i < numberOfElevators; i++) {
			elevators.add(new ElevatorImpl(i, Constants.ELEVATOR_CAPACITY, Constants.DEFAULT_STOP_TIME,
					Constants.MIN_FLOOR, Constants.MAX_FLOOR));
		}
		return elevators;
	}

	/**
	 * 
	 * Call the closest idle elevator, call closest elevator going in the same
	 * direction
	 */
	private void callElevator(ElevatorRequest elevatorRequest) {
		ElevatorImpl closestIdleElevator = null;

		for (ElevatorImpl elevator : idleElevators) {

		}
	}
}