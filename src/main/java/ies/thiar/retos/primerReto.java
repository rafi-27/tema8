package ies.thiar.retos;
import java.util.concurrent.ThreadLocalRandom;

public class primerReto {
    //private int[][] tablero;
    public static void main(String[] args) {
        primerReto tablerin = new primerReto();
        tablerin.crearTablero(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }


    /**
     * metodo crearTablero(int alto, int ancho, int minas)
     */

     private void crearTablero(int alto, int ancho, int cantidadMinas){
        if (alto<0 || ancho<0) {
            System.err.println("Error alto o ancho incorrecto.");
        }
        if (cantidadMinas<0) {
            System.err.println("cantidad incorrecta de minas.");
        }
        //Crea una matriz de alto por ancho y.
        int[][] matriz = new int[alto][ancho];
        //ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(arrayNormal));
        //coloca aleatoriamente el numero de minas una mina se representa con un -1 las demas 0
        int num = 0;
        while (num < cantidadMinas) {
            int x = ThreadLocalRandom.current().nextInt(0,alto);
            int y = ThreadLocalRandom.current().nextInt(0,ancho);
            if(matriz[x][y]==0){
                matriz[x][y]=-1;
                cantidadMinas--;
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(String.format("%-3d", matriz[i][j]));
            }
            System.out.println();
        }
     }
}