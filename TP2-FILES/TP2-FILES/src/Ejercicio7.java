import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String carpeta = System.getProperty("user.home")
                + File.separator + "Documents"
                + File.separator + "CaracteresTP";

        File directorio = new File(carpeta);
        directorio.mkdirs();

        File caracteres = new File(directorio, "caracteres.dat");

        try {
            BufferedWriter escritor = new BufferedWriter(
                    new FileWriter(caracteres)
            );

            for (int i = 1; i <= 10; i++) {
                String palabra;

                do {
                    System.out.print("Palabra " + i + " con ñ: ");
                    palabra = teclado.nextLine();
                } while (!palabra.toLowerCase().contains("ñ"));

                escritor.write(palabra);
                escritor.newLine();
            }

            escritor.close();

            ArrayList<String> palabras = new ArrayList<>();
            BufferedReader lector = new BufferedReader(
                    new FileReader(caracteres)
            );

            String linea;

            System.out.println("Fichero original:");

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
                palabras.add(linea);
            }

            lector.close();

            escritor = new BufferedWriter(new FileWriter(caracteres));

            for (String palabra : palabras) {
                escritor.write(
                        palabra.replace("ñ", "nie-nio")
                                .replace("Ñ", "NIE-NIO")
                );
                escritor.newLine();
            }

            escritor.close();

            lector = new BufferedReader(new FileReader(caracteres));

            System.out.println("Fichero arreglado:");

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            lector.close();

        } catch (IOException e) {
            System.out.println("Error al trabajar con el archivo.");
        }
    }
}
