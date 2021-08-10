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
  private Meeting[] notificationSet = new Meeting[20];
  private int notifCount;

  
  /**
   * public Employee(String name, int id, String position, String username, String password)
   * Constructor to create employee
 * @param name
 * @param id
 * @param position
 * @param username
 * @param password
 */
public Employee(String name, int id, String position, String username, String password) {
		this.name = name;
		this.id = id;
		this.position = position;
		this.username = username;
		this.password = password;
		this.cmCount = 0;
		this.notifCount = 0;
	}
  /**
   * public Employee(Employee emp)
   * Constructor used in GUI to get employee to ram 
 * @param emp
 */
public Employee(Employee emp) {
		this.name = emp.getName();
		this.id = emp.getId();
		this.position = emp.getPosition();
		this.username = emp.getUsername();
		this.password = emp.getPassword();
		this.commitedMeetings = MembershipSet.fillMeetings(emp);
		this.cmCount = MembershipSet.getEmpCount(emp);
		this.notificationSet = NotificationSet.fillNotifications(emp);
		this.notifCount = NotificationSet.getEmpCount(emp);
	}
  /**
   * public void updateNotifs()
 *  updates notifications and notifcount
 */
public void updateNotifs() {
	  this.notificationSet = NotificationSet.fillNotifications(this);
	  this.notifCount = NotificationSet.getEmpCount(this);
  }
  /**
 * public void updateCommitedMeetings()
 * updates commitedMeeting and CMcount
 */
public void updateCommitedMeetings() {
	  this.commitedMeetings = MembershipSet.fillMeetings(this);
	  this.cmCount = MembershipSet.getEmpCount(this);
  }
  
  
  /**
   * public void acceptNotif(Meeting meeting)
   * accepts notification by updating all dataSETS then updating personalSETs
 * @param meeting
 */
public void acceptNotif(Meeting meeting) {
	  
	  //add to schedule Set class
	  MeetingSet.addEmpToMeeting(meeting.getMeetingNumber(), this);
	  MembershipSet.addToMembershipSet(this, meeting);
	  ScheduleSet.addEntry(this.id, meeting.getMeetingNumber(),meeting.getDate(), meeting.getStartTime(), meeting.getEndTime());
	  NotificationSet.setHandled(this, meeting);
	  this.updateCommitedMeetings();
	  this.updateNotifs();
	  
  }
  /**
   * public void deleteNotif(int meetingNum)
   * deletes notification by updating DataNotificaiont set then Updates personal set
 * @param meeting
 */
public void deleteNotif(Meeting meeting) {
	NotificationSet.setHandled(this, meeting);
	this.updateNotifs();
  }
  


  /**
   * public boolean equals(Employee employee)
   * checks if two employees are the same by object
 * @param employee
 * @return
 */
public boolean equals(Employee employee) {
		return this.id == employee.getId();
	}
  
  /**
   * check is employees are equal by empID
 * @param id
 * @return bool
 */
public boolean equals(int id) {
		return this.id == id;
	}


  /**
   * public void deleteMeetingFromPersonalSet (Meeting meeting)
   * updates membership dataSet the updates personal dataSet
 * @param meeting
 */
public void deleteMeetingFromPersonalSet (Meeting meeting) {
	  MembershipSet.setInactive(this, meeting);
	  this.updateCommitedMeetings();
	
  }
  
  
  //getter and setters
  public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
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
    
}
