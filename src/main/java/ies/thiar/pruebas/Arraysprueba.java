import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

class Articulo {
    public static int contador = 0;
    private final int identificador = ++contador;
    private final String nombre;
    private float precioCompra;
    private float precioVenta;
    private static final int iva = 21;
    private int stock;

    /*
    Constructor
     */
    public Articulo(String nombre, float precioCompra, float precioVenta, int stock) {
        this.nombre = nombre;
        setPrecioCompra(precioCompra);
        setPrecioVenta(precioVenta);
        setStock(stock);
    }

    /*
    Setters
     */
    public void setPrecioCompra(float precioCompra) {
        // Verifica que el precio de compra no sea negativo, si lo es, establece un valor predeterminado de 1.
        if (precioCompra < 0) {
            System.err.println("Valor inválido, valor reestablecido");
            this.precioCompra = 1;
        } else this.precioCompra = precioCompra;
    }

    public void setPrecioVenta(float precioVenta) {
        // Verifica que el precio de venta no sea negativo o menor que el precio de compra, si lo es, ajusta el valor.
        if (precioVenta < this.precioCompra && precioVenta < 0) {
            System.err.println("Valor inválido, aplicando solución");
            precioVenta = precioCompra + 1;
        } else this.precioVenta = precioVenta;
    }


    public void setStock(int stock) {
        // Verifica que la cantidad de stock no sea negativa.
        if (stock < 0) {
            System.err.println("Parámetro erroneo");
        } else this.stock = stock;
    }

    /*
    Getters
     */
    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public int getStock() {
        return stock;
    }

    /*
    Métodos
     */
    public boolean vender(int cantidad) {
        // Verifica si hay suficiente stock para realizar la venta y actualiza la cantidad de stock.
        if (cantidad > stock) {
            System.err.println("Venta interrumpida");
            return false;
        }
        setStock(this.stock - cantidad);
        return true;
    }

    public boolean comprar(int cantidad) {
        // Incrementa la cantidad de stock al realizar una compra.
        setStock(this.stock + cantidad);
        return true;
    }

    public String toString() {
        return "Articulo{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", precioCompra=" + precioCompra +
                ", precioVenta=" + precioVenta +
                ", stock=" + stock +
                '}';
    }
}

class Tienda {
    /**
     * Pide al usuario introducir los datos necesarios para realizar una venta y comprueba si los datos son correctos
     * @param listaArtículos Se le introduce la lista de artículos
     * @return Devuelve la lista actualizada
     */
    public static ArrayList<Articulo> realizarVenta(ArrayList<Articulo> listaArtículos) {
        Scanner lector = new Scanner(System.in);
        int id=999999999, cantidad = 0;
        String nombreComprador;

        System.out.print("Introduce el identificador del artículo: ");
        String auxiliar = lector.nextLine();
        if (auxiliar.matches("\\d+")) id = Integer.parseInt(auxiliar);
        else System.err.println("Identificador inválido");

        System.out.print("Introduce el nombre del comprador: ");
        auxiliar = lector.nextLine();
        if (auxiliar.matches("[a-zA-Z]+")) nombreComprador=auxiliar;
        else System.err.println("Nombre inválido");

        System.out.print("Introduce la cantidad a comprar: ");
        auxiliar = lector.nextLine();
        if (auxiliar.matches("\\d+")) cantidad = Integer.parseInt(auxiliar);
        else System.err.println("Cantidad inválida");

        for (int i = 0; i < listaArtículos.size(); i++) {
            if (listaArtículos.get(i).getIdentificador() == id) confirmarVenta(listaArtículos, id, cantidad);
        }
        return listaArtículos;
    }

    /**
     * Método utilizado para confirmar la venta de un artículo
     * @param listaArtículos Lista con todos los artículos almacenados
     * @param id Identificador único del artículo
     * @param cantidad Cantidad a vender del artículo
     * @return Devuelve la lista actualizada
     */
    public static ArrayList<Articulo> confirmarVenta(ArrayList<Articulo> listaArtículos, int id, int cantidad) {
        float precioTotal = listaArtículos.get(id).getPrecioVenta();
        Scanner lector = new Scanner(System.in);
        precioTotal *= cantidad;

        System.out.println("El precio total sería: " + cantidad * precioTotal+(cantidad * precioTotal*(21/100)));

        System.out.println("Desea realizar la operación? (Si / No)");
        String opcion = lector.nextLine();
        opcion = opcion.toLowerCase();

        if (opcion.equals("si")) listaArtículos.get(id).setStock(listaArtículos.get(id).getStock()-cantidad);
        return listaArtículos;
    }

