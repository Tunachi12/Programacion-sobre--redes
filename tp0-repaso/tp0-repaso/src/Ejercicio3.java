import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese una oración: ");
        String oracion = teclado.readLine().toLowerCase();

        int cantidad = 0;

        for (int i = 0; i < oracion.length(); i++) {
            char letra = oracion.charAt(i);

            if (letra == 'a' || letra == 'e' || letra == 'i'
                    || letra == 'o' || letra == 'u') {
                cantidad++;
            }
        }

        System.out.println("Cantidad de vocales: " + cantidad);
    }
}
