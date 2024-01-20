package ies.thiar.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class art {
    private static int cont = 0;
    private final int identificador = ++cont;
    private final String nombreProducto;
    private double precioVenta;
    private double precioCompra;
    private static int iva = 21;
    private int stock;

    public art(String name, double precioDeCompra, double precioDeVenta, int stockEnAlmacen) {
        this.nombreProducto = name;
        setPrecioCompra(precioDeCompra);
        setPrecioVenta(precioDeVenta);
        setStock(stockEnAlmacen);
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioCompra(double precioCompra) {
        if (precioCompra > 0) {
            this.precioCompra = precioCompra;
        } else {
            System.err.println("Cantidad precio compra al proveedor incorrecta.");
            this.precioCompra = 0;
        }
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioVenta(double precioVenta) {
        if (precioVenta > getPrecioCompra() && precioVenta > 0) {
            this.precioVenta = precioVenta;
        } else {
            System.err.println("Cantidad precio venta incorrecta.");
            this.precioVenta = 0;
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

    public boolean metodoVender(int cuantasUnidadesVenderas) {
        if (cuantasUnidadesVenderas <= this.stock && cuantasUnidadesVenderas > 0) {
            this.stock -= cuantasUnidadesVenderas;
            return true;
        } else {
            System.err.println("Error en la cantidad a vender especificada.");
            return false;
        }
    }

    public boolean metodoComprar(int cantidadUnidadesComprar) {
        this.stock += cantidadUnidadesComprar;
        return true;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String toString() {
        return "Articulo [identificador=" + identificador + ", nombreProducto=" + nombreProducto + ", precioVenta="
                + precioVenta + ", precioCompra=" + precioCompra + ", stock=" + stock + "]";
    }
}

class Tienda {
    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Articulo> articulo = new ArrayList<>();

    static void menuUnoPrincipal() {
        System.out.println("Selecciona una opcion: ");
        System.out.println("1. Mostrar artículos.\r\n" + "2. Venta a cliente.\r\n" + "3. Compra a proveedor.\r\n"
                + "4. Gestionar artículos.\r\n" + "5. Salir.");
        System.out.println("Opcion: ");
        boolean sali = false;
        while (!sali) {
            int num = teclado.nextInt();
            teclado.nextLine(); // Consumir el carácter de nueva línea
            switch (num) {
                case 1:
                    mostrarArticulos();
                    break;
                case 2:
                    venderArticulo();
                    break;
                case 3:
                    comprarAlProveedor();
                    break;
                case 4:
                    subMenu();
                    break;
                case 5:
                    sali = true;
                    break;
                default:
                    System.err.println("Opcion incorrecta.");
                    break;
            }
        }
    }

    public static void mostrarArticulos() {
        for (int i = 0; i < articulo.size(); i++) {
            System.out.println(articulo.get(i));
        }
    }

    public static void venderArticulo() {
        System.out.println("Identificador");
        int id = teclado.nextInt();
        teclado.nextLine(); // Consumir el carácter de nueva línea
        System.out.println("Cantidad de unidades: ");
        int canti = teclado.nextInt();
        teclado.nextLine(); // Consumir el carácter de nueva línea
        System.out.println("Nombre del comprador: ");
        String name = teclado.nextLine();

        double precio = articulo.get(id - 1).getPrecioVenta();
        double precioTotal = canti * precio * 21 / 100;

        if (articulo.get(id - 1).getStock() >= canti) {
            System.out.println("Total a pagar: " + precioTotal);
            System.out.println("¿Desea seguir con la compra?(si/no).");
            String respuesta = teclado.nextLine().toLowerCase();
            if (respuesta.equals("si")) {
                articulo.get(id - 1).setStock(articulo.get(id - 1).getStock() - canti);
                System.out.println("Operacion realizada con exito.");
            } else if (respuesta.equals("no")) {
                System.err.println("Operacion cancelada");
            }
        } else {
            System.err.println("Error en la cantidad a vender especificada.");
        }
    }

    public static void comprarAlProveedor() {
        System.out.println("Identificador");
        int identi = teclado.nextInt();
        teclado.nextLine(); // Consumir el carácter de nueva línea
        System.out.println("Cantidad de unidades deseada.");
        int cantidadDeseada = teclado.nextInt();
        teclado.nextLine(); // Consumir el carácter de nueva línea

        double totalAPagar = cantidadDeseada * articulo.get(identi - 1).getPrecioCompra();
        System.out.println("Cantidad a pagar " + totalAPagar);
        System.out.println("¿Desea seguir con la compra?(si/no).");
        String respuesta = teclado.nextLine().toLowerCase();
        if (respuesta.equals("si")) {
            articulo.get(identi - 1).setStock(articulo.get(identi - 1).getStock() + cantidadDeseada);
            System.out.println("Operacion realizada con exito.");
        } else if (respuesta.equals("no")) {
            System.err.println("Operacion cancelada");
        }
    }

    static void subMenu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("Selecciona una opcion de las siguientes: ");
            System.out.println("1. Añadir artículo \n2. Editar artículo \n3. Eliminar artículo \n4. Volver");
            int numerin = teclado.nextInt();
            teclado.nextLine(); // Consumir el carácter de nueva línea
            switch (numerin) {
                case 1:
                    aniadirArticulo();
                    break;
                case 2:
                    editarArticulo();
                    break;
                case 3:
                    eliminarProductSubmenu();
                    break;
                case 4:
                    menuUnoPrincipal();
                    salir = true;
                    break;
                default:
                    System.err.println("Opcion incorrecta.");
                    break;
            }
        }
    }

    public static void aniadirArticulo() {
        teclado.nextLine();
        System.out.println("Nombre del producto: ");
        String nombre = teclado.nextLine();
        //String name = teclado.nextLine();
        System.out.println("Precio de venta: ");
        double price = teclado.nextDouble();
        System.out.println("Precio de compra al proveedor: ");
        double priceProveedor = teclado.nextDouble();
        System.out.println("Unidades en stock: ");
        int stockUniti = teclado.nextInt();
        Articulo article = new Articulo(nombre, priceProveedor, price, stockUniti);
        articulo.add(article);
    }

    public static void editarArticulo() {
        System.out.println("Cual es el id del articulo: ");
        int id = teclado.nextInt();
        teclado.nextLine(); // Consumir el carácter de nueva línea
        for (int i = 0; i < articulo.size(); i++) {
            if (articulo.get(i).getIdentificador() == id) {
                System.out.println("Nuevo precio para el articulo de venta: " + id);
                double newPriceVen = teclado.nextDouble();
                System.out.println("Precio compra al proveedor: ");
                double newPriceComProv = teclado.nextDouble();
                System.out.println("Unidades en stock: ");
                int unitisStock = teclado.nextInt();
                articulo.get(i).setPrecioCompra(newPriceComProv);
                articulo.get(i).setPrecioVenta(newPriceVen);
                articulo.get(i).setStock(unitisStock);
            }
        }
    }

    public static void eliminarProductSubmenu() {
        System.out.println("Cual es el id del articulo: ");
        int id = teclado.nextInt();
        teclado.nextLine(); // Consumir el carácter de nueva línea
        for (int i = 0; i < articulo.size(); i++) {
            if (articulo.get(i).getIdentificador() == id) {
                articulo.remove(i);
                System.out.println("Operacion realizada con exito.");
                return; // Importante salir del bucle después de eliminar el artículo.
            }
        }
        System.err.println("ID inválido. Operacion cancelada.");
    }

    public static void main(String[] args) {
        menuUnoPrincipal();
    }
}

