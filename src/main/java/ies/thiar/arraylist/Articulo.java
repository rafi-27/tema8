package ies.thiar.arraylist;

/**
 * Clase Articulo:
 */
public class Articulo {
    /**. El identificador ha de establecerse
     * automáticamente y ser único, podemos llevar un contador de los objetos creados y
     * así el identificador será único. */
    private static int identificador;
    private static String nombreProducto;
    private double precioVenta;
    private double precioCompra;
    private static int iva=21;
    private int stock;

    int cont=1;

    public Articulo(String name, double precioDeCompra, double precioDeVenta, int stockEnAlmacen){
        this.nombreProducto=name;
        setPrecioCompra(precioDeCompra);
        setPrecioVenta(precioDeVenta);
        this.stock=stockEnAlmacen;
        this.identificador=cont;
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

    //Revisar:
    public void setPrecioVenta(double precioVenta) {
        if (precioVenta > getPrecioCompra() && precioVenta > 0) {
            this.precioVenta = precioVenta;
        }else{
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
        } else{
            System.err.println("Cantidad precio compra al proveedor incorrecta.");
            this.precioCompra = 0;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock>0) {
            this.stock = stock;    
        }else{
            System.err.println("Cantidad de stock incorrecta.");
            this.stock = 0;
        }
        
    }

    //Metodos los dos publicos uno para vender y otro

    //Empezamos con vender y añadirle el iva:
    public void metodoVender(int cuantasUnidadesVenderas){
        if (cuantasUnidadesVenderas <= this.stock && cuantasUnidadesVenderas > 0) {
            this.stock-=cuantasUnidadesVenderas;
            double operacion = (cuantasUnidadesVenderas*precioCompra*(100-iva)/100);
            System.out.println("Venta realizada con exito.");
        }else{
            System.err.println("Error en la cantidad a vender especificada.");
        }
    }

    //Se le compra al proveedor:
    public void metodoComprar(int cantidadUnidadesComprar){
        this.stock+=cantidadUnidadesComprar;
        System.out.println("Compra realizada con exito.");
    }



    










}
