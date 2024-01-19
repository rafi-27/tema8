package ies.thiar.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Articulo:
 */
public class Articulo {
    /**
     * . El identificador ha de establecerse
     * automáticamente y ser único, podemos llevar un contador de los objetos
     * creados y
     * así el identificador será único.
     */
    private static int identificador;
    private static String nombreProducto;
    private double precioVenta;
    private double precioCompra;
    private static int iva = 21;
    private int stock;

    private static int cont = 1;

    public Articulo(String name, double precioDeCompra, double precioDeVenta, int stockEnAlmacen) {
        this.nombreProducto = name;
        setPrecioCompra(precioDeCompra);
        setPrecioVenta(precioDeVenta);
        this.stock = stockEnAlmacen;
        this.identificador = cont;
        cont++;
    }

    public static String getNombreProducto() {
        return nombreProducto;
    }

    public static void setNombreProducto(String nombreProducto) {
        Articulo.nombreProducto = nombreProducto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    // Revisar:
    public void setPrecioVenta(double precioVenta) {
        if (precioVenta > getPrecioCompra() && precioVenta > 0) {
            this.precioVenta = precioVenta;
        } else {
            System.err.println("Cantidad precio venta incorrecta.");
            this.precioVenta = 0;
        }
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        if (precioCompra > 0) {
            this.precioCompra = precioCompra;
        } else {
            System.err.println("Cantidad precio compra al proveedor incorrecta.");
            this.precioCompra = 0;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock > 0) {
            this.stock = stock;
        } else {
            System.err.println("Cantidad de stock incorrecta.");
            this.stock = 0;
        }

    }

    // Metodos los dos publicos uno para vender y otro

    // Empezamos con vender y añadirle el iva:
    public void metodoVender(int cuantasUnidadesVenderas) {
        if (cuantasUnidadesVenderas <= this.stock && cuantasUnidadesVenderas > 0) {
            this.stock -= cuantasUnidadesVenderas;
            double operacion = (cuantasUnidadesVenderas * precioCompra * (100 - iva) / 100);
            System.out.println("Venta realizada con exito.");
        } else {
            System.err.println("Error en la cantidad a vender especificada.");
        }
    }

    // Se le compra al proveedor:
    public void metodoComprar(int cantidadUnidadesComprar) {
        this.stock += cantidadUnidadesComprar;
        System.out.println("Compra realizada con exito.");
    }

    /**
     * • Deberá tener un método público que devuelva una cadena de texto de una sola
     * línea con la información sobre dicho artículo: id, nombre, precios, IVA y
     * stock.
     */

    public void mostrarDatosArticulo() {
        System.out.println("ID articulo " + identificador + " nombre: " + nombreProducto + " porcentage de iva " + iva
                + " en stock hay " + stock);
    }
    /** Creo un toString */

}

/** Clase Tienda: */

class Tienda {
    // metodo estatico para scanner en la clase.
    static Scanner teclado = new Scanner(System.in);

    // Primer menu.
    void menuUnoPrincipal() {
        System.out.println("Selecciona una opcion: ");
        System.out.println("1. Mostrar artículos.\r\n" + //
                "2. Venta a cliente.\r\n" + //
                "3. Compra a proveedor.\r\n" + //
                "4. Gestionar artículos.\r\n" + //
                "5. Salir.");
        System.out.println("Opcion: ");
        int num = teclado.nextInt(); // opcion de menu uno.
        boolean sali = false; // boolean para un while.
        while (!sali) {
            switch (num) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                subMenu();
                switch (subMenu()) {
                    case 1:
                        
                        break;
                    case 2:

                        break;

                    case 3:

                        break;
                    case 4:
                        menuUnoPrincipal();
                        break;
                    default:
                    System.err.println("Opcion incorrecta.");
                        break;
                }
                    break;
                case 5:
                sali=true;
                    break;
                default:
                    System.err.println("Opcion incorrecta.");
                    break;
            }
        }
    }
    // Creo un array list:
    static ArrayList<Articulo> articulo = new ArrayList<>();


    // Primera opcion mostrar articulos:
    public static void mostrarArticulos() {

    }

    // Funcion para vender.
    public static void venderArticulo() {

    }

    // Comprar al proveedor.
    public static void comprarAlProveedor() {

    }

    // Submenu con 3 opciones.
    int subMenu() {
        System.out.println("Seleciona una opcion de las siguentes: ");
        System.out.println("‘1. Añadir artículo’, \n‘2.Editar artículo’, \n‘3. Eliminar artículo’ \n‘4. Volver’.");
        int num = teclado.nextInt();
        return num;
    }
    // Aqui agregamos las funciones del submenu.
    public static void aniadirArticulo(){
        System.out.println("Nombre del producto: ");
        String name = teclado.nextLine();
        System.out.println("Precio de venta: ");
        double price = teclado.nextDouble();
        System.out.println("Precio de compra al proveedor: ");
        double priceProveedor = teclado.nextDouble();
        System.out.println("Unidades en stock: ");
        int stockUniti = teclado.nextInt();

        Articulo article = new Articulo(name, price, priceProveedor, stockUniti);
        articulo.add(article);
    }
}
