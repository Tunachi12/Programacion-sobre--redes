import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio15 {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese la primera palabra: ");
        String primera = teclado.readLine();

        System.out.print("Ingrese la segunda palabra: ");
        String segunda = teclado.readLine();

        System.out.print("Ingrese la tercera palabra: ");
        String tercera = teclado.readLine();

        StringBuilder texto = new StringBuilder();

        texto.append(primera);
        texto.append("-");
        texto.append(segunda);
        texto.append("-");
        texto.append(tercera);

        int inicio = primera.length();
        int fin = inicio + segunda.length() + 2;

        texto.delete(inicio, fin);
        texto.insert(inicio, "-");

        System.out.println(texto.toString());
    }
}
