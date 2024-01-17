package ies.thiar.arraylist;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/** CLASE FACTURA */
public class EjerFacturas {
    /**
     * Número identificador: lo proporciona el usuario en el alta de la factura.
     * • Fecha de la factura: la toma del sistema en el momento del alta.
     * • Número de cliente: : lo proporciona el usuario en el alta de la factura.
     * • Porcentaje de IVA: 21% para todas las facturas.
     * • Importe total: inicialmente cero, y se va actualizando siempre que se
     * añadan/eliminen líneas.
     */

    // Atributos
    private int numIdentificador;
    private final Date fechaFactura = new Date(); // fecha del alta.
    private int numCliente;
    private static final double iva = 21;
    private double importTotal = 0;

    // Creamos el array list:
    private static final ArrayList<lineaFactura> nuevaLinea = new ArrayList<>();

    // Primer constructor, para crear la factura:
    /**
     * @param numIdentificador numero para identificar.
     * @param numCliente       numero de identificador del cliente.
     */
    public EjerFacturas(int numIdentificador, int numCliente) {
        this.numIdentificador = numIdentificador;
        this.numCliente = numCliente;
    }

    // getters y setters
    public int getNumIdentificador() {
        return numIdentificador;
    }

    public void setNumIdentificador(int numIdentificador) {
        this.numIdentificador = numIdentificador;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }

    // metodos
    /**
     * Implementar la clase con su constructor y métodos para añadir línea de
     * factura, eliminar
     * línea de factura y mostrar la factura por consola.
     */

    // añadir línea de factura
    public static void añadirLinea() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Una descripcion: ");
        String description = teclado.nextLine();
        System.out.println("Precio unitario: ");
        double precioUnidad = teclado.nextDouble();
        System.out.println("La cantidad de unidades que hay: ");
        int unidades = teclado.nextInt();
        // Otra forma:
        // --lineaFactura nuevaL = new lineaFactura(teclado.nextLine(),
        // teclado.nextDouble(), teclado.nextInt());----
        // creamos la nueva linea
        lineaFactura nuevaL = new lineaFactura(description, precioUnidad, unidades);
        // La añadimos
        nuevaLinea.add(nuevaL);
        teclado.close();
    }

    // eliminar linea de factura
    public static void eliminarLinea() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Que linea quieres borrar: ");
        int linea = teclado.nextInt();
        nuevaLinea.remove(linea);
        teclado.close();
    }

    // mostrar la factura.
    //public String toString {
      //  return " Factura";
    //}

    // Importe total: inicialmente cero, y se va actualizando siempre que se
    // añadan/eliminen líneas.
    public double importePrecio(ArrayList<lineaFactura>nueva_Linea) {
        double price=0;
        for (int i = 0; i < nueva_Linea.size(); i++) {
            price+=nueva_Linea.get(i).descuentoAplicableAlCinco();
        }
        double conIva = iva/100*price;
        return price+conIva;
    }

}

/** Clase LINEA DE FACTURA: */
class lineaFactura {
    /**
     * Un número indeterminado de lineaFactura que contienen:
     * Descripción del producto
     * Precio unitario
     * Cantidad de unidades
     * Porcentaje de descuento: 5% para líneas con más de 10 unidades.
     * Importe total de la línea.
     */

    private String descripcion;
    private double precioUnitario;
    private int cantidadUnidades;
    private double importTotal = 0;


    private static final int descuentoPorDiezUnidades = 5;

    public lineaFactura(String descripcion, double precioUnitario, int cantidadUnidades) {
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.cantidadUnidades = cantidadUnidades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public double getImportTotal() {
        return importTotal;
    }

    public void setImportTotal(double importTotal) {
        this.importTotal = importTotal;
    }

    public double descuentoAplicableAlCinco(){
        if (cantidadUnidades>10) {
            double priceDiscount = (descuentoPorDiezUnidades/100*(precioUnitario*cantidadUnidades));
            return (precioUnitario*cantidadUnidades)-priceDiscount;
        }else{
            setImportTotal(precioUnitario*cantidadUnidades);
            return precioUnitario*cantidadUnidades;
        }
    }

    public static void main(String[] args) {
        


    }







}