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
    private static int cont = 0;
    private final int identificador = ++cont;
    private final String nombreProducto;
    private double precioVenta;
    private double precioCompra;
    private static int iva = 21;
    private int stock;

    public Articulo(String name, double precioDeVenta,double precioDeCompra, int stockEnAlmacen) {
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

    // Revisar:
    public void setPrecioCompra(double precioCompra) {
        if (precioCompra > 0) {
            this.precioCompra = precioCompra;
        } else {
            System.err.println("Cantidad precio venta incorrecta.");
            this.precioVenta = 0;
        }
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioVenta(double precioVenta) {
        if (precioVenta > getPrecioCompra() && precioVenta > 0) {
            this.precioVenta = precioVenta;
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
    public boolean metodoVender(int cuantasUnidadesVenderas) {
        if (cuantasUnidadesVenderas <= this.stock && cuantasUnidadesVenderas > 0) {
            this.stock -= cuantasUnidadesVenderas;
            return true;
            //System.out.println("Venta realizada con exito.");
        } else {
            return false;
            //System.err.println("Error en la cantidad a vender especificada.");
        }
    }
    // Se le compra al proveedor:
    public boolean metodoComprar(int cantidadUnidadesComprar) {
        this.stock += cantidadUnidadesComprar;
        return true;
        //System.out.println("Compra realizada con exito.");
    }

    public int getIdentificador() {
        return identificador;
    }

    /**
     * • Deberá tener un método público que devuelva una cadena de texto de una sola
     * línea con la información sobre dicho artículo: id, nombre, precios, IVA y
     * stock.
     */

    /** Creo un toString */
    public String toString() {
        return "Articulo [identificador=" + identificador + ", nombreProducto=" + nombreProducto + ", precioVenta="
                + precioVenta + ", precioCompra=" + precioCompra + ", stock=" + stock + "]";
    }

    public void mostrarDatos(){
        System.out.println("ID "+identificador+" nombre articulo "+nombreProducto+" el precio de venta "+precioVenta+" precio de compra "+precioCompra+" cantidad de unidades "+stock);
    }

    /** Clase Tienda: */

    static class Tienda {
        // metodo estatico para scanner en la clase.
        static Scanner teclado = new Scanner(System.in);

        // Primer menu.
        static void menuUnoPrincipal() {
            System.out.println("Selecciona una opcion: ");
            System.out.println("1. Mostrar artículos.\r\n" + //
                    "2. Venta a cliente.\r\n" + //
                    "3. Compra a proveedor.\r\n" + //
                    "4. Gestionar artículos.\r\n" + //
                    "5. Salir.");
            System.out.println("Opcion: ");
            boolean sali = false; // boolean para un while.
            while (!sali) {
                int num = teclado.nextInt(); // opcion de menu uno.
                switch (num) {
                    case 1:
                        mostrarArticulos();
                        break;
                    case 2:
                        venderArticulo();
                        menuUnoPrincipal();
                        break;
                    case 3:
                        comprarAlProveedor();
                        menuUnoPrincipal();
                        break;
                    case 4:
                        subMenu();
                        break;
                    case 5:
                    System.out.println("Adios!");
                        sali = true;
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
            for (Articulo item : articulo) {
                System.out.println("ID: "+item.getIdentificador());
                System.out.println("Nombre del producto: "+item.getNombreProducto());
                System.out.println("Precio de venta "+item.getPrecioVenta());
                System.out.println("Precio de compra "+item.getPrecioCompra());
                System.out.println("Hay "+item.getStock()+" unidades en stock.");
                System.out.println();
            }
            System.out.println();
            menuUnoPrincipal();
        }

        // Funcion para vender.
        public static void venderArticulo() {
            System.out.println("Identificador");
            int id = teclado.nextInt();
            System.out.println("Cantidad de unidades: ");
            int canti = teclado.nextInt();
            System.out.println("Nombre del comprador: ");
            String name = teclado.nextLine();

            for (int i = 0; i < articulo.size(); i++) {
                if (articulo.get(i).getIdentificador() == id) {
                    if (canti <= articulo.get(i).getStock()) {
                        double precio = articulo.get(i).getPrecioVenta();
                        double precioTotal = (canti * precio + (canti * precio *(21 / 100)));

                        System.out.println("Total a pagar: " + precioTotal);
                        System.out.println("¿Desea seguir con la compra?(si/no).");
                        String respuesta = teclado.nextLine();

                        if (respuesta.toLowerCase().equals("si")) {
                            articulo.get(i).setStock(articulo.get(i).getStock() - canti);
                            System.out.println("Operacion realizada con exito.");
                        } else if (respuesta.toLowerCase().equals("no")) {
                            System.err.println("Operacion cancelada");
                        }
                    }
                }
            }
            System.out.println();
            menuUnoPrincipal();
        }

        // Comprar al proveedor.
        public static void comprarAlProveedor() {
            System.out.println("Identificador");
            int identi = teclado.nextInt();
            System.out.println("Cantidad de unidades deseada.");
            int cantidadDeseada = teclado.nextInt();

            for (int i = 0; i < articulo.size(); i++) {
                if (articulo.get(i).getIdentificador() == identi) {
                    Scanner sc = new Scanner(System.in);
                    double precio = articulo.get(i).getPrecioCompra();
                    double totalAPagar = cantidadDeseada*precio+(cantidadDeseada*precio*(21/100));
                    System.out.println("Cantidad a pagar " + totalAPagar);
                    System.out.println("¿Desea seguir con la compra?(si/no).");
                    String respuesta = sc.next();
                    sc.nextLine();

                    if (respuesta.toLowerCase().equals("si")) {
                        articulo.get(i).setStock(articulo.get(i).getStock()+cantidadDeseada);
                        System.out.println("Operacion realizada con exito.");
                    } else if (respuesta.toLowerCase().equals("no")) {
                        System.err.println("Operacion cancelada");
                    }
                }
            }
            System.out.println();
            menuUnoPrincipal();
        }

        // Submenu con 3 opciones.
        static void subMenu() {
            boolean salir = false;
            while (!salir) {
                System.out.println("Seleciona una opcion de las siguentes: ");
                System.out.println("1. Añadir artículo \n2. Editar artículo \n3. Eliminar artículo \n4. Volver");
                int numerin = teclado.nextInt();
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
                        salir=true;
                        break;
                    default:
                        System.err.println("Opcion incorrecta.");
                        break;
                }
            }
        }

        // Aqui agregamos las funciones del submenu.
        // Funcion para añadir articulos. se pediran datos que luego se almacenan en
        // article y añadir a un arraylist principal..
        public static void aniadirArticulo() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nombre del producto: ");
            String name = sc.nextLine();
            System.out.println("Precio de venta: ");
            double precioDeVenta = teclado.nextDouble();
            System.out.println("Precio de compra al proveedor: ");
            double priceProveedor = teclado.nextDouble();
            System.out.println("Unidades en stock: ");
            int stockUniti = teclado.nextInt();
            Articulo article = new Articulo(name, precioDeVenta, priceProveedor, stockUniti);
            articulo.add(article);
        }

        // Funcion para editar un articulo el nombre es final asique podremos modificar
        // los otros atributos:
        public static void editarArticulo() {
            System.out.println("Cual es el id del articulo: ");
            // En mi caso el id de los productos van a ser los numeros naturales ordenados
            // 1,2,3,4....
            int id = teclado.nextInt();
            for (int i = 0; i < articulo.size(); i++) {
                if (articulo.get(i).getIdentificador() == id) {
                    System.out.println("Nuevo precio para el articulo de venta: " + id);
                    double newPriceVen = teclado.nextDouble();
                    System.out.println("Precio compra al proveedor: ");
                    double newPriceComProv = teclado.nextDouble();
                    System.out.println("Unidades en stock: ");
                    int unitisStock = teclado.nextInt();
                    // Agregamos los datos.
                    articulo.get(i).setPrecioCompra(newPriceComProv);
                    articulo.get(i).setPrecioVenta(newPriceVen);
                    articulo.get(i).setStock(unitisStock);
                }
            }
        }

        // Funcion eliminar producto.
        public static void eliminarProductSubmenu() {
            System.out.println("Cual es el id del articulo: ");
            // En mi caso el id de los productos van a ser los numeros naturales ordenados
            // 1,2,3,4....
            int id = teclado.nextInt();
            for (int i = 0; i < articulo.size(); i++) {
                if (articulo.get(i).getIdentificador() == id) {
                    articulo.remove(i);
                } else
                    System.err.println("id inválido");
            }
        }

        /**
         * Programa main
         */

        public static void main(String[] args) {
            //Todo se edita mediante listas.
            Articulo zapas = new Articulo("Nike nocta", 300, 70, 4);
            Articulo camisa = new Articulo("Camisa gucci", 200, 100, 19);
            articulo.add(zapas);
            articulo.add(camisa);
            menuUnoPrincipal();
        }
    }
}

