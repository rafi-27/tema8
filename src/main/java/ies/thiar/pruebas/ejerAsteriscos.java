package ies.thiar.pruebas;

import java.util.Scanner;

public class ejerAsteriscos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("CANTIDAD DE FILAS: ");
        int numer = sc.nextInt();

        for (int i = 0; i < numer; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
