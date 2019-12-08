package cf.mindaugas.sdademos.design._02_patterns._01_creational._02_builder.nonsda;

public class _00_BuilderUsage {

    public static void main(String args[]) {

        // better than StringBuffer for performance
        // and better than concatenating strings yourself
        StringBuilder builder = new StringBuilder();
        builder.append("An example ");
        builder.append("of the builder pattern. ");
        builder.append(111);

        System.out.println(builder.toString());
    }

}
