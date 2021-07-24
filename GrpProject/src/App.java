
public class App {

	public static void main(String[] args) {
		Room room1 = new Room(1,30,true);
		
		RoomSet temp = new RoomSet();
		
		temp.addRoom(room1);
		System.out.println(temp.getRoom(1));

	}

}
