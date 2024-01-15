package ies.thiar.pruebas;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ejer2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList <Float>alturaAlumnos = new ArrayList<Float>();
        
        System.out.println("Introduce el numero: ");
        float numero = teclado.nextFloat();
        alturaAlumnos.add(añadirAltura(numero));
        alturaAlumnos.add((float) 1.78);

        for (Float float1 : alturaAlumnos) {
            System.out.println(float1);
        }
        teclado.close();
    }


     public static Float añadirAltura(Float altura){
        DecimalFormat formatoDeAlturas = new DecimalFormat("#,##");
        return Float.parseFloat(formatoDeAlturas.format(altura));
    }
}
