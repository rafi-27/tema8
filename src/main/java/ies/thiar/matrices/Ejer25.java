package ies.thiar.matrices;

import java.util.Scanner;

public class Ejer25 {
    public static void main(String[] args) {
    /**
     * Necesitamos crear un programa para registrar sueldos de hombres y mujeres de una
     * empresa y detectar si existe brecha salarial entre ambos. El programa pedirá por
     * teclado la información de N personas distintas (valor también introducido por teclado).
     * Para cada persona, pedirá su género (0 para varón y 1 para mujer) y su sueldo. Esta
     * información debe guardarse en una única matriz. Luego se mostrará por pantalla el
     * sueldo medio de cada género.
     */

     brechaSalarial(4);
    
    }

    public static void brechaSalarial(int numPersonas){
        Scanner teclado = new Scanner(System.in);
        double[][] datosSalarios = new double[numPersonas][2];

        double mediaHombres=0;
        double mediaMujeres=0;

        int contVarón = 0;
        int conMujer = 0;

        /**Genero se especifica con 0 varón 1 mujer. */
        for (int i = 0; i < datosSalarios.length; i++) {
            System.out.println("Genero: ");
            int genero = teclado.nextInt();

            if (genero == 0) {
                for (int j = 0; j < 1; j++) {
                    System.out.println("Salario: ");
                    mediaHombres+=teclado.nextDouble();
                }
                contVarón++;
            } else if (genero==1) {
                for (int j = 0; j < 1; j++) {
                    System.out.println("Salario: ");
                    mediaMujeres+=teclado.nextDouble();
                }
                conMujer++;
            }else{
                System.err.println("¡Opcion incorrecta!");
            }
        }
        float resulH = (float)mediaHombres/contVarón;
        float resulF = (float)mediaMujeres/conMujer;
        teclado.close();

        for (int i = 0; i < 1; i++) {
            System.out.println("Hay "+contVarón+" varónes y "+conMujer+" mujeres "+"la media salarial de los hombres es "+resulH+" y de las mujeres "+resulF);
        }
        for (int i = 0; i < datosSalarios.length; i++) {
            for (int j = 0; j < datosSalarios[0].length; j++) {
                System.out.println(datosSalarios[i][j]);
            }
        }


    }

}

