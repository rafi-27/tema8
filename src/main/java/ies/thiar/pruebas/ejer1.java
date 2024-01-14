package ies.thiar.pruebas;

import java.util.concurrent.ThreadLocalRandom;

public class ejer1 {
    public static void main(String[] args) {
        int[][] veintiCinco = new int[5][5];

        for (int i = 0; i < veintiCinco.length; i++) {
            for (int j = 0; j < veintiCinco[0].length; j++) {
                veintiCinco[i][j]=ThreadLocalRandom.current().nextInt(1,10+1);
            }
        }

        for (int i = 0; i < veintiCinco.length; i++) {
            for (int j = 0; j < veintiCinco.length; j++) {
                System.out.println("Indice: "+i+"."+j+"= "+veintiCinco[i][j]);
            }
        }
    }
}
