package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate._1_annotations;

public class OverridesAnnotation {

    public static void main(String[] args) {
        ChildClass ch = new ChildClass();
        ch.name = "Mindaugas";
        System.out.println(ch);
    }
}

class ParentClass {
    public void method() {
        System.out.println("Parent class method");
    }
}

class ChildClass extends ParentClass {

    String name;

    @Override
    public void method() {
        System.out.println("Child class method");
    }

    @Override
    public String toString() {
        return "ChildClass{" +
                "name='" + name + '\'' +
                '}';
    }
}
