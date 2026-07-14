import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio12 {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese su nombre completo: ");
        String nombre = teclado.readLine();

        StringBuilder texto = new StringBuilder(nombre);
        texto.insert(0, "Dr./Dra. ");

        System.out.println(texto.toString());
    }
}
