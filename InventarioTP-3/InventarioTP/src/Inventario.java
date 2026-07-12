import java.util.ArrayList;

public class Inventario {

    public static void agregarProducto() {
        titulo("NUEVO PRODUCTO");

        String nombre = Entrada.leerTextoObligatorio("\tNombre: ");
        float compra = Entrada.leerPrecio("\tPrecio de compra: $");
        float venta = Entrada.leerPrecio("\tPrecio de venta: $");
        int stock = Entrada.leerEnteroPositivo("\tStock: ");

        ArrayList<Producto> productos = ArchivoInventario.leerProductos();

        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(Colores.ROJO
                        + "\n\tYa existe un producto con ese nombre."
                        + Colores.RESET);
                pausar();
                return;
            }
        }

        Producto nuevo = new Producto(nombre, compra, venta, stock);
        ArchivoInventario.agregar(nuevo);

        System.out.println(Colores.VERDE
                + "\n\tProducto guardado correctamente."
                + Colores.RESET);
        pausar();
    }

    public static void mostrarProductos() {
        titulo("LISTADO DEL INVENTARIO");

        ArrayList<Producto> productos = ArchivoInventario.leerProductos();

        if (productos.isEmpty()) {
            System.out.println(Colores.AMARILLO
                    + "\tNo hay productos registrados."
                    + Colores.RESET);
            pausar();
            return;
        }

        System.out.printf(
                Colores.CYAN + "%-5s %-24s %14s %14s %10s%n" + Colores.RESET,
                "N°", "PRODUCTO", "COMPRA", "VENTA", "STOCK"
        );

        System.out.println(
                "\t---------------------------------------------------------------------"
        );

        int numero = 1;

        for (Producto producto : productos) {
            System.out.printf(
                    "%-5d %-24s $%13.2f $%13.2f %10d%n",
                    numero,
                    producto.getNombre(),
                    producto.getPrecioCompra(),
                    producto.getPrecioVenta(),
                    producto.getStock()
            );

            numero++;
        }

        pausar();
    }

    public static void editarProducto() {
        titulo("EDITAR PRODUCTO");

        ArrayList<Producto> productos = ArchivoInventario.leerProductos();

        if (productos.isEmpty()) {
            System.out.println(Colores.AMARILLO
                    + "\tNo hay productos para editar."
                    + Colores.RESET);
            pausar();
            return;
        }

        String buscado = Entrada.leerTextoObligatorio(
                "\tNombre del producto: "
        );

        int posicion = buscarPosicion(productos, buscado);

        if (posicion == -1) {
            System.out.println(Colores.ROJO
                    + "\n\tProducto no encontrado."
                    + Colores.RESET);
            pausar();
            return;
        }

        Producto anterior = productos.get(posicion);

        System.out.println(Colores.AMARILLO
                + "\n\tIngrese los datos nuevos:"
                + Colores.RESET);

        String nombreNuevo = Entrada.leerTextoObligatorio(
                "\tNombre [" + anterior.getNombre() + "]: "
        );

        float compraNueva = Entrada.leerPrecio(
                "\tPrecio de compra: $"
        );

        float ventaNueva = Entrada.leerPrecio(
                "\tPrecio de venta: $"
        );

        int stockNuevo = Entrada.leerEnteroPositivo(
                "\tStock: "
        );

        Producto actualizado = new Producto(
                nombreNuevo,
                compraNueva,
                ventaNueva,
                stockNuevo
        );

        productos.set(posicion, actualizado);
        ArchivoInventario.guardarTodos(productos);

        System.out.println(Colores.VERDE
                + "\n\tProducto editado correctamente."
                + Colores.RESET);
        pausar();
    }

    public static void eliminarProducto() {
        titulo("ELIMINAR PRODUCTO");

        ArrayList<Producto> productos = ArchivoInventario.leerProductos();

        if (productos.isEmpty()) {
            System.out.println(Colores.AMARILLO
                    + "\tNo hay productos para eliminar."
                    + Colores.RESET);
            pausar();
            return;
        }

        String buscado = Entrada.leerTextoObligatorio(
                "\tNombre del producto: "
        );

        int posicion = buscarPosicion(productos, buscado);

        if (posicion == -1) {
            System.out.println(Colores.ROJO
                    + "\n\tProducto no encontrado."
                    + Colores.RESET);
            pausar();
            return;
        }

        Producto producto = productos.get(posicion);

        System.out.println(
                Colores.AMARILLO
                        + "\n\tSe eliminará: "
                        + producto.getNombre()
                        + Colores.RESET
        );

        String respuesta = Entrada.leerTexto(
                "\t¿Confirmar eliminación? (S/N): "
        );

        if (respuesta.equalsIgnoreCase("S")) {
            productos.remove(posicion);
            ArchivoInventario.guardarTodos(productos);

            System.out.println(Colores.VERDE
                    + "\n\tProducto eliminado."
                    + Colores.RESET);
        } else {
            System.out.println(Colores.AMARILLO
                    + "\n\tOperación cancelada."
                    + Colores.RESET);
        }

        pausar();
    }

    private static int buscarPosicion(
            ArrayList<Producto> productos,
            String nombre
    ) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }

        return -1;
    }

    private static void titulo(String texto) {
        System.out.println();
        System.out.println(
                Colores.AZUL
                        + "╔════════════════════════════════════════════════════════════════════╗"
                        + Colores.RESET
        );

        System.out.printf(
                Colores.AZUL + "║ %-66s ║%n" + Colores.RESET,
                texto
        );

        System.out.println(
                Colores.AZUL
                        + "╚════════════════════════════════════════════════════════════════════╝"
                        + Colores.RESET
        );
    }

    private static void pausar() {
        Entrada.leerTexto(
                Colores.VIOLETA
                        + "\n\tPresione ENTER para continuar..."
                        + Colores.RESET
        );
    }
}
