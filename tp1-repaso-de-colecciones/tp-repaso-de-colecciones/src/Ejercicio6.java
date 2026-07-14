import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<String> palabras = new ArrayList<>();
        ArrayList<String> normalizadas = new ArrayList<>();

        System.out.print("Ingrese una frase: ");
        String frase = teclado.nextLine();

        String[] separadas = frase.split("\\s+");

        for (String palabra : separadas) {
            palabras.add(palabra);
        }

        for (String palabra : palabras) {
            String resultado = palabra
                    .trim()
                    .toLowerCase()
                    .replaceAll("[aeiouáéíóú]", "*");

            normalizadas.add(resultado);
        }

        System.out.println("Lista original: " + palabras);
        System.out.println("Lista normalizada: " + normalizadas);
    }
}
