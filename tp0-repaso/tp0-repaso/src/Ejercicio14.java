import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio14 {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese una palabra: ");
        String palabra = teclado.readLine();

        StringBuilder texto = new StringBuilder(palabra);

        texto.insert(0, "<b>");
        texto.append("</b>");

        System.out.println(texto.toString());
    }
}
