import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        HashMap<String, String> diccionario = new HashMap<>();

        diccionario.put("hola", "hello");
        diccionario.put("casa", "house");
        diccionario.put("perro", "dog");
        diccionario.put("gato", "cat");
        diccionario.put("libro", "book");

        System.out.print("Ingrese una palabra: ");
        String palabra = teclado.nextLine().toLowerCase();

        if (diccionario.containsKey(palabra)) {
            System.out.println("Traducción: " + diccionario.get(palabra));
        } else {
            System.out.println(Colores.ROJO + "La palabra no existe." + Colores.RESET);
        }
    }
}
