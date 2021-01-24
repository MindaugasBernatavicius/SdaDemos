package cf.mindaugas.sdademos._03_design;

import java.util.ArrayList;
import java.util.List;

public class StaticVsNonStatic {
    public static void main(String[] args) {
        Employee e1 = new Employee(55);
        Employee e2 = new Employee(66);

        System.out.println(e1.getAge());
        System.out.println(e2.getAge());

        // EmployeeStatisticsCalculator.getAverageAge(new ArrayList<>());
        // EmployeeStatisticsCalculator.getAverageSalary();
    }
}

class Employee {
    static int _age;

    public Employee(int age) {
        _age = age;
    }

    public int getAge() {
        return _age;
    }
}

class EmployeeStatisticsCalculator {
    public static double getAverageAge(List<Employee> employeeList) {
        return 0.0;
    }

    public static double getAverageSalary() {
        return 0.0;
    }

    public static double getAverageSalaryForSpecificAge(int age) {
        return 0.0;
    }
}
