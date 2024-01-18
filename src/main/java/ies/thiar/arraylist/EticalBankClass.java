package ies.thiar.arraylist;

import java.util.Scanner;

public class EticalBankClass {
//    public static void main(String[] args) {
//        CuentaBancariaClass rafi = new CuentaBancariaClass("Rafik Bachri Marouf");
//        Scanner teclado = new Scanner(System.in);

        public static void menu(){
            int numero=0;
            Scanner teclado = new Scanner(System.in);
            System.out.println("Titular: ");
            CuentaBancariaClass cuenta = new CuentaBancariaClass("");
            cuenta.setTitular(teclado.nextLine());
        do {
            System.out.println("1.Datos de la cuenta. Mostrará el IBAN, el titular y el saldo.");
            System.out.println("2. IBAN. Mostrará el IBAN.");
            System.out.println("3. Titular. Mostrará el titular.");
            System.out.println("4. Saldo. Mostrará el saldo disponible.");
            System.out.println("5. Ingreso. Pedirá la cantidad a ingresar y realizará el ingreso si es posible.");
            System.out.println("6. Retirada. Pedirá la cantidad a retirar y realizará la retirada si es posible.");
            System.out.println("10. Mostrar movimientos.");
            System.out.println("7. Salir. Termina el programa.");
            System.out.print("Introduce la opcion: ");
            numero = teclado.nextInt();
            switch (numero){
                case 1:
                    System.out.println("Titular: "+cuenta.getTitular()+" numero IBAN "+cuenta.getIBAN()+" saldo: "+cuenta.getSaldo()+"€");
                    break;
                case 2:
                    System.out.println("IBAN: "+cuenta.getIBAN());
                    break;
                case 3:
                    System.out.println("Titular: "+cuenta.getTitular());
                    break;
                case 4:
                    System.out.println("Saldo: "+cuenta.getSaldo()+"€");
                    break;
                case 5:
                    System.out.print("Indique la cantidad a ingresar: ");
                    cuenta.ingresar(teclado.nextDouble());
                    break;
                case 6:
                    System.out.print("Indica la cantidad a retirar: ");
                    cuenta.retirar(teclado.nextDouble());
                    break;
                case 7:
                    break;
                case 10:
                    System.out.println(cuenta.toString());
                    break;
            }
        }while (numero != 7);
        }
        public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);
            EticalBankClass.menu();
    }
}