    /**
     * Método utilizado para confirmar la compra de un artículo
     * @param listaArtículos Lista con todos los artículos almacenados
     * @return Devuelve la lista actualizada
     */
    public static ArrayList<Articulo> realizarCompra(ArrayList<Articulo> listaArtículos) {
        Scanner lector = new Scanner(System.in);
        int id=999999999, cantidad = 0;
        String nombreProveedor;

        System.out.print("Introduce el identificador del artículo: ");
        String auxiliar = lector.nextLine();
        if (auxiliar.matches("\\d+")) id = Integer.parseInt(auxiliar);
        else System.err.println("Identificador inválido");

        System.out.print("Introduce el nombre del proveedor: ");
        auxiliar = lector.nextLine();
        if (auxiliar.matches("[a-zA-Z]+")) nombreProveedor=auxiliar;
        else System.err.println("Nombre inválido");

        System.out.print("Introduce la cantidad a comprar: ");
        auxiliar = lector.nextLine();
        if (auxiliar.matches("\\d+")) cantidad = Integer.parseInt(auxiliar);
        else System.err.println("Cantidad inválida");

        for (int i = 0; i < listaArtículos.size(); i++) {
            if (listaArtículos.get(i).getIdentificador() == id) confirmarCompra(listaArtículos, id, cantidad);
        }
        return listaArtículos;
    }

    /**
     * Método utilizado para confirmar la compra de un artículo
     * @param listaArtículos Lista con todos los artículos almacenados
     * @param id Identificador único del artículo
     * @param cantidad Cantidad a vender del artículo
     * @return Devuelve la lista actualizada
     */
    public static ArrayList<Articulo> confirmarCompra(ArrayList<Articulo> listaArtículos, int id, int cantidad) {
        float precioTotal = listaArtículos.get(id).getPrecioCompra();
        Scanner lector = new Scanner(System.in);
        precioTotal *= cantidad;

        System.out.println("El precio total sería: " + cantidad * precioTotal+(cantidad * precioTotal*(21/100)));
        System.out.println("Desea realizar la operación? (Si / No)");
        String opcion = lector.nextLine();
        opcion = opcion.toLowerCase();
        if (opcion.equals("si")) listaArtículos.get(id).setStock(listaArtículos.get(id).getStock()+cantidad);
        return listaArtículos;
    }

    /**
     * Menu principal
     * @param listaArtículos Lista con todos los artículos almacenados
     */
    public static void menu(ArrayList<Articulo> listaArtículos) {
        Scanner lector = new Scanner(System.in);
        int opcion = 9;
        do {
            System.out.println("1. Mostrar artículos");
            System.out.println("2. Venta a cliente");
            System.out.println("3. Compra a proveedor");
            System.out.println("4. Gestionar artículos");
            System.out.println("0. Salir");

            String auxiliar = lector.nextLine();
            if (auxiliar.matches("\\d+")) opcion = Integer.parseInt(auxiliar);
            else System.err.println("Caracter inválido");

            switch (opcion) {
                case 1:
                    System.out.println(listaArtículos);
                    break;
                case 2:
                    realizarVenta(listaArtículos);
                    break;
                case 3:
                    realizarCompra(listaArtículos);
                    break;
                case 4:
                    menuVentas(listaArtículos);
                    break;
                case 0:
                    System.out.println("Hasta la vista, baby...");
                    break;
                default:
                    break;
            }

        } while (opcion != 0);

    }

    /**
     * Método útilizado para añadir artículos nuevos a la lista
     * @param listaArtículos Lista con todos los artículos almacenados
     * @return Devuelve la lista actualizada
     */
    public static ArrayList<Articulo> añadirArticulo(ArrayList<Articulo> listaArtículos) {
        Scanner lector = new Scanner(System.in);
        int stock = 0;
        float precioVenta = 0, precioCompra = 0;
        String nombre = "No establecido";

        System.out.print("Indica el nombre del artículo: ");
        String auxiliar = lector.nextLine();
        if (auxiliar.matches("[a-zA-Z]+")) {
            nombre = auxiliar;
        } else System.err.println("Nombre inválido");

        auxiliar ="";
        System.out.print("Introduce el precio de compra: ");
        auxiliar = lector.nextLine();

        if (auxiliar.matches("^\\d+,?\\d{0,2}$")) {
            precioCompra = Float.parseFloat(auxiliar);
        } else System.err.println("Precio inválido de compra");

        auxiliar ="";
        System.out.print("Introduce el precio de venta: ");
        auxiliar = lector.nextLine();

        if (auxiliar.matches("^\\d+,?\\d{0,2}$")) {
            precioVenta = Float.parseFloat(auxiliar);
        } else System.err.println("Precio de venta inválido");

        System.out.print("Introduce la cantidad de stock: ");
        auxiliar = lector.nextLine();

        if (auxiliar.matches("\\d+")) {
            stock = Integer.parseInt(auxiliar);
        } else System.err.println("Cantidad de stock inválido");

        listaArtículos.add(new Articulo(nombre, precioCompra, precioVenta, stock));
        return listaArtículos;
    }

