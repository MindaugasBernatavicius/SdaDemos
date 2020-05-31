package cf.mindaugas.sdademos._00_javafundamentals.strings;

public class Strings {

    public static void main(String[] args) {
        String a = "abcd";
        String b = "abcd";
        String c = new String("abcd");
        //String d = a;

        System.out.println(a==b);
        System.out.println(a.equals(b));

        System.out.println("==================");

        System.out.println(a==c);
        System.out.println(a.equals(c));

        System.out.println("==================");

        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println(System.identityHashCode(c));
        //System.out.println(System.identityHashCode(d));




        int int_a = 100;
        int int_b = 200;
        System.out.println( int_a + int_b );

        String str_a = "100";
        String str_b = "200";
        System.out.println( str_a + str_b );

        System.out.println( "=====================\n" );

        String name = "Mindaugas";
        String surname = "Bernatavičius";
        System.out.println(name + " " + surname);

        System.out.println(name.concat(surname));
        System.out.println(name.concat(" X ").concat(surname));
        System.out.println(name);

        System.out.println( "=======================\n" );






        //Return Values
        String str1, str2, str3;//=null;
        str1 = "abcd";
        str2 = "efgh";

        str3 = str1.concat(str2);
        System.out.println(str3);



        System.out.println("****************");

        //ONLY on not null... otherwise error
        int len = str3.length();
        System.out.println(len);





        // String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //
        // System.out.println(str.toLowerCase());
        // System.out.println(str.toUpperCase());
        // System.out.println(str.toLowerCase());
        // System.out.println(str);
        //
        // System.out.println("==========================\n");
        //
        // str = str.toLowerCase();// now it has been saved in str
        // System.out.println(str);
        //
        // int len = str.length();
        // System.out.println("The length of the txt string is: " + len);
        //
        // System.out.println("==========================\n");
        //
        // String email  = "johnny_boy@gmail.com";
        // String email2 = "  johnny_boy@gmail.com   "; //email with extra spaces
        //
        // if (email.equals(email2)) {
        //     System.out.println("This line will never execute");
        // } else {
        //     System.out.println("Emails address is WRONG!");
        // }


        // String email3 = email2.trim();
        //
        // if (email.equals(email3)) {
        //     System.out.println("TRIM() removed extra SPACES... Email address CORRECT!!!");
        // } else {
        //     System.out.println("Emails address is WRONG!");
        // }
        //
        // System.out.println("==========================\n");
        //
        // String str1 = "johnny_boy@gmail.com";
        // String str2 = "Johnny_boy@gmail.Com"; //email with capital letters(UpperCase)
        //
        // if (str1.equals(str2)) {
        //     System.out.println("This line will never execute");
        // } else {
        //     System.out.println("Emails address is wrong");
        // }
        //
        // int x = str1.compareToIgnoreCase(str2);
        // System.out.println("Value of x: " + x);
        //
        //
        // if (x == 1) {
        //     System.out.println("str1 is greater");
        // } else if (x == -1) {
        //     System.out.println("str1 is smaller");
        // } else if (x == 0) {
        //     System.out.println("They both are EQUAL");
        // }



        String s = "abcdefghij abcd defg";


        // char c = s.charAt(9);
        System.out.println(c);

        System.out.println(s.indexOf( 'j' ));
        System.out.println(s.indexOf( 'X' ));//doesnt exist

        System.out.println( "===============" );

        System.out.println(s.indexOf( 'd' )); //1st occurence
        System.out.println(s.lastIndexOf( 'd' )); //last occurence

        //2nd occurence ???
        /*
        code comes here...
        */



        //how many times did it occur
        /*
        int count = 0;
        for(int i=0; i < s.length(); i++)
        {    if(s.charAt(i) == 'd')
            count++;
        }
        System.out.println("Letter d occurred: " + count);
        */





        System.out.println("===============" );

        String Str = "JAVA is a Language, is a Coffee, is an Island. ";
        String find_str = "is";
        System.out.println(Str.indexOf(find_str));
        System.out.println(Str.lastIndexOf(find_str));
        System.out.println(Str.length());

        //2nd occurence ???


        //count number of times word appears in string java






    }

}
