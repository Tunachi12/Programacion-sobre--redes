import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        HashMap<String, String> diccionario = new HashMap<>();

        diccionario.put("hola", "hello");
        diccionario.put("mundo", "world");
        diccionario.put("casa", "house");
        diccionario.put("perro", "dog");
        diccionario.put("gato", "cat");

        System.out.print("Ingrese una frase: ");
        String frase = teclado.nextLine();

        String[] palabras = frase.split("\\s+");
        StringBuilder traduccion = new StringBuilder();

        for (String palabra : palabras) {
            String buscada = palabra.toLowerCase();

            if (diccionario.containsKey(buscada)) {
                traduccion.append(diccionario.get(buscada));
            } else {
                traduccion.append("[???]");
            }

            traduccion.append(" ");
        }

        System.out.println("Traducción: " + traduccion.toString().trim());
    }
}
