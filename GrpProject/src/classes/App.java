package classes;

public class App {

	public static void main(String[] args) {
		Room room1 = new Room(1,30,true);
		
		
		RoomSet.addRoom(room1);
		System.out.println(RoomSet.getRoom(1).toString());

	}

}
