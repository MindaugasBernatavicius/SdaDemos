package cf.mindaugas.sdademos.design.solidprinciples._01_srp;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Employee {
    private String id;
    private String name;
    private String address;
    private Date startTime;

    public boolean isPromotionDueThisYear(){
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