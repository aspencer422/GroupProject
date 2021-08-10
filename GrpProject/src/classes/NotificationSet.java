package classes;

public class NotificationSet {
	  private static Employee[] employeeSet = new Employee[100];
	  private static Meeting[] meetingSet = new Meeting[100];
	  private static boolean[] handled = new boolean[100];
	  private static int count = 0;
	  
	  public static void addToNotificationSet(Employee emp, Meeting meet) {
		  employeeSet[count] = emp;
		  meetingSet[count] = meet;
		  handled[count]=false;
		  count++;
	  }
	  public static void setHandled(Employee emp, Meeting meet) {
		  for(int i = 0; i < count ; i++) {
			  if(employeeSet[i].equals(emp) && meetingSet[i].equals(meet) && handled[i] == false) {
				  handled[i]=true;
				  return;
			  }
		  }
	  }
	  public static Meeting[] fillNotifications(Employee emp) {
		  Meeting[] temp = new Meeting[50];
		  int counter = 0;
		  for(int i = 0; i < count; i++ ) {
			  if(employeeSet[i].equals(emp) && handled[i] == false) {
				  temp[counter]=meetingSet[i];
				  counter++;
			  }
		  }
			  Meeting[] result = new Meeting[counter];
			  for(int i = 0; i < counter; i++) {
				  result[i]=temp[i];
			  }
			  return result;
	  }
	  public static int getEmpCount(Employee emp) {
		  Meeting[] temp = new Meeting[50];
		  int counter = 0;
		  for(int i = 0; i < count; i++ ) {
			  if(employeeSet[i].equals(emp) && handled[i] == false) {
				  temp[counter]=meetingSet[i];
				  counter++;
			  }
		  }
		  return counter;
	  }
}
