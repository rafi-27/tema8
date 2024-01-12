package ies.thiar.vectores;

import java.util.Scanner;

public class Ejer12 {
    public static void main(String[] args) {
        ArraysMenu();
    }



    public static void ArraysMenu(){
        int[] numeros = new int[10];
        Scanner teclado = new Scanner(System.in);

        String opcion="";
        boolean salir=false;
        while (!salir) {
            System.out.println("Selecciona una opcion: ");
            menu();
            opcion = teclado.next();
            opcion.toLowerCase();
            switch (opcion) {
                case "a":
                    for (int i : numeros) {
                        System.out.println(i);
                    }
                    break;
                case "b":
                    int numero = teclado.nextInt();
                    int posicion = teclado.nextInt();
                    numeros[posicion]=numero;
                    break;
                case "c":
                    System.out.println("Adios!");
                    salir=true;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
        teclado.close();
    }

    public static void menu(){
        System.out.println("a)Mostrar valores\nb)Introducir valor\nc)Salir");
    }
}