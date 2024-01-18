package ies.thiar.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
     * Ejercicio 6 - Receta
     * Implementa las clases Ingrediente y Receta. Una vez creadas las clases. 
     * Implementa un método main que introduzca por teclado los valores de los atributos para crear una receta. 
     * Se preguntará cuántos ingredientes lleva la receta. Una vez introducidos los valores mostrar la receta.
     */


/**
 * Receta
 */
public class Receta {
    //Creamos los atributos:
    private String nombre;
    private String elavoracionPasos;
    private int duracion;
    private Ingrediente[] listaIngrediente;
    
    //Creamos el constructor
    public Receta(String nombre, String elavoracionPasos, int duracion,Ingrediente[] listaIngredientes) {
        this.nombre = nombre;
        this.elavoracionPasos = elavoracionPasos;
        this.duracion = duracion;
        this.listaIngrediente = listaIngredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getElavoracionPasos() {
        return elavoracionPasos;
    }

    public void setElavoracionPasos(String elavoracionPasos) {
        this.elavoracionPasos = elavoracionPasos;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    //Mostraremos la lista:
    @Override
    public String toString() {
        return "Receta nombre=" + nombre + ", Pasos para elavoracion=" + elavoracionPasos + ", duracion=" + duracion + " min"
                + ", lista de Ingredientes=" + Arrays.toString(listaIngrediente);
    }
}



/**
 * Ingrediente
 */
class Ingrediente {
    private String nombre;
    private float cantidad;
    private String unidad;

    public Ingrediente(String name, Float cantiGrams, String uniti){
        this.nombre=name;
        this.cantidad=cantiGrams;
        this.unidad=uniti;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", cantidad=" + cantidad + ", unidad=" + unidad;
    }

    /**
     * Main
     * @param args
     */
    
    
    
    
    
    
    
    
    
    
     public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //pedimos datos de la receta:
        System.out.println("Nombre de la receta: ");
        String nombreReceta = teclado.nextLine();
        System.out.println("Pasos para realizar la receta: ");
        String pasosARealizar = teclado.nextLine();
        System.out.println("Duracion aproximada de la elavoracion de la receta");
        int duracion = teclado.nextInt();
        System.out.println("Cuantos ingredientes necesitas: ");
        int ingre = teclado.nextInt();
       
        teclado.nextLine(); // Consumir la nueva línea pendiente después de nextInt()

        Ingrediente[] ingredientes = new Ingrediente[ingre];
        
        int cont=1;
        for (int i = 0; i < ingredientes.length; i++) {
            System.out.println("Nombre ingrediente: "+cont);
            String name = teclado.nextLine();
            teclado.next();
            System.out.println("Cantidad un numero float: ");
            float canti = teclado.nextFloat();
            teclado.nextLine(); // Consumir la nueva línea pendiente después de nextFloat()
            System.out.println("Unidad de medicion en gramos o mililitros si es un ingrediente loquido: ");
            String uniti = teclado.nextLine();
            cont++;
            ingredientes[i] = new Ingrediente(name, canti, uniti);
        }

        Receta tortillaFrancesa = new Receta(nombreReceta, pasosARealizar, duracion, ingredientes);
        System.out.println(tortillaFrancesa.toString());

        teclado.close();
    }
}