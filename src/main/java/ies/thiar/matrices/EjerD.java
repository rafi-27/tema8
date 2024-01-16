package ies.thiar.matrices;

import java.util.Scanner;

public class EjerD {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int[][] lista = new int[4][5];
        int media;
        int notaMaxima;
        int notaMinima;

        for (int i = 0; i < 4; i++) {
            System.out.println("alumno "+i);  
            for (int j = 0; j < 5; j++) {  
                lista[i][j] = lector.nextInt();
            }
        }

        for (int i = 0; i < 4; i++) {
            media = 0;
            notaMaxima = -999999999;
            notaMinima = 999999999;
            for (int j = 0; j < 5; j++) {
                media += lista[i][j];
                if (lista[i][j] < notaMinima) notaMinima = lista[i][j];
                else if (lista[i][j] > notaMaxima) notaMaxima = lista[i][j];
            }
            System.out.println("Media de notas del alumno " + lista[i][0] + " es: " + media / 5);
            System.out.println("Su nota máxima es: " + notaMaxima);
            System.out.println("Su nota mínima es: " + notaMinima);
    }
    lector.close();
}
}