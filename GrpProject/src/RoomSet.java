
public class RoomSet {
	private static Room[] roomSet = new Room[20];
	private static int count = 0;
	
	public static void addRoom(Room room) {
		roomSet[count]=room;
		count++;
	}
	
	public static String getRoom (int roomNumber) {
		if(roomExist(roomNumber)==true) {
			int index = getRoomIndex(roomNumber);
			return roomSet[index].toString();
		}
		return "Room not found";
	}
	public static void deleteRoom (int roomNum) {
		if(roomExist(roomNum) == true) {
			int index = getRoomIndex(roomNum);
			for(int i = index; i < count - 1; i++) {
				roomSet[i] = roomSet[i+1];
			}
			count--;
		}
	}
	
	//searches by roomNumber then replaces the entire room object
	public static void updateRoom(Room room) {
		for(int i = 0; i < count; i++) {
			if (roomSet[i].equals(room)) {
				roomSet[i]=room;
			}
		}
	}
	public static boolean roomExist(int roomNum) {
		for(int i = 0; i < count; i++) {
			if (roomSet[i].getRoomNumber() == roomNum) {
				return true;
			}
		}
		return false;
	}
	public static int getRoomIndex(int roomNum) {
		for(int i = 0; i < count; i++) {
			if (roomSet[i].getRoomNumber() == roomNum) {
				return i;
			}
		}
		return -1;
	}
	
	//helper method
	public static boolean roomExist(Room room) {
		for(int i = 0; i < count; i++) {
			if (roomSet[i].equals(room)) {
				return true;
			}
		}
		return false;
	}
	
	public static int getRoomIndex(Room room) {
		for(int i = 0; i < count; i++) {
			if (roomSet[i].equals(room)) {
				return i;
			}
		}
		return -1;
	}
	
}
