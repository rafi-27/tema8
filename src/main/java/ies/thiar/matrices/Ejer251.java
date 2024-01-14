package ies.thiar.matrices;

import java.util.Scanner;

public class Ejer251 {
    public static void main(String[] args) {
        brechaSalarial(4);
    }

    public static void brechaSalarial(int numPersonas) {
        Scanner teclado = new Scanner(System.in);

        int[][] datosSalarios = new int[numPersonas][2];

        System.out.println("Filas " + datosSalarios.length + " columnas " + datosSalarios[0].length);

        double mediaHombres = 0;
        double mediaMujeres = 0;

        int contVarón = 0;
        int conMujer = 0;

        /** Genero se especifica con 0 varón 1 mujer. */
        for (int i = 0; i < numPersonas; i++) {
            System.out.println("Persona: " + i);
            System.out.println("Genero 0 varon 1 mujer");
            datosSalarios[i][0] = teclado.nextInt();
            System.out.println("Salario: ");
            datosSalarios[i][1] = teclado.nextInt();

            if (datosSalarios[i][0] == 0) {
                mediaHombres += datosSalarios[i][1];
            }

            if (datosSalarios[i][0] == 1) {
                mediaMujeres += datosSalarios[i][1];
            }
        }

        for (int j = 0; j < datosSalarios.length; j++) {
            if (datosSalarios[j][0] == 0) {
                contVarón++;
            }
            if (datosSalarios[j][0] == 1) {
                conMujer++;
            }
        }

        float resulH = (float) mediaHombres / contVarón;
        float resulF = (float) mediaMujeres / conMujer;

        if (mediaHombres>mediaMujeres) {
            System.out.println("Hay " + contVarón + " varónes y " + conMujer + " mujeres "
        + "la media salarial de los hombres es " + resulH + " y de las mujeres " + resulF+" a favor de los hombres.");            
        }else if (mediaMujeres>mediaHombres) {
            System.out.println("Hay " + contVarón + " varónes y " + conMujer + " mujeres "
        + "la media salarial de los hombres es " + resulH + " y de las mujeres " + resulF+" a favor de las mujeres.");
        }

        for (int i = 0; i < datosSalarios.length; i++) {
            for (int j = 0; j < datosSalarios[0].length; j++) {
                System.out.print(datosSalarios[i][j]+":");
            }
            System.out.println();
        }
        teclado.close();
    }
}