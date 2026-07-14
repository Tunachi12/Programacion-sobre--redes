import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio6 {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese una frase con espacios de sobra: ");
        String frase = teclado.readLine();

        String resultado = frase.trim().replaceAll("\\s+", " ");

        System.out.println("Frase formateada: " + resultado);
    }
}
