import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese el nombre " + (i + 1) + ": ");
            nombres.add(teclado.nextLine());
        }

        System.out.print("Ingrese el nombre a buscar: ");
        String buscado = teclado.nextLine();

        if (nombres.contains(buscado)) {
            System.out.println(Colores.VERDE + "El nombre existe." + Colores.RESET);
            System.out.println("Posición: " + nombres.indexOf(buscado));
        } else {
            System.out.println(Colores.ROJO + "El nombre no existe." + Colores.RESET);
        }
    }
}
