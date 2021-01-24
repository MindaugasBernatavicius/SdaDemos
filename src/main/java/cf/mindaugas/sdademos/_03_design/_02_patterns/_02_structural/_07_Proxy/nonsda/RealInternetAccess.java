package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._07_Proxy.nonsda;

interface OfficeInternetAccess {
    public void grantInternetAccess();
}

public class RealInternetAccess implements OfficeInternetAccess {
    private String employeeName;

    public RealInternetAccess(String empName) {
        this.employeeName = empName;
    }

    @Override
    public void grantInternetAccess() {
        System.out.println("Internet Access granted for employee: " + employeeName);
    }
}
