import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try {
            BufferedWriter archivo = new BufferedWriter(
                    new FileWriter("numerosIngresados.txt")
            );

            System.out.println("Ingrese datos. Escriba fin para terminar.");

            while (true) {
                System.out.print("Dato: ");
                String dato = teclado.nextLine();

                if (dato.equalsIgnoreCase("fin")) {
                    break;
                }

                try {
                    Double.parseDouble(dato.replace(",", "."));
                    archivo.write(dato);
                    archivo.newLine();
                } catch (NumberFormatException e) {
                    System.out.println("No es un número.");
                }
            }

            archivo.close();

        } catch (IOException e) {
            System.out.println("Error al crear el archivo.");
        }
    }
}
