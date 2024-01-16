package ies.thiar.pruebas;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

class Arraysprueba {

    public static void main(String[] args) {
        Scanner taclado = new Scanner(System.in);
        ArrayList<Float> alturaAlumnos = new ArrayList();
        
        float num = (float) 1.70;
        float num2 = (float) 1.90;

        añadirAlturaD(num, alturaAlumnos);
        añadirAlturaD(num2, alturaAlumnos);

        for (Float float1 : alturaAlumnos) {
            System.out.println(float1);
        }


    }


    public static boolean añadirAltura(ArrayList<Float> lista,Float altura){
        DecimalFormat formatoDeAlturas = new DecimalFormat("#.00");
        altura = Float.valueOf(formatoDeAlturas.format(altura));
    
        if (altura>0.5 && altura<2.50) {
            lista.add(altura);
            return true;
        }
        return false;
    }
    public static boolean añadirAlturaD(Float altura, ArrayList<Float> lista) {
        DecimalFormat formato = new DecimalFormat("#.00");
        altura = Float.valueOf(formato.format(altura));
        if (altura > 0.5 && altura < 2.50) {
            lista.add(altura);
            return true;
        }
        return false;
    }
}