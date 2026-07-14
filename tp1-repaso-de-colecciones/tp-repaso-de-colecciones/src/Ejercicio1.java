import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese el nombre " + (i + 1) + ": ");
            nombres.add(teclado.nextLine());
        }

        System.out.println("Lista completa: " + nombres);
        System.out.println("Cantidad de elementos: " + nombres.size());
        System.out.println("Primer elemento: " + nombres.get(0));
        System.out.println("Último elemento: " + nombres.get(nombres.size() - 1));

        System.out.println("Nombres en mayúsculas:");

        for (String nombre : nombres) {
            System.out.println(nombre.toUpperCase());
        }
    }
}
