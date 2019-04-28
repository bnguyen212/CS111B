import java.util.*;

public class Department {
/*
 A Department is described by a name and a list of employees in the department.
Write the instance data, constructors, getters/setters, and a toString method.
Write a method to add an Employee to the department.
Write a method to calculate the sum of all salaries for all employees of that department.
 */
	
	private String name;
	private ArrayList<Employee> employeeList;
	
	public Department(String name) {
		this.name = name;
		employeeList = new ArrayList<Employee>();	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Employee> getEmployeeList() {
		return new ArrayList<Employee>(employeeList); // makes a shallow copy so the list cannot be externally manipulated; note that an individual Employee object still could be!
	}

	// setter for the list omitted; the only way to update the list is through the add/remove methods

	public String toString() {
		return name + "\n\t" + employeeList;
	}
	
	public boolean addEmployee(Employee e) {
		if(employeeList.contains(e)) {
			return false;
		} else {
			return employeeList.add(e);
		}
	}
	public boolean removeEmployee(Employee e) {
		return employeeList.remove(e);
	}
	
	public int getNumberEmployeesReceiveBenefits() {
		int count = 0;
		for(Employee e : employeeList) {
			count += e.hasBenefits() ? 1 : 0;
		}
		return count;
	}
	public void payroll() {
		for(Employee e : employeeList) {
			e.pay();
		}
	}
}
