package org.elevator.system;

public class Button {
	private int floorNumber;
	private ElevatorController elevatorSystem;
	
	public Button(int floorNumber, ElevatorController elevatorSystem) {
		this.floorNumber = floorNumber;
		this.elevatorSystem = elevatorSystem;
	}
	
	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	
	public void pressUp() {
		elevatorSystem.notifyManager(floorNumber, "UP");
	}
	
	public void pressDown() {
		elevatorSystem.notifyManager(floorNumber, "DOWN");
	}
}