package ies.thiar.arraylist;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class EjerAlturas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        /**
         * Realiza un programa que tenga un ArrayList llamado AlturaAlumnos que mantenga una
         * lista con las alturas de los alumnos de un centro. Serán valores positivos entre 0,50 y 2,50
         * redondeados a dos decimales. El programa tendrá las siguientes funciones (accesibles
         * mediante un menú):
         */
        
        ArrayList <Float>alturaAlumnos = new ArrayList<Float>();
        menu();
        String letra = teclado.next();

        float numero = teclado.nextFloat();
        alturaAlumnos.add(añadirAltura(numero));

        for (Float float1 : alturaAlumnos) {
            System.out.println(float1);
        }

        switch (letra) {
            case "a":
            System.out.println("Introduce altura: ");
                float altura = teclado.nextFloat();
                if (altura>0.50 || altura < 2.50) {
                    alturaAlumnos.add(añadirAltura(altura));
                }else{
                    System.err.println("La altura tiene que estar entre 0,50 y 2,50.");
                }

                break;
        
            default:
                break;
        }
        teclado.close();
    }

    public static Float añadirAltura(Float altura){
        DecimalFormat formatoDeAlturas = new DecimalFormat("#.##");
        return Float.parseFloat(formatoDeAlturas.format(altura));
    }



    public static void menu(){
        System.out.println("a) Añadir altura.");
        System.out.println("b) Mostrar lista actual con el número de posición.");
        System.out.println("c) Eliminar por posición. Se le pasa como parámetro una posición y elimina la altura en dicha posición.");
        System.out.println("d) Eliminar por valor. Se le pasa como parámetro una altura y elimina todas las posiciones en las que se encuentre dicha altura. Devuelve la cantidad de eliminaciones.");
        System.out.println("e) Ordenar la lista.");

    }
}
