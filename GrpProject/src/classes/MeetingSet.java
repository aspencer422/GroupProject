package classes;

public class MeetingSet {
	private static Meeting[] meetingSet = new Meeting[20];
	private static int count = 0;
	
	/**
	 * public static void addEmpToMeeting(int meetingNum, Employee employee) 
	 * adds employee to meeting
	 * @param meetingNum
	 * @param employee
	 */
	public static void addEmpToMeeting(int meetingNum, Employee employee) {
		int index = getMeetingIndex(meetingNum);
		meetingSet[index].addEmployee(employee);
	}
	
	/**
	 * public static void addMeeting(Meeting meeting)
	 * add meeting to meetingSet
	 * @param meeting
	 */
	public static void addMeeting(Meeting meeting) {
		meetingSet[count]= meeting;
		count++;
	}
	
	
	/**
	 * public static Meeting getMeeting (int id) 
	 * gets meeting
	 * must make sure meeting exist before use
	 * @param id
	 * @return
	 */
	public static Meeting getMeeting (int id) {
		
			int index = getMeetingIndex(id);
			return meetingSet[index];
		
	}
	
	/**
	 * public static void deleteMeeting (int id)
	 * deletes meeting iven int ID
	 * @param id
	 */
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
	
	
	/**
	 * public static void updateMeeting(Meeting meeting)
	 * searches by Employee then replaces the entire Employee object
	 * @param meeting
	 */
	public static void updateMeeting(Meeting meeting) {
		for(int i = 0; i < count; i++) {
			if (meetingSet[i].equals(meeting)) {
				meetingSet[i]=meeting;
			}
		}
	}
	/**
	 * public static boolean meetingExist(int id)
	 * check if meeting exist by int ID
	 * @param id
	 * @return bool
	 */
	public static boolean meetingExist(int id) {
		for(int i = 0; i < count; i++) {
			if (meetingSet[i].getMeetingNumber() == id) {
				return true;
			}
		}
		return false;
	}
	/**
	 * public static int getMeetingIndex(int id) 
	 * gets meeting index
	 * @param id
	 * @return int
	 */
	public static int getMeetingIndex(int id) {
		for(int i = 0; i < count; i++) {
			if (meetingSet[i].getMeetingNumber() == id) {
				return i;
			}
		}
		return -1;
	}
	
	//helper method
	/**
	 * public static boolean MeetingExist(Meeting meeting)
	 * checks if meeting exist
	 * @param meeting
	 * @return
	 */
	public static boolean MeetingExist(Meeting meeting) {
		for(int i = 0; i < count; i++) {
			if (meetingSet[i].equals(meeting)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * public static int getMeetingIndex(Meeting meeting)
	 * gets meeting index by object
	 * @param meeting
	 * @return
	 */
	public static int getMeetingIndex(Meeting meeting) {
		for(int i = 0; i < count; i++) {
			if (meetingSet[i].equals(meeting)) {
				return i;
			}
		}
		return -1;
	}
}
