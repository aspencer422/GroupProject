package classes;

public class EmployeeSet {
	private static Employee[] employeeSet = new Employee[20];
	private static int count = 0;
	
	public static void addEmployee(Employee employee) {
		employeeSet[count]=employee;
		count++;
	}
	
	public static String getEmployee (int id) {
		if(employeeExist(id)==true) {
			int index = getEmployeeIndex(id);
			return employeeSet[index].toString();
		}
		return "Employee not found";
	}
	public static void deleteEmployee (int id) {
		if(employeeExist(id) == true) {
			int index = getEmployeeIndex(id);
			for(int i = index; i < count - 1; i++) {
				employeeSet[i] = employeeSet[i+1];
			}
			count--;
		}
	}
	
	//searches by Employee then replaces the entire Employee object
	public static void updateEmployee(Employee employee) {
		for(int i = 0; i < count; i++) {
			if (employeeSet[i].equals(employee)) {
				employeeSet[i]=employee;
			}
		}
	}
	public static boolean employeeExist(int id) {
		for(int i = 0; i < count; i++) {
			if (employeeSet[i].getId() == id) {
				return true;
			}
		}
		return false;
	}
	public static int getEmployeeIndex(int id) {
		for(int i = 0; i < count; i++) {
			if (employeeSet[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	//helper method
	public static boolean EmployeeExist(Employee employee) {
		for(int i = 0; i < count; i++) {
			if (employeeSet[i].equals(employee)) {
				return true;
			}
		}
		return false;
	}
	
	public static int getEmployeeIndex(Employee employee) {
		for(int i = 0; i < count; i++) {
			if (employeeSet[i].equals(employee)) {
				return i;
			}
		}
		return -1;
	}
}
