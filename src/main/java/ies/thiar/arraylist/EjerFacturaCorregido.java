package ies.thiar.arraylist;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class EjerFacturaCorregido {
/** CLASE FACTURA */

    private int numIdentificador;
    private LocalDate fechaFactura;
    private int numCliente;
    private static final double iva = 21;
    private static double importeTotal;

    private static ArrayList<lineaFactura> lista;

    public EjerFacturaCorregido(int numIdentificador, int numCliente) {
        this.numIdentificador = numIdentificador;
        this.numCliente = numCliente;
        this.fechaFactura = LocalDate.now();
        this.lista = new ArrayList<>();
    }

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

    public static void añadirLinea(String description, double price, int cantidad) {
        lineaFactura linea = new lineaFactura(description, price, cantidad);
        importeTotal += linea.importTotal();
        lista.add(linea);
    }

    public static void eliminarLinea(int line) {
        lineaFactura linea = lista.remove(line);
        importeTotal -= linea.importTotal();
    }

    @Override
    public String toString() {
        return "EjerFacturas [numIdentificador=" + numIdentificador + ", fechaFactura=" + fechaFactura
                + ", numCliente=" + numCliente + ", importTotal=" + importeTotal + "]";
    }

    public static class lineaFactura {
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

        public int dameDescuento() {
            if (cantidadUnidades > 10)
                return 5;
            else
                return 0;
        }

        public double importTotal() {
            return (this.cantidadUnidades * this.precioUnitario * (100 - this.dameDescuento()) / 100);
        }

        @Override
        public String toString() {
            return "lineaFactura [descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
                    + ", cantidadUnidades=" + cantidadUnidades + ", importTotal=" + importTotal + "]";
        }
    }

    public static class programa {

        EjerFacturas factura = null;

        public static void main(String[] args) {
            programa program = new programa();

            while (true) {
                switch (program.menu()) {
                    case 0: {
                        System.exit(0);
                    }
                    case 1: {
                        program.factura = program.altaFactura();
                        break;
                    }
                    case 2: {
                        if (program.factura != null)
                            program.altaLinea();
                        else
                            System.out.println("La factura no se ha dado de alta");
                        break;
                    }
                    case 3: {
                        if (program.factura != null)
                            program.bajaLinea();
                        else
                            System.out.println("La factura no se ha dado de alta");
                        break;
                    }
                    case 4: {
                        if (program.factura != null)
                            System.out.println(program.factura.toString());
                        else
                            System.out.println("La factura no se ha dado de alta");
                        break;
                    }
                    default:
                        System.err.println("Opción incorrecta.");
                }
            }
        }

        int menu() {
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

        EjerFacturas altaFactura() {
            Scanner entrada = new Scanner(System.in);
            System.out.print("Introduce el número de la factura:");
            int id = entrada.nextInt();
            System.out.print("Introduce el número de cliente:");
            int cliente = entrada.nextInt();
            return new EjerFacturas(id, cliente);
        }

        void altaLinea() {
            Scanner entrada = new Scanner(System.in);
            System.out.print("Introduce la descripción del producto: ");
            String descripcion = entrada.nextLine();
            System.out.print("Introduce el precio unitario del producto: ");
            double precioU = Double.parseDouble(entrada.nextLine());
            System.out.print("Introduce la cantidad de unidades: ");
            int cantidad = Integer.parseInt(entrada.nextLine());
            EjerFacturas.añadirLinea(descripcion, precioU, cantidad);
            System.out.println("Línea añadida correctamente");
        }

        void bajaLinea() {
            Scanner entrada = new Scanner(System.in);
            System.out.print("Introduce el número de línea a borrar: ");
            int linea = Integer.parseInt(entrada.nextLine());
            EjerFacturas.eliminarLinea(linea);
            System.out.println("Línea eliminada correctamente");
        }
    }
}
