package ies.thiar.vectores;

public class EjerExtra1 {
    public static void main(String[] args) {
        int[] vector = {1,2,3,3,4,4,2};

        int igual=0;
        int vecesRepetido=0;

        for (int i = 1; i < vector.length; i++) {
            if (vector[i]==vector[i-1]) {
                igual++;
            }
            if (igual>vecesRepetido) {
                vecesRepetido=igual;
            }
        }
        System.out.println(vecesRepetido);
    }
}