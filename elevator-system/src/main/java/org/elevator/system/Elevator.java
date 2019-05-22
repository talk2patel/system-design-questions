package org.elevator.system;

import java.util.Deque;

public interface Elevator {
	int getMinFloor();

	int getMaxFloor();

	int getCurrentFloor();

	Deque<Integer> getPendingDrops();

	boolean moveUp();

	boolean moveDown();

	void moveNext();

	void prependDestination(int floor);

	void addToPendingDrops(int floor);

	boolean isInPath(int floor);

	boolean isFull();

	boolean isIdle();
}