import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio13 {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese una oración que contenga la palabra error: ");
        String frase = teclado.readLine();

        StringBuilder texto = new StringBuilder(frase);

        int inicio = texto.indexOf("error");

        if (inicio != -1) {
            int fin = inicio + "error".length();

            if (fin < texto.length() && texto.charAt(fin) == ' ') {
                fin++;
            }

            texto.delete(inicio, fin);
            System.out.println(texto.toString());
        } else {
            System.out.println("La palabra error no fue encontrada.");
        }
    }
}
