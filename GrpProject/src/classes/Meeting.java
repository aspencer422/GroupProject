package classes;
import java.util.*;

public class Meeting {
	private int meetingNumber;
	private Date date;
	private int time;  // Military time
	private Employee owner;
	private Employee[] attendingSet;
	private int attendingCount;
	
	
	
	public Meeting(int meetingNumber, Date date, int time, Employee owner) {
		super();
		this.meetingNumber = meetingNumber;
		this.date = date;
		this.time = time;
		this.owner = owner;
		this.attendingCount = 0;
		this.attendingSet = new Employee[20];
	}
	
	public void inviteEmployee() {
		//creates notification object and adds it to employee notification set. 
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
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
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
	
	
	
}
