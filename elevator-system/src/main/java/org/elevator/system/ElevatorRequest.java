package org.elevator.system;

public class ElevatorRequest {

	public final int requestingFloor;
	public final String directionToGo;
	public Integer floorToGo;

	public ElevatorRequest(int requestingFloor, String directionToGo) {
		this(requestingFloor, directionToGo, null);
	}
	
	public ElevatorRequest(int requestingFloor, String directionToGo, Integer floorToGo) {
		this.requestingFloor = requestingFloor;
		this.directionToGo = directionToGo;
		this.floorToGo = floorToGo;
	}
}