package cf.mindaugas.sdademos._03_design._02_patterns._03_behavioral._06_memento.nonsda;

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
