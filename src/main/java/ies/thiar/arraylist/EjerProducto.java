package ies.thiar.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class EjerProducto {

    private String nombre;
    private int cantidad;

    public EjerProducto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public static void main(String[] args) {
        //1. Crea 5 instancias de la Clase Producto. 
        EjerProducto productoUno = new EjerProducto("Nike",3);
        EjerProducto productoDos = new EjerProducto("Naiki",33);
        EjerProducto productoTres = new EjerProducto("Abibas",4);
        EjerProducto productoCuatro = new EjerProducto("Alibaba vaper",5);
        EjerProducto productoCinco = new EjerProducto("Mvhael angelo jordan",23);
        //2. Crea un ArrayList.
        ArrayList<EjerProducto>listadoP = new ArrayList<>();
        //3. Añade las 5 instancias de Producto al ArrayList.
        listadoP.add(productoUno);
        listadoP.add(productoDos);
        listadoP.add(productoTres);
        listadoP.add(productoCuatro);
        listadoP.add(productoCinco);
        //4. Visualiza el contenido de ArrayList utilizando Iterator.
        Iterator iter = listadoP.iterator(); 
        
        while(iter.hasNext()) { 
            System.out.println(iter.next());
        }
        //5. Elimina dos elemento del ArrayList.
        listadoP.remove(productoCinco);
        listadoP.remove(productoDos);
        //6. Inserta un nuevo objeto producto en medio de la lista.
        EjerProducto productoSeis = new EjerProducto("Nike",3);
        EjerProducto productoSiete = new EjerProducto("Nike",3);

        listadoP.add(2, productoSiete);
        listadoP.add(1, productoSeis);
        //7. Visualiza de nuevo el contenido de ArrayList utilizando Iterator.
        System.out.println("Second");
        iter = listadoP.iterator(); 
        while(iter.hasNext()) { 
            System.out.println(iter.next());
        }
        //8. Elimina todos los valores del ArrayList.
        listadoP.clear();
    }
}
