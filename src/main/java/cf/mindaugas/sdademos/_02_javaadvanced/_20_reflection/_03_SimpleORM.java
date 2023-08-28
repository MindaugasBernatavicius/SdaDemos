package cf.mindaugas.sdademos._02_javaadvanced._20_reflection;

interface EntityManager<T>{
    void write(T t);
    T read();
}


class Person {
    int id;
    String name;
    int age;
}
public class _03_SimpleORM {
    public static void main(String[] args) {

    }
}
