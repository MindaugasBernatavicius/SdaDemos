package cf.mindaugas.sdademos.design._02_patterns._03_behavioral._03_memento.nonsda;

import java.util.Stack;

//caretaker
public class Caretaker {

	private Stack<EmployeeMemento> employeeHistory = new Stack<>();
	
	public void save(Employee emp) {
		employeeHistory.push(emp.save());
	}
	
	public void revert(Employee emp) {
		emp.revert(employeeHistory.pop());
	}
}
