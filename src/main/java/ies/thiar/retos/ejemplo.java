package ies.thiar.retos;
import java.util.concurrent.ThreadLocalRandom;

public class ejemplo {
        public static void main(String[] args) {
            int alto=5;
            int ancho=5;
            //Crea una matriz de alto por ancho y.
            int[][] matriz = new int[alto][ancho];
            
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    matriz[i][j]=ThreadLocalRandom.current().nextInt(0,5);
                }
            }

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    System.out.print(matriz[i][j]+ " ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("Next---->");

            //ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(arrayNormal));
            int[] numeritos = {2,3,4};
            for (int i = 0; i < numeritos.length; i++) {
                System.out.print(numeritos[i]+" ");
            }

            //ArrayList<Integer> numerosListado = new ArrayList<>(Arrays.asList(numeritos));
            //for (int i = 0; i < numerosListado.size(); i++) {
              //  System.out.println(numerosListado.get(i));
            //}
        }


}
