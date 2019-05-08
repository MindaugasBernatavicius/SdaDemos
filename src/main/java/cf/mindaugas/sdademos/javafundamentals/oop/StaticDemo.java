package cf.mindaugas.sdademos.javafundamentals.oop;

import static cf.mindaugas.sdademos.javafundamentals.oop.CredentialManager.password;

public class StaticDemo {
    public static void main(String[] args) {
        CredentialManager.password = "qwerty";
        CredentialManager.username = "mindaugas";

        System.out.println(CredentialManager.password);
        System.out.println(CredentialManager.username);

        CredentialManager cm1 = new CredentialManager();
        System.out.println(cm1.username);
        System.out.println(cm1.password);

        CredentialManager.password = "qwerty";
        CredentialManager.username = "vilmantas";

        System.out.println(cm1.username);
        System.out.println(cm1.password);

        CredentialManager cm2 = new CredentialManager();
        System.out.println(cm2.username);
        System.out.println(cm2.password);
    }
}

class CredentialManager{
    public static String username;
    public static String password;
}