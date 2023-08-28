package cf.mindaugas.sdademos._02_javaadvanced._20_reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@interface Serialize {}
@Retention(RetentionPolicy.RUNTIME)
@interface SkipSerialization {}

class Person4Ser {
    @Serialize int age;
    // @SkipSerialization String name;
    @Serialize String name;

    public Person4Ser(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

class JsonProcessor {
    private static List<Field> getFieldsWithAnnotation(Field[] allFields){
        List<Field> fieldWithAnnotation = new ArrayList<>(0);
        for(Field field: allFields)
            if(field.isAnnotationPresent(Serialize.class))
                fieldWithAnnotation.add(field);
        return fieldWithAnnotation;
    }
    public static String serialize(Class<?> cls, Object object){
        if (cls.isInstance(object)) {
            Field[] fields = cls.getDeclaredFields();
            StringBuilder sb = new StringBuilder();
            List<Field> filtFields = getFieldsWithAnnotation(fields);
            sb.append('{');
            for (int i = 0; i < filtFields.size(); i++) {
                if (filtFields.get(i).isAnnotationPresent(Serialize.class)) {
                    filtFields.get(i).setAccessible(true);
                    try {
                        sb.append('"').append(filtFields.get(i).getName()).append('"');
                        sb.append(": ");
                        // System.out.println(filtFields.get(i).getType() == int.class);
                        // if(filtFields.get(i).getType() != int.class
                        //         || filtFields.get(i).getType() != Integer.class
                        //         || filtFields.get(i).getType() != double.class
                        //         || filtFields.get(i).getType() != Double.class
                        // )
                        if(filtFields.get(i).getType() == String.class)
                            sb.append('"').append( filtFields.get(i).get(object)).append('"');
                        else
                            sb.append( filtFields.get(i).get(object));
                        if(filtFields.size() - 1 != i)
                            sb.append(", ");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            sb.append('}');
            return sb.toString();
        } else throw new IllegalArgumentException("Object is not an instance of the specified class");
    }
}


public class _04_SimpleJsonSerializer {
    public static void main(String[] args) {
        // System.out.println(new Person4Ser(55, "John"));
        // { "age": 55, "name": "John" } - Json representation of the Person object
        // To convert objects to json format we have a few options:
        // 1. sacrifice toString() method to return the json representation.
        //      Disadvantages: sacrificed method, not a general solution - we would need to rewrite the code for each class
        // 2. to create another method and just call it toJson()
        //      Disadvantages: no more sacrifice, but still not a general approach
        // 3. General approach - pass any type of object (Person, Customer, Game, Map) into a method and get that
        //  objects json representation (no more writing of specific methods toJson() in each class - D.R.Y.)

        var obj = new Person4Ser(55, "John");
        var ser = JsonProcessor.serialize(Person4Ser.class, obj);
        // var ser = JsonProcessor.serialize(Game4Ser.class, new Game4Ser(LocalDateTime.of(2017, Month.FEBRUARY,3,6,30,40,50000)));
        System.out.println(ser);
    }
}
