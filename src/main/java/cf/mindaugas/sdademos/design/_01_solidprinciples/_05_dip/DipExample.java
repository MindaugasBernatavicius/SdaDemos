package cf.mindaugas.sdademos.design._01_solidprinciples._05_dip;

public class DipExample {
    public static void main(String[] args) {
        Student s1 =  new Student(new ShippingAddress("USA", "Los angeles", "Venice Beatch", 15));
        Student s2 =  new Student(new Address("USA", "Los angeles", "Venice Beatch"));
    }
}

//public class Student {
//    private String name;
//    private Address address;
//
//    public Student() {
//        address = new Address();
//    }
//}

class Address {
    private String country;
    private String city;
    private String streetAddress;

    public Address(String country, String city, String streetAddress) {
        this.country = country;
        this.city = city;
    }
}
class ShippingAddress extends Address {
    private int flatNumber;

    public ShippingAddress(String country,
                           String city,
                           String streetAddress,
                           int flatNumber) {
        super(country, city, streetAddress);
        this.flatNumber = flatNumber;
    }
}

class Student {
    private String name;
    private Address address;

    // constructor injection
    public Student(Address address) {
        this.address = address;
    }

    // ... or setter injection
    void setAddress(Address address){
        address = address;
    }
}
