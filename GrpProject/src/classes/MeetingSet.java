package classes;

public class MeetingSet {
	private static Meeting[] meetingSet = new Meeting[20];
	private static int count = 0;
	
	public static void addMeeting(Meeting meeting) {
		meetingSet[count]= meeting;
		count++;
	}
	
	//must make sure meeting exist before use
	public static Meeting getMeeting (int id) {
		
			int index = getMeetingIndex(id);
			return meetingSet[index];
		
	}
	
	public static void deleteMeeting (int id) {
		if(meetingExist(id) == true) {
			int index = getMeetingIndex(id);
			
			if (count == 1) {
				meetingSet[0]= null;
			}
			
			//loop only activates if count > 1
			for(int i = index; i < count - 1; i++) {
				meetingSet[i] = meetingSet[i+1];
			}
			count--;
		}
	}
	
	//searches by Employee then replaces the entire Employee object
	public static void updateMeeting(Meeting meeting) {
		for(int i = 0; i < count; i++) {
			if (meetingSet[i].equals(meeting)) {
				meetingSet[i]=meeting;
			}
		}
	}
	public static boolean meetingExist(int id) {
		for(int i = 0; i < count; i++) {
			if (meetingSet[i].getMeetingNumber() == id) {
				return true;
			}
		}
		return false;
	}
	public static int getMeetingIndex(int id) {
		for(int i = 0; i < count; i++) {
			if (meetingSet[i].getMeetingNumber() == id) {
				return i;
			}
		}
		return -1;
	}
	
	//helper method
	public static boolean MeetingExist(Meeting meeting) {
		for(int i = 0; i < count; i++) {
			if (meetingSet[i].equals(meeting)) {
				return true;
			}
		}
		return false;
	}
	
	public static int getMeetingIndex(Meeting meeting) {
		for(int i = 0; i < count; i++) {
			if (meetingSet[i].equals(meeting)) {
				return i;
			}
		}
		return -1;
	}
}
