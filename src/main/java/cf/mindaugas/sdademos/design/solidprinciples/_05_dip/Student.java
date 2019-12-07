package cf.mindaugas.sdademos.design.solidprinciples._05_dip;

public class Student {
    private Address address;

    public Student() {
        address = new Address();
    }
}

class  Address { }

//public class Student {
//    private Address address;
//    public Student() {}
//    // setter injection
//    setAddress(Address address){
//        address = address;
//    }
//}
