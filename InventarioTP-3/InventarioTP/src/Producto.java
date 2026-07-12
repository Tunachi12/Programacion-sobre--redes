public class Producto {
    private String nombre;
    private float precioCompra;
    private float precioVenta;
    private int stock;

    public Producto(String nombre, float precioCompra, float precioVenta, int stock) {
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
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

    public String convertirARegistro() {
        return nombre + ";" + precioCompra + ";" + precioVenta + ";" + stock;
    }

    public static Producto convertirDesdeRegistro(String linea) {
        String[] datos = linea.split(";");

        if (datos.length != 4) {
            return null;
        }

        try {
            String nombre = datos[0];
            float compra = Float.parseFloat(datos[1]);
            float venta = Float.parseFloat(datos[2]);
            int stock = Integer.parseInt(datos[3]);

            return new Producto(nombre, compra, venta, stock);

        } catch (NumberFormatException e) {
            return null;
        }
    }
}
