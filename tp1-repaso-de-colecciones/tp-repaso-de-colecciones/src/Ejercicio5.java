import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<String> palabras = new ArrayList<>();

        System.out.print("Ingrese una frase: ");
        String frase = teclado.nextLine();

        String[] separadas = frase.trim().split("\\s+");

        for (String palabra : separadas) {
            palabras.add(palabra);
        }

        System.out.print("Ingrese una letra específica: ");
        char letra = teclado.nextLine().toLowerCase().charAt(0);

        String palabraMasLarga = "";
        int cantidadConLetra = 0;

        for (String palabra : palabras) {
            if (palabra.length() > palabraMasLarga.length()) {
                palabraMasLarga = palabra;
            }

            if (palabra.toLowerCase().contains(String.valueOf(letra))) {
                cantidadConLetra++;
            }
        }

        System.out.println("Cantidad de palabras: " + palabras.size());
        System.out.println("Palabra más larga: " + palabraMasLarga);
        System.out.println("Palabras que contienen '" + letra + "': " + cantidadConLetra);
    }
}
