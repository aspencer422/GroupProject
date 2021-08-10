package classes;

public class MembershipSet {
	  private static Employee[] employeeSet = new Employee[100];
	  private static Meeting[] meetingSet = new Meeting[100];
	  private static boolean[] active = new boolean[100];
	  private static int count = 0;
	  
	  /**
	   * public static void addToMembershipSet(Employee emp, Meeting meet)
	   * adds entry
	 * @param emp
	 * @param meet
	 */
	public static void addToMembershipSet(Employee emp, Meeting meet) {
		  employeeSet[count] = emp;
		  meetingSet[count] = meet;
		  active[count]=true;
		  count++;
		  
	  }
	  /**
	   * public static void setInactive(Employee emp, Meeting meet) 
	   * set meeting inActive
	 * @param emp
	 * @param meet
	 */
	public static void setInactive(Employee emp, Meeting meet) {
		  for(int i = 0; i < count ; i++) {
			  if(employeeSet[i].equals(emp) && meetingSet[i].equals(meet) && active[i] == true) {
				  active[i]=false;
				  return;
			  }
		  }
	  }
	  /**
	   * public static Meeting[] fillMeetings(Employee emp)
	   * fills meeting in  object ram for GUI
	 * @param emp
	 * @return
	 */
	public static Meeting[] fillMeetings(Employee emp) {
		  //create temp meeting array
		  Meeting[] temp = new Meeting[50];
		  int counter = 0;
		  //loop through and find all meetings asigned
		  for(int i = 0; i < count; i++ ) {
			  if(employeeSet[i].equals(emp) && active[i] == true) {
				  temp[counter]=meetingSet[i];
				  counter++;
			  }
		  }
		  //create new array with final size
		  Meeting[] result = new Meeting[counter];
		  for(int i = 0; i < counter; i++) {
			  result[i]=temp[i];
		  }
		  
		  return result;
	  }
	  /**
	   * public static int getEmpCount(Employee emp) 
	   * get index count for givin employee for GUI
	 * @param emp
	 * @return
	 */
	public static int getEmpCount(Employee emp) {
		  Meeting[] temp = new Meeting[50];
		  int counter = 0;
		  for(int i = 0; i < count; i++ ) {
			  if(employeeSet[i].equals(emp) && active[i] == true) {
				  temp[counter]=meetingSet[i];
				  counter++;
			  }
		  }
		  return counter;
	  }


	  
	
}
