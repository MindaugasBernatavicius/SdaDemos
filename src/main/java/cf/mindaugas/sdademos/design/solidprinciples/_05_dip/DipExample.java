package cf.mindaugas.sdademos.design.solidprinciples._05_dip;

public class DipExample {
    public static void main(String[] args) {
        Student s1 =  new Student(
                new ShippingAddress(
                        "USA", "Los angeles", "Venice Beatch"));

        Student s2 =  new Student(
                new Address("USA", "Los angeles"));
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

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }
}
class ShippingAddress extends Address {
    private String streetAddress;

    public ShippingAddress(String country, String city, String streetAddress) {
        super(country, city);
        this.streetAddress = streetAddress;
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
