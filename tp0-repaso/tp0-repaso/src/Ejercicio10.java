import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio10 {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese el texto principal: ");
        String texto = teclado.readLine();

        System.out.print("Ingrese el fragmento a buscar: ");
        String fragmento = teclado.readLine();

        int inicio = texto.indexOf(fragmento);

        if (inicio != -1) {
            int fin = inicio + fragmento.length() - 1;

            System.out.println("Empieza en la posición: " + inicio);
            System.out.println("Termina en la posición: " + fin);
        } else {
            System.out.println("El fragmento no fue encontrado.");
        }
    }
}
