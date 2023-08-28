package cf.mindaugas.sdademos._02_javaadvanced._12_maps;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _03_ExercisePeopleToDepartmentsMapping {
    public static void main(String[] args) {
        var employees = new ArrayList<Employee>(){{
            add(new Employee(22, "John", new Department(1, "Marketing")));
            add(new Employee(56, "Peter", new Department(2, "IT")));
            add(new Employee(23, "Anna", new Department(1, "Marketing")));
        }};

        var departmentToEmployees = new HashMap<Department, List<Employee>>();

        for (var employee : employees) {
            if(!departmentToEmployees.containsKey(employee.getDepartment()))
                departmentToEmployees.put(employee.getDepartment(), new ArrayList<>());
            departmentToEmployees.get(employee.getDepartment()).add(employee);
        }

        System.out.println(departmentToEmployees);
    }
}

@Getter
@AllArgsConstructor
@ToString(includeFieldNames = false)
class Employee {
    private int age;
    private String name;
    private Department department;
}

@Getter
@AllArgsConstructor
@ToString(includeFieldNames = false)
@EqualsAndHashCode
class Department {
    private int id;
    private String name;
}
