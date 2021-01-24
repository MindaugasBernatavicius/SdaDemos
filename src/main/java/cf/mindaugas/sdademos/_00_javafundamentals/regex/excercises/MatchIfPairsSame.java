package cf.mindaugas.sdademos._00_javafundamentals.regex.excercises;

public class MatchIfPairsSame {

    public static void main(String[] args) {

        String[] nameSurname = new String[]{"abc abc", "cde cde"};
        String[] filtered = new String[nameSurname.length];
        String pattern = "\\w+\\s\\w+";
        // (\w+)(\s)(\1)

        for (int i = 0; i < nameSurname.length; i++) {
            System.out.println(nameSurname[i]);
        }

    }

}
