import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        HashMap<String, String> diccionario = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Palabra en español: ");
            String espanol = teclado.nextLine().toLowerCase();

            System.out.print("Traducción: ");
            String traduccion = teclado.nextLine().toLowerCase();

            diccionario.put(espanol, traduccion);
        }

        System.out.println("\nDiccionario completo:");

        for (Map.Entry<String, String> entrada : diccionario.entrySet()) {
            System.out.println(entrada.getKey() + " = " + entrada.getValue());
        }

        System.out.println("\nClaves:");
        System.out.println(diccionario.keySet());

        System.out.println("\nValores:");
        System.out.println(diccionario.values());
    }
}
