package cf.mindaugas.sdademos._04_codingadvanced.v2exercises;

import java.util.Scanner;

public class _01_VendingMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("MENU:");
        int choise;
        do {
            System.out.println("Spauskite 1: - jei norite alaus");
            System.out.println("Spauskite 2: - jei norite saldainių");
            System.out.println();
            System.out.print("Jūsų pasrinkimas: ");
            choise = sc.nextInt();
        } while (choise != 2 && choise != 1);

        // User clicks 1 - user to select products
        // ... then select what coins to insert (10, 20, 50)
        // ... "sudėjus monetas paklausiame ar esate tikras? -> Y/N" canceling the request.
    }
}

class Product {
    private double price;
}
