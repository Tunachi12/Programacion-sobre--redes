import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese el nombre " + (i + 1) + ": ");
            nombres.add(teclado.nextLine());
        }

        System.out.print("Nuevo valor para el tercer elemento: ");
        String nuevoNombre = teclado.nextLine();
        nombres.set(2, nuevoNombre);

        System.out.print("Nombre que desea eliminar: ");
        String eliminar = teclado.nextLine();
        nombres.remove(eliminar);

        System.out.println("Lista final: " + nombres);
    }
}
