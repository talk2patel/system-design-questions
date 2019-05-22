package org.elevator.system;

import java.util.Deque;
import java.util.LinkedList;

public class ElevatorImpl implements Elevator {

	private final int id;
	private final int minFloor;
	private final int maxFloor;
	private final int capacity;
	private int currentLoad = 0;
	
	private int currentFloor;
	private Button[] buttons;
	private ElevatorDirection currentMovingDirection;
	private Deque<Integer> pendingDropsQueue = new LinkedList<>();
	private final int defaultStopTime;

	public ElevatorImpl(int id, int capacity, int defaultStopTime, int minFloor, int maxFloor) {
		this.id = id;
		this.capacity = capacity;
		this.defaultStopTime = defaultStopTime;
		this.minFloor = minFloor;
		this.maxFloor = maxFloor;
	}

	public int getId() {
		return id;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public Button[] getButtons() {
		return buttons;
	}

	public void setButtons(Button[] buttons) {
		this.buttons = buttons;
	}

	public int getCapacity() {
		return capacity;
	}

	// is elevator suppose to go up
	private boolean goUp() {
		return false;
	}

	private boolean goDown() {
		return false;
	}

// flags all floors on which elevator is suppose to stop
	private boolean[] isAStop() {
		return null;
	}

	public void putAsAvailable(int id) {
	}

	public void gotoFloor(int floor) {
	}

	public void start() {
	}

	public int currentFloor() {
		return currentFloor;
	}

	@Override
	public int getMinFloor() {
		return this.minFloor;
	}

	@Override
	public int getMaxFloor() {
		return this.maxFloor;
	}

	@Override
	public Deque<Integer> getPendingDrops() {
		return this.pendingDropsQueue;
	}

	@Override
	public boolean moveUp() {
		if (currentFloor == maxFloor || isFull()) {
			return false;
		}
		// if full, then takes up a tick and must check again next tick
		currentFloor++;
		return true;
	}

	@Override
	public boolean moveDown() {
		if (currentFloor == minFloor || isFull()) {
			return false;
		}
		currentFloor--;
		return true;
	}

	@Override
	public void moveNext() {
		if (pendingDropsQueue.isEmpty()) {
			return;
		}
		int destination = pendingDropsQueue.peek();
		if (currentFloor < destination) {
			moveUp();
		} else if (currentFloor > destination) {
			moveDown();
		}

		if (currentFloor == destination) {
			pendingDropsQueue.poll();
		}
	}

	@Override
	public void prependDestination(int floor) {
		pendingDropsQueue.addFirst(floor);
	}

	@Override
	public void addToPendingDrops(int floor) {
		if (!pendingDropsQueue.contains(floor)) {
			pendingDropsQueue.add(floor);
		}
	}

	@Override
	public boolean isInPath(int floor) {
		if (pendingDropsQueue.isEmpty()) {
			return false;
		}
		int destination = pendingDropsQueue.peek();
		return (floor >= currentFloor && floor <= destination) || (floor <= currentFloor && floor >= destination);
	}

	@Override
	public boolean isFull() {
		return currentFloor>=capacity;
	}

	@Override
	public boolean isIdle() {
		return pendingDropsQueue.isEmpty();
	}

}