package classes;

public class Employee {
  private String name;
  private int id;
  private String position;
  private String username;
  private String password;
  private Meeting [] commitedMeetings = new Meeting[20];
  private int cmCount;
  private String[] notificationSet = new String[20];
  private int nitifCount;
//schedule = new empty hashset ::: may not be needed here and implemented in Scedule set
  
  public Employee(String name, int id, String position, String username, String password) {
		this.name = name;
		this.id = id;
		this.position = position;
		this.username = username;
		this.password = password;
		this.cmCount = 0;
		this.nitifCount = 0;
	}
  
  //notification set may change to its own class so implement later. 
  
  public void addMeetingToPersonalSet (Meeting meeting) {
	  this.commitedMeetings[this.cmCount]= meeting;
	  this.cmCount++;
  }
  
  public void deleteMeetingFromPersonalSet (Meeting meeting) {
	  
	  boolean flag = false;
	  
	  for ( int i = 0; i < (this.cmCount -1) ; i++) {
		  
		  if(this.commitedMeetings[i].equals(meeting))
		  {
			  flag = true;
		  }
		  if(flag == true)
		  {
			  this.commitedMeetings[i] = this.commitedMeetings[i+1];
		  }
	  }
	  if(flag == true)
	  {
		  this.cmCount--;
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
