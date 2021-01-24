package cf.mindaugas.sdademos._03_design._01_solidprinciples._01_srp;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class PromotionCalculator {
    public boolean isPromotionDueThisYear(Employee2 e) {
        LocalDate currentDate = new Date().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate startDate = e.getStartTime().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        return startDate.getYear() + 1 > currentDate.getYear();
    }
}


class Employee2 {
    private String empId;
    private String name;
    private String address;
    private Date startTime;

    //Getters & Setters
    public Date getStartTime() {
        return startTime;
    }

    public Employee2(String empId, String name, String address, Date startTime) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.startTime = startTime;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}

// ... another way would be to implement 2 employee classes, and only one of them
// ... would implement an interface called "Promotable" or similar. Then the class
// ... would encapsulate the promotion logic that is needed for different types of employees
