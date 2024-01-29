package ies.thiar.arraylist;

import java.time.LocalDate;
import java.util.ArrayList;
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
    private LocalDate fechaFactura; // fecha del alta.
    private int numCliente;
    private static final double iva = 21;
    private static double importeTotal;

    // Creamos el array list:
    private static ArrayList<lineaFactura> lista;

    // Primer constructor, para crear la factura:
    /**
     * @param numIdentificador numero para identificar.
     * @param numCliente       numero de identificador del cliente.
     */
    public EjerFacturas(int numIdentificador, int numCliente) {
        this.numIdentificador = numIdentificador;
        this.numCliente = numCliente;
        this.fechaFactura = LocalDate.now();
        this.lista = new ArrayList<>();
    }

    // getters y setters
    public int getNumIdentificador() {
        return numIdentificador;
    }

    public void setNumIdentificador(int numIdentificador) {
        this.numIdentificador = numIdentificador;
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
    public static void añadirLinea(String description, double price, int cantidad) {
        lineaFactura linea = new lineaFactura(description, price, cantidad);
        importeTotal += linea.importTotal();
        
        // Otra forma:
        // --lineaFactura nuevaL = new lineaFactura(teclado.nextLine(),
        // teclado.nextDouble(), teclado.nextInt());----
        // creamos la nueva linea
        
        // La añadimos
        lista.add(linea);
    }

    // eliminar linea de factura
    public static void eliminarLinea(int line) {
        lineaFactura linea = lista.remove(line);
        importeTotal -= linea.importTotal();
    }

    // mostrar la factura.
    @Override
    public String toString() {
        return "EjerFacturas [numIdentificador=" + numIdentificador + ", fechaFactura=" + fechaFactura + ", numCliente="
                + numCliente + ", importTotal=" + importeTotal + "]";
    }

    // Importe total: inicialmente cero, y se va actualizando siempre que se
    // añadan/eliminen líneas.

    /** Clase LINEA DE FACTURA: */
    static class lineaFactura {
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

        public int dameDescuento(){
            if (cantidadUnidades>10) return 5;
                else return 0;
        }

        public double importTotal(){
            return(this.cantidadUnidades * this.precioUnitario * (100 - this.dameDescuento())/100);
        }

        @Override
        public String toString() {
            return "lineaFactura [descripcion=" + descripcion + ", precioUnitario=" + precioUnitario + ", cantidadUnidades="
                    + cantidadUnidades + ", importTotal=" + importTotal + "]";
        }

        int menu(){
            Scanner entrada = new Scanner(System.in);
                System.out.println("Facturas");
                System.out.println("1 - Alta Factura");
                System.out.println("2 - Añadir línea");
                System.out.println("3 - Eliminar línea");
                System.out.println("4 - Mostrar Factura");
                System.out.println("0 - Salir");
                System.out.print("Introduce la opción deseada:");
                return Integer.parseInt(entrada.nextLine());
        }

        void altaFactura(){
            Scanner entrada = new Scanner(System.in);
            System.out.print("Introduce el número de la factura:");
            int id = entrada.nextInt();
            System.out.print("Introduce el número de cliente:");
            int cliente = entrada.nextInt();
            EjerFacturas factura = new EjerFacturas(id,cliente);
        }

        void altaLinea() {
            Scanner entrada = new Scanner(System.in);
            System.out.print("Introduce la descripción del producto: ");
            String descripcion = entrada.nextLine();
            System.out.print("Introduce el precio unitario del producto: ");
            double precioU = Double.parseDouble(entrada.nextLine());
            System.out.print("Introduce la cantidad de unidades: ");
            int cantidad = Integer.parseInt(entrada.nextLine());
            añadirLinea(descripcion, precioU, cantidad);
            System.out.println("Linea añadida correctamente");
        }

        void bajaLinea() {
            Scanner entrada = new Scanner(System.in);
            System.out.print("Introduce el número de línea a borrar: ");
            int linea = Integer.parseInt(entrada.nextLine());
            eliminarLinea(linea);
            System.out.println("Línea eliminada correctamente");
        }

    }
}

