package ies.thiar.arraylist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CuentaBancariaClass {
//Creamos los atributos.
    private String IBAN="ES";
    private String titular;
    private double saldo;
    //Añadimos el nuevo atributo: 
    private ArrayList<String>movimientos;

//Procedo a crear el constructor.
    public CuentaBancariaClass(String titular){
        IBAN=generarIban();
        this.titular=titular;
        this.saldo=0;
        this.movimientos=new ArrayList<>();
    }
//Getters
    public String getIBAN(){
        return IBAN;
    }
    public String getTitular(){
        return titular;
    }
    public double getSaldo(){
        return saldo;
    }
//Setters
    public void setIBAN(String iban){
        IBAN=iban;
    }
    public void setTitular(String titular){
        this.titular=titular;
    }
    public void setSaldo(double saldo){
        this.saldo=saldo;
    }

//Metodo para ingresar dinero.
    public String generarIban(){
        for (int i = 1; i < 23; i++) {
            IBAN += ThreadLocalRandom.current().nextInt(0,9);
        }
        return IBAN;
    }
    public void ingresar(double cantidad){
        if(cantidad > 0){
            saldo=saldo+cantidad;
        }else {
            System.err.println("No se puede ingresar esta cantidad de dinero.");
        }
        if(cantidad > 3000){
            System.err.println("AVISO: Notificar a hacienda");
        }
        String money = String.valueOf(cantidad);
        String ingreso = "Se ha ingresado "+money+" fecha "+LocalDate.now();
        movimientos.add(ingreso);
    }
//Metodo para retirar dinero.
    public void retirar(double retirada){
        if(retirada > 0 && saldo - retirada >= -50){
            saldo=saldo-retirada;
            String money = String.valueOf(retirada);
        String retira = "Se ha retirado "+money+" fecha "+LocalDate.now();
        movimientos.add(retira);
        }else {
            System.err.println("No se puede retirar dicha cantidad.");
        }
        if(saldo <= -50){
            System.err.println("AVISO: Saldo negativo");
        }
        if(retirada > 3000){
            System.err.println("AVISO: Notificar a hacienda");
        }
    }
    @Override
    public String toString() {
        return "CuentaBancariaClass [movimientos=" + movimientos + "]";
    }
}
