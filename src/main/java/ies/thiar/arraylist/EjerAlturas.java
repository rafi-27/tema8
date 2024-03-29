package ies.thiar.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EjerAlturas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        /**
         * Realiza un programa que tenga un ArrayList llamado AlturaAlumnos que mantenga
         * una
         * lista con las alturas de los alumnos de un centro. Serán valores positivos
         * entre 0,50 y 2,50
         * redondeados a dos decimales. El programa tendrá las siguientes funciones
         * (accesibles
         * mediante un menú):
         */

        ArrayList<Float> alturaAlumnos = new ArrayList<Float>();

        boolean salir = false;

        while (!salir) {
            menu();
            String letra = teclado.next();

            switch (letra) {
                case "a":
                    System.out.println("Introduce altura: ");
                    float altura = teclado.nextFloat();
                    if (altura > 0.50 || altura < 2.50) {
                        añadirAltura(alturaAlumnos, altura);
                    } else {
                        System.err.println("La altura tiene que estar entre 0,50 y 2,50.");
                    }
                    break;
                case "b":
                    System.out.println(mostrarLista(alturaAlumnos));
                    break;
                case "c":
                    System.out.println("Podicion para borrar: ");
                    int numero = teclado.nextInt();
                    borarEnPosicion(alturaAlumnos, numero);
                    break;
                case "d":
                    System.out.println("Introduce la altura para borrar: ");
                    float alturaBorrar = teclado.nextFloat();
                    System.out.println("Se han borrado " + borrarAltura(alturaAlumnos, alturaBorrar) + " alturas.");
                    break;
                case "e":
                    System.out.println("Ordenar lista: ");
                    ordenarLista(alturaAlumnos);
                    break;
                case "0":
                    salir = true;
                    break;
                default:
                    System.err.println("Opcion incorrecta!");
                    break;
            }
        }
        teclado.close();
    }

    public static ArrayList<Float> añadirAltura(ArrayList<Float> lista, float altura) {
        if (altura > 0.5 && altura < 2.50) {
            lista.add(altura);
            return lista;
        }
        return lista;
    }

    public static String mostrarLista(ArrayList<Float> lista) {
        return lista.toString();
    }

    public static boolean borarEnPosicion(ArrayList<Float> lista, int posi) {
        if (posi >= 0 && posi < lista.size()) {
            lista.remove(posi);
            return true;
        } else {
            System.err.println("La posición proporcionada no es válida.");
            return false;
        }
    }

    public static int borrarAltura(ArrayList<Float> lista, float altura) {
        int cont = 0;
        int i = 0;
        while (i < lista.size()) {
            if (lista.get(i) == altura) {
                cont++;
                if (borarEnPosicion(lista, i)) {
                    i--;
                }
            } else {
                i++;
            }
        }
        return cont;
    }

    public static void ordenarLista(ArrayList<Float> lista) {
        Collections.sort(lista);
    }

    public static void menu() {
        System.out.println("a) Añadir altura.");
        System.out.println("b) Mostrar lista actual con el número de posición.");
        System.out.println(
                "c) Eliminar por posición. Se le pasa como parámetro una posición y elimina la altura en dicha posición.");
        System.out.println(
                "d) Eliminar por valor. Se le pasa como parámetro una altura y elimina todas las posiciones en las que se encuentre dicha altura. Devuelve la cantidad de eliminaciones.");
        System.out.println("e) Ordenar la lista.");
        System.out.println("0 para salir.");
        System.out.println();
        System.out.println("Introduce la opcion que quieras: ");
    }
}
