package ies.thiar.pruebas;

import java.util.ArrayList;

public class newjava {
    public static void main(String[] args) {
        //int[][] = new int[8][5];
        //int cont=1;
        
        //int[][] matriz={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,3},{0,2,2,0,3},{2,2,1,1,3},{0,3,2,2,1},{1,3,2,2,1},{3,3,1,2,1}};
        //ArrayList<Integer>nueva=new ArrayList<>();
        //for (int i = 0; i < matriz.length; i++) {
          //  for (int j = 0; j < matriz[0].length; j++) {
            //    if (matriz[0][j] != 0) {
              //      nueva.add(cont);
                //}
            //}
            //cont++;
        //}

        int[][] matriz={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,3},{0,2,2,0,3},{2,2,1,1,3},{0,3,2,2,1},{1,3,2,2,1},{3,3,1,2,1}};
        int cont=1;
        
        ArrayList<Integer>nueva=new ArrayList<>();
        
        for (int i = 0; i < matriz[0].length; i++) {
            if (matriz[0][i] != 0) {
                nueva.add(cont);
            }
            cont++;
        }       

        for (int i = 0; i < nueva.size(); i++) {
            System.out.println(nueva);
        }

    }
}