package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._07_Proxy.nonsda;

public class ProxyPatternClient {
    public static void main(String[] args) {
        OfficeInternetAccess access = new ProxyInternetAccess("Mindaugas Bernatavičius");
        access.grantInternetAccess();
    }
}
