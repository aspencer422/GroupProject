package classes;
import java.util.*;

public class Meeting {
	private int meetingNumber;
	private Date date;
	private int startTime;  // Military time
	private int endTime;
	private Employee owner;
	private  Room room;
	private Employee[] attendingSet;
	private int attendingCount;
	
	
	
	public Meeting(int meetingNumber, Date date, int startTime,int endTime, Employee owner,Room room) {
		super();
		this.meetingNumber = meetingNumber;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.owner = owner;
		this.setRoom(room);
		this.attendingCount = 0;
		this.attendingSet = new Employee[20];
	}
	
	public void inviteEmployee(Employee emp) {
		NotificationSet.addToNotificationSet(emp, this);
	}
	
	public void deleteEmployee(Employee employee) {
		if(this.attendingCount == 1) {
			if (employee.equals(this.attendingSet[0])){
				this.attendingSet[0]= null;
				this.attendingCount--;
			}
		}else {
			boolean flag = false;
			
			for(int i = 0; i < (this.attendingCount - 1); i++) {
				if (employee.equals(this.attendingSet[i])) {
					flag = true;
				}
				if (flag == true) {
					this.attendingSet[i] = this.attendingSet[i+1];
					this.attendingCount=0;
				}
			}
		}
	}
	
	public void deleteEmployee(int id) {
		if(this.attendingCount == 1) {
			if (this.attendingSet[0].equals(id)){
				this.attendingSet[0]= null;
				this.attendingCount--;
			}
		}else {
			boolean flag = false;
			
			for(int i = 0; i < (this.attendingCount - 1); i++) {
				if (this.attendingSet[i].equals(id)) {
					flag = true;
				}
				if (flag == true) {
					this.attendingSet[i] = this.attendingSet[i+1];
					this.attendingCount=0;
				}
			}
		}
	}
	
	public void addEmployee (Employee employee) {
		this.attendingSet[this.attendingCount] = employee;
		this.attendingCount++;
	}
	
	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getMeetingNumber() {
		return meetingNumber;
	}
	public void setMeetingNumber(int meetingNumber) {
		this.meetingNumber = meetingNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Employee getOwner() {
		return owner;
	}
	public void setOwner(Employee owner) {
		this.owner = owner;
	}
	public int getAttendingCount() {
		return attendingCount;
	}
	public void setAttendingCount(int attendingCount) {
		this.attendingCount = attendingCount;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	
}
