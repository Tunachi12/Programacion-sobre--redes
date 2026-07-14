import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese el nombre de una organización: ");
        String organizacion = teclado.readLine().trim();

        String[] palabras = organizacion.split("\\s+");
        String acronimo = "";

        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                acronimo += Character.toUpperCase(palabra.charAt(0));
            }
        }

        System.out.println("Acrónimo: " + acronimo);
    }
}
