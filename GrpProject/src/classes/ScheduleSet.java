package classes;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ScheduleSet {
	private static int[] empId = new int[100];
	private static int[] meetingNum = new int [100];
	private static Date[] date = new Date[100];
	private static int[] startTime = new int [100];
	private static int[] endTime = new int [100];
	private static int count = 0;
	
	public static boolean[] checkAvail(int[] empNums,Date checkDate) {
		boolean[] result = new boolean[24];
		Arrays.fill(result, true);
		for (int i = 0; i < empNums.length;i++) {
			for ( int j = 0; j < count ; j++) {
				if(empNums[i]==empId[j] && isSameDay(checkDate,date[j]) == true) {
					result[startTime[j]/100]=false;
				}
			}
		}
		
		return result;
	}
	
	public static boolean isSameDay(Date date1, Date date2) {
	    Instant instant1 = date1.toInstant()
	      .truncatedTo(ChronoUnit.DAYS);
	    Instant instant2 = date2.toInstant()
	      .truncatedTo(ChronoUnit.DAYS);
	    return instant1.equals(instant2);
	}
	
	public static void addEntry(int empKey, int meetingKey,Date dateEntry, int start, int end) {
		empId[count]= empKey;
		meetingNum[count]=meetingKey;
		date[count] = dateEntry;
		startTime[count]=start;
		endTime[count]=end;
		count++;
	}
	
	
	public static void deleteEntry(int empKey, int meetingKey) {
		if(empId[0] == empKey && meetingNum[0] == meetingKey && count == 1) {
			empId[0]=0;
			meetingNum[0]=0;
			date[0] = new Date(0);
			startTime[0]=0;
			endTime[0]=0;
			count--;
			return;
		}
		
		boolean flag = false;
		
		for(int i = 0; i < count - 1 ; i++) {
			if(empId[i] == empKey && meetingNum[i] == meetingKey ) {
				flag = true;
			}
			if (flag == true) {
				empId[i]=empId[i+1];
				meetingNum[i]=meetingNum[i+1];
				date[i]= date[i+1];
				startTime[i]=startTime[i+1];
				endTime[i]=endTime[i+1];
			}
		}
		empId[count]=0;
		meetingNum[count]=0;
		date[count] = new Date(0);
		startTime[count]=0;
		endTime[count]=0;
		count--;
	}
	
}
