package classes;

public class Room {
	private int roomNumber;
	private int roomCap;
	private boolean isAvail;
	
	public Room(int roomNumber, int roomCap, boolean isAvail) {
		this.roomNumber = roomNumber;
		this.roomCap = roomCap;
		this.isAvail = isAvail;
	}
	
	@Override
	public String toString() {
		return ""+ roomNumber + " " + roomCap + " " + isAvail;
	}
	
	public boolean equals(Room room) {
		return this.roomNumber == room.getRoomNumber();
	}
	
	public boolean equals(int roomNumber) {
		return this.roomNumber == roomNumber;
	}
	
	public boolean checkRoomCap(int num) {
		boolean result = true;
		if(this.roomCap < num) {
			result = false;
		}
		return result;
	}

	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getRoomCap() {
		return roomCap;
	}
	public void setRoomCap(int roomCap) {
		this.roomCap = roomCap;
	}
	public boolean isAvail() {
		return isAvail;
	}
	public void setAvail(boolean isAvail) {
		this.isAvail = isAvail;
	}
	
	
}
