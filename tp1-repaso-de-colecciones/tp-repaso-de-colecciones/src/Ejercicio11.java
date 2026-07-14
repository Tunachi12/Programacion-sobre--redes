import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();

        System.out.print("¿Cuántos números desea ingresar?: ");
        int cantidad = Integer.parseInt(teclado.nextLine());

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros.add(Integer.parseInt(teclado.nextLine()));
        }

        HashSet<Integer> sinRepetidos = new HashSet<>(numeros);

        System.out.println("Lista original: " + numeros);
        System.out.println("Lista sin repetidos: " + sinRepetidos);
    }
}
