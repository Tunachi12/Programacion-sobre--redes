import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio8 {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese la ruta completa de un archivo: ");
        String ruta = teclado.readLine();

        int posicionPunto = ruta.lastIndexOf(".");

        if (posicionPunto != -1 && posicionPunto < ruta.length() - 1) {
            String extension = ruta.substring(posicionPunto + 1);
            System.out.println("Extensión: " + extension);
        } else {
            System.out.println("No se encontró una extensión.");
        }
    }
}
