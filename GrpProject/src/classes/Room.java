package classes;

public class Room {
	private int roomNumber;
	private int roomCap;
	private boolean isAvail;
	
	/**
	 * public Room(int roomNumber, int roomCap, boolean isAvail)
	 * constructor for room
	 * @param roomNumber
	 * @param roomCap
	 * @param isAvail
	 */
	public Room(int roomNumber, int roomCap, boolean isAvail) {
		this.roomNumber = roomNumber;
		this.roomCap = roomCap;
		this.isAvail = isAvail;
	}
	
	/**
	 *toString overide
	 * returns ""+ roomNumber + " " + roomCap + " " + isAvail;
	 */
	@Override
	public String toString() {
		return ""+ roomNumber + " " + roomCap + " " + isAvail;
	}
	
	/**public boolean equals(Room room) 
	 * check if equal by object
	 * @param room
	 * @return
	 */
	public boolean equals(Room room) {
		return this.roomNumber == room.getRoomNumber();
	}
	
	/**
	 * public boolean equals(int roomNumber)
	 * check if equal by roomNumber
	 * @param roomNumber
	 * @return
	 */
	public boolean equals(int roomNumber) {
		return this.roomNumber == roomNumber;
	}
	
	/**
	 * public boolean checkRoomCap(int num)
	 * check if room is at cap with given int input
	 * @param num
	 * @return
	 */
	public boolean checkRoomCap(int num) {
		//create flag
		boolean result = true;
		//check if at capacity
		if(this.roomCap < num) {
			result = false;
		}
		return result;
	}

	//getters and setters 
	
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
