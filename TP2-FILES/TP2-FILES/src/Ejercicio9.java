import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println();
            System.out.println("1. Cargar clima");
            System.out.println("2. Mostrar datos");
            System.out.println("3. Borrar por fecha");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(teclado.nextLine());

            if (opcion == 1) {
                cargar(teclado);
            } else if (opcion == 2) {
                mostrar();
            } else if (opcion == 3) {
                borrar(teclado);
            }

        } while (opcion != 4);
    }

    public static void cargar(Scanner teclado) {
        try {
            BufferedWriter archivo = new BufferedWriter(
                    new FileWriter("clima.txt", true)
            );

            System.out.print("Fecha: ");
            String fecha = teclado.nextLine();

            System.out.print("Temperatura: ");
            String temperatura = teclado.nextLine();

            System.out.print("Humedad: ");
            String humedad = teclado.nextLine();

            archivo.write(fecha + ";" + temperatura + ";" + humedad);
            archivo.newLine();
            archivo.close();

        } catch (IOException e) {
            System.out.println("Error al guardar.");
        }
    }

    public static void mostrar() {
        try {
            BufferedReader archivo = new BufferedReader(
                    new FileReader("clima.txt")
            );

            String linea;

            while ((linea = archivo.readLine()) != null) {
                String[] datos = linea.split(";");

                System.out.println("Fecha: " + datos[0]);
                System.out.println("Temperatura: " + datos[1]);
                System.out.println("Humedad: " + datos[2]);
                System.out.println();
            }

            archivo.close();

        } catch (IOException e) {
            System.out.println("No hay datos.");
        }
    }

    public static void borrar(Scanner teclado) {
        ArrayList<String> registros = new ArrayList<>();

        System.out.print("Fecha a borrar: ");
        String fecha = teclado.nextLine();

        try {
            BufferedReader lector = new BufferedReader(
                    new FileReader("clima.txt")
            );

            String linea;

            while ((linea = lector.readLine()) != null) {
                if (!linea.startsWith(fecha + ";")) {
                    registros.add(linea);
                }
            }

            lector.close();

            BufferedWriter escritor = new BufferedWriter(
                    new FileWriter("clima.txt")
            );

            for (String registro : registros) {
                escritor.write(registro);
                escritor.newLine();
            }

            escritor.close();

        } catch (IOException e) {
            System.out.println("Error al borrar.");
        }
    }
}
