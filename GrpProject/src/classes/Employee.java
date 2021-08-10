package classes;

public class Employee {
  private String name;
  private int id;
  private String position;
  private boolean admin;
  private String username;
  private String password;
  private Meeting[] commitedMeetings = new Meeting[20];
  private int cmCount;
  private int[] notificationSet = new int[20];
  private int notifCount;
//schedule = new empty hashset ::: may not be needed here and implemented in Scedule set
  
  public Employee(String name, int id, String position, String username, String password) {
		this.name = name;
		this.id = id;
		this.position = position;
		this.username = username;
		this.password = password;
		this.cmCount = 0;
		this.notifCount = 0;
	}
  public Employee(Employee emp) {
		this.name = emp.getName();
		this.id = emp.getId();
		this.position = emp.getPosition();
		this.username = emp.getUsername();
		this.password = emp.getPassword();
		this.commitedMeetings = MembershipSet.fillMeetings(emp);
		this.cmCount = MembershipSet.getEmpCount(emp);
		this.notifCount = 0;
	}
  
  //notification set may change to its own class so implement later.
  public void acceptNotif(Meeting meeting) {
	  MeetingSet.addEmpToMeeting(meeting.getMeetingNumber(), this);
	  commitedMeetings[cmCount]=meeting;
	  cmCount++;
	  
	  //add to schedule Set class
	  MembershipSet.addToMembershipSet(this, meeting);
	  ScheduleSet.addEntry(this.id, meeting.getMeetingNumber(),meeting.getDate(), meeting.getStartTime(), meeting.getEndTime());
	  this.deleteNotif(meeting.getMeetingNumber());
  }
  public void deleteNotif(int meetingNum) {
	  if (notifCount == 1 && notificationSet[0] == meetingNum) {
		  notificationSet[0]= 0;
		  notifCount--;
		  return;
	  }else {
		  boolean flag = false;
		  
		  for (int i = 0; i < (notifCount - 1);i++) {
			  if (notificationSet[i] == meetingNum) {
				  flag = true;
			  }
			  if (flag == true) {
				  notificationSet[i] = notificationSet[i+1];
			  }
		  }
		  notificationSet[notifCount]= 0;
		  notifCount--;
	  }
  }
  
  public void addNotif(int meetingNum) {
	  notificationSet[notifCount] = meetingNum;
	  notifCount++;
  }

  public boolean equals(Employee employee) {
		return this.id == employee.getId();
	}
  
  public boolean equals(int id) {
		return this.id == id;
	}
  public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
  
  
  public void deleteMeetingFromPersonalSet (Meeting meetingNum) {
	  
	  if (cmCount == 1 && commitedMeetings[0].equals(meetingNum)) {
		  commitedMeetings[0]= null;
		  cmCount--;
		  return;
	  }else {
		  boolean flag = false;
		  
		  for (int i = 0; i < (cmCount - 1);i++) {
			  if (commitedMeetings[i].equals(meetingNum)) {
				  flag = true;
			  }
			  if (flag == true) {
				  commitedMeetings[i] = commitedMeetings[i+1];
			  }
		  }
		  commitedMeetings[cmCount]= null;
		  cmCount--;
	  }
	
  }
  
  
  //getter and setters
  public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

  	
  
  //hashset meetings
  //hashset schedule
  //hashset notifications
  
//  constructor(NAME, ID, POSITION, USERNAME, PSWD){
//    name = NAME;
//    id = ID;
//    position = POSITION;
//    username = USERNAME;
//    pswd = PSWD;
//    meetings = new empty hashset;
//    schedule = new empty hashset;
//    notifications = new empty hashset;
//  }
// not sure what set time slot going to do. may need to be implemented in setOfMeeting classs
//  setTimeSlot(date, time){
//    //todo
//  }
    
}
