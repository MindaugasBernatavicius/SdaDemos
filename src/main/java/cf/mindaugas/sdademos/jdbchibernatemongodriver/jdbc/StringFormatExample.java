package cf.mindaugas.sdademos.jdbchibernatemongodriver.jdbc;

import org.apache.commons.lang3.StringUtils;

public class StringFormatExample {
    public static void main(String args[]) {
        String[] names = {"Jonas", "Valentinovieninikas", "Besikiskiakopusteliaudamasis", "Petras"};

        // 0. - simple format of simple table - bad example
        // 1. - rewrite bad example with the format string in a primitive way
        // 2. - expose a parameter that would dictate which side we want to justify the text with
        // 3. - expose the parameter which would tell how long the collumn needs to be
        // 4. - make the calculation of how long each collumn needs to be diinamic (findMax for that collumn)

        for(int i = 0; i < names.length; i++){
            int len = 30;
            System.out.format("|%-" + len + "s|\n", StringUtils.center(names[i], len));
        }
    }
}