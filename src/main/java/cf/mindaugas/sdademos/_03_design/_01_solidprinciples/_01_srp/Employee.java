package cf.mindaugas.sdademos._03_design._01_solidprinciples._01_srp;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

// POJO + isPromotionDueThisYear()
public class Employee {
    private String id;
    private String name;
    private String address;
    private Date startTime;

    // ... can an employee know about his promotion eligibility
    // ... some would say, that promotion logic should be separate
    // ... from Employee class b/c it is not a property of Employee
    // ... so in the next example, lets move this to another class:
    // ... PromotionCalculator class
    public boolean isPromotionDueThisYear() {
        LocalDate currentDate = new Date().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate startDate = startTime.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        return startDate.getYear() > currentDate.getYear();
    }
    //Getters & Setters
}

class ContractEmployee extends Employee {
    // ... we do not need the isPromotionDueThisYear method, but we still get it
    // ... and we could mistakenly call it in some circumstances
}
