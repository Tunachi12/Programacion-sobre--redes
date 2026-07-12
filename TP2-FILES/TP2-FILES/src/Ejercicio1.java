import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String dato;

        System.out.println("Escriba datos. Escriba fin para terminar.");

        while (true) {
            System.out.print("Dato: ");
            dato = teclado.nextLine();

            if (dato.equalsIgnoreCase("fin")) {
                break;
            }

            try {
                FileWriter archivo = new FileWriter("ultimoDato.txt");
                archivo.write(dato);
                archivo.close();
            } catch (IOException e) {
                System.out.println("Error al guardar el dato.");
            }
        }
    }
}
