package classes;
public class RoomSet {
	private static Room[] roomSet = new Room[20];
	private static int count = 0;
	
	/**
	 * public static void addRoom(Room room)
	 * adds room to roomSet
	 * @param room
	 */
	public static void addRoom(Room room) {
		roomSet[count]=room;
		count++;
	}
	
	/**
	 * public static Room getRoom (int roomNumber)
	 * return object from given ID
	 * must check is exist before use
	 * @param roomNumber
	 * @return
	 */
	public static Room getRoom (int roomNumber) {
		
		int index = getRoomIndex(roomNumber);
		return roomSet[index];
		
	}
	/**
	 * public static void deleteRoom (int roomNum) 
	 * deletes room
	 * @param roomNum
	 */
	public static void deleteRoom (int roomNum) {
		if(roomExist(roomNum) == true) {
			//get room index
			int index = getRoomIndex(roomNum);
			
			//handle count = 1 case
			if (count == 1) {
				roomSet[0]= null;
			}
			//loop and shift
			for(int i = index; i < count - 1; i++) {
				roomSet[i] = roomSet[i+1];
			}
			count--;
		}
	}
	
	
	/**
	 * public static void updateRoom(Room room)
	 * searches by roomNumber then replaces the entire room object
	 * @param room
	 */
	public static void updateRoom(Room room) {
		for(int i = 0; i < count; i++) {
			if (roomSet[i].equals(room)) {
				roomSet[i]=room;
			}
		}
	}
	/**
	 * public static boolean roomExist(int roomNum)
	 * check if room exist given int ID
	 * @param roomNum
	 * @return bool if exist = true
	 */
	public static boolean roomExist(int roomNum) {
		for(int i = 0; i < count; i++) {
			if (roomSet[i].getRoomNumber() == roomNum) {
				return true;
			}
		}
		return false;
	}
	
	/**public static int getRoomIndex(int roomNum)
	 * gets index of room from roomNumber int
	 * @param roomNum
	 * @return int index
	 */
	public static int getRoomIndex(int roomNum) {
		for(int i = 0; i < count; i++) {
			if (roomSet[i].getRoomNumber() == roomNum) {
				return i;
			}
		}
		return -1;
	}
	
	
	/**
	 * public static boolean roomExist(Room room)
	 * check if room exist given object
	 * @param room
	 * @return
	 */
	public static boolean roomExist(Room room) {
		for(int i = 0; i < count; i++) {
			if (roomSet[i].equals(room)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * public static int getRoomIndex(Room room)
	 * gets room index from objects
	 * @param room
	 * @return int index / -1 if not found
	 */
	public static int getRoomIndex(Room room) {
		for(int i = 0; i < count; i++) {
			if (roomSet[i].equals(room)) {
				return i;
			}
		}
		return -1;
	}
	
}
