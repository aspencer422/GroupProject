
public class RoomSet {
	private static Room[] roomSet = new Room[20];
	private static int count = 0;
	
	public void addRoom(Room room) {
		roomSet[count]=room;
		count++;
	}
	
	
	public void deleteRoom (Room room) {
		if(roomExist(room) == true) {
			int index = getRoomIndex(room);
			for(int i = index; i < count - 1; i++) {
				roomSet[i] = roomSet[i+1];
			}
			count--;
		}
	}
	
	//searches by roomNumber then replaces the entire room object
	public void updateRoom(Room room) {
		for(int i = 0; i < count; i++) {
			if (roomSet[i].equals(room)) {
				roomSet[i]=room;
			}
		}
	}
	
	//helper method
	public boolean roomExist(Room room) {
		for(int i = 0; i < count; i++) {
			if (roomSet[i].equals(room)) {
				return true;
			}
		}
		return false;
	}
	
	public int getRoomIndex(Room room) {
		for(int i = 0; i < count; i++) {
			if (roomSet[i].equals(room)) {
				return i;
			}
		}
		return -1;
	}
	
}
