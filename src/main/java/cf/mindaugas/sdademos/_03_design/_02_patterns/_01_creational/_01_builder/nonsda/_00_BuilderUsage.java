package cf.mindaugas.sdademos._03_design._02_patterns._01_creational._01_builder.nonsda;

public class _00_BuilderUsage {
    public static void main(String args[]) {
        // better than StringBuffer for performance
        // and better than concatenating strings yourself
        StringBuilder builder = new StringBuilder();
        builder.append("An example ");
        builder.append("of the builder pattern. ");
        builder.append(111);

        // // vs.
        // String s1 = "An example ";
        // s1 += "of the builder pattern. ";
        // s1 += 111;
        // // ... more computationally expensive

        System.out.println(builder.toString());
    }
}
