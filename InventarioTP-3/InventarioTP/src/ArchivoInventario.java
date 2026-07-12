import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArchivoInventario {
    private static final String NOMBRE_ARCHIVO = "Inventario.dat";

    public static void crearArchivo() {
        File archivo = new File(NOMBRE_ARCHIVO);

        if (!archivo.exists()) {
            try {
                PrintWriter escritor = new PrintWriter(archivo);
                escritor.close();
            } catch (IOException e) {
                System.out.println(Colores.ROJO
                        + "No se pudo crear Inventario.dat."
                        + Colores.RESET);
            }
        }
    }

    public static ArrayList<Producto> leerProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        crearArchivo();

        try {
            BufferedReader lector = new BufferedReader(
                    new FileReader(NOMBRE_ARCHIVO)
            );

            String linea;

            while ((linea = lector.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    Producto producto = Producto.convertirDesdeRegistro(linea);

                    if (producto != null) {
                        productos.add(producto);
                    }
                }
            }

            lector.close();

        } catch (IOException e) {
            System.out.println(Colores.ROJO
                    + "No se pudo leer el inventario."
                    + Colores.RESET);
        }

        return productos;
    }

    public static void guardarTodos(ArrayList<Producto> productos) {
        try {
            PrintWriter escritor = new PrintWriter(
                    new FileWriter(NOMBRE_ARCHIVO)
            );

            for (Producto producto : productos) {
                escritor.println(producto.convertirARegistro());
            }

            escritor.close();

        } catch (IOException e) {
            System.out.println(Colores.ROJO
                    + "No se pudo guardar el inventario."
                    + Colores.RESET);
        }
    }

    public static void agregar(Producto producto) {
        try {
            PrintWriter escritor = new PrintWriter(
                    new FileWriter(NOMBRE_ARCHIVO, true)
            );

            escritor.println(producto.convertirARegistro());
            escritor.close();

        } catch (IOException e) {
            System.out.println(Colores.ROJO
                    + "No se pudo agregar el producto."
                    + Colores.RESET);
        }
    }
}