    /**
     * Método útilizado para editar un artículo
     * @param listaArtículos Lista con todos los artículos almacenados
     * @return Devuelve la lista actualizada
     */
    public static ArrayList<Articulo> editarArticulo(ArrayList<Articulo> listaArtículos) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Introduce el id del artículo a modificar: ");
        String auxiliar = lector.nextLine();
        if (auxiliar.matches("\\d+")) {
            int id = Integer.parseInt(auxiliar);
            for (Articulo listaArtículo : listaArtículos) {
                if (listaArtículo.getIdentificador() == id) {
                    System.out.print("Introduce el precio de compra: ");
                    auxiliar = lector.nextLine();
                    if (auxiliar.matches("^\\d+,?\\d{0,2}$")) {
                        listaArtículo.setPrecioCompra(Float.parseFloat(auxiliar));
                    } else System.err.println("Precio inválido, no editado");

                    System.out.print("Introduce el precio de venta: ");
                    auxiliar = lector.nextLine();
                    if (auxiliar.matches("^\\d+,?\\d{0,2}$")) {
                        listaArtículo.setPrecioVenta(Float.parseFloat(auxiliar));
                    } else System.err.println("Precio inválido, no editado");


                    System.out.print("Introduce la cantidad de stock: ");
                    auxiliar = lector.nextLine();
                    if (auxiliar.matches("\\d+")) {
                        listaArtículo.setStock(Integer.parseInt(auxiliar));
                    } else System.err.println("Cantidad in");
                }
            }
        }
        return listaArtículos;
    }

    /**
     * Método útilizado para eliminar un artículo de la lista
     * @param listaArtículos Lista con todos los artículos almacenados
     * @return Devuelve la lista actualizada
     */
    public static ArrayList<Articulo> eliminarArticulo(ArrayList<Articulo> listaArtículos) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el id del producto a eliminar");
        String auxiliar = lector.nextLine();
        if (auxiliar.matches("\\d+")) {
            int id = Integer.parseInt(auxiliar);
            listaArtículos.removeIf(listaArtículo -> listaArtículo.getIdentificador() == id);
        } else System.err.println("id inválido");
        return listaArtículos;
    }

    /**
     * SubMenu utilizado para Añadir / Editar / Eliminar artículos
     * @param listaArtículos Lista con todos los artículos almacenados
     * @return Devuelve la lista actualizada
     */
    public static ArrayList<Articulo> menuVentas(ArrayList<Articulo> listaArtículos) {
        Scanner lector = new Scanner(System.in);
        int opcion = 9;
        do {
            System.out.println("1. Añadir artículo");
            System.out.println("2. Editar artículo");
            System.out.println("3. Eliminar artículo");
            System.out.println("4. Volver");
            System.out.println("5. Finzalización del programa");

            String auxiliar = lector.nextLine();
            if (auxiliar.matches("\\d+")) opcion = Integer.parseInt(auxiliar);
            else System.err.println("Caracter inválido");

            switch (opcion) {
                case 1:
                    añadirArticulo(listaArtículos);
                    break;
                case 2:
                    editarArticulo(listaArtículos);
                    break;
                case 3:
                    eliminarArticulo(listaArtículos);
                    break;
                case 4:
                    menu(listaArtículos);
                    break;
                case 5:
                    System.out.println("Volveré...");
                    break;
                default:
                    System.err.println("Opción inválida");
                    break;
            }
        } while (opcion != 5);
        exit(1);
        return listaArtículos;
    }

    public static void main(String[] args) {
        ArrayList<Articulo> listaArtículos = new ArrayList<>();
        menu(listaArtículos);
    }
}

public class T8E8 { }