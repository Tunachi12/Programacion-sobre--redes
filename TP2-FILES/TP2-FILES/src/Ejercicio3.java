import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[] args) {
        String carpeta = System.getProperty("user.home")
                + File.separator + "Documents"
                + File.separator + "NumerosTP";

        File directorio = new File(carpeta);
        directorio.mkdirs();

        File archivoNumeros = new File(directorio, "números.txt");

        try {
            BufferedWriter archivo = new BufferedWriter(
                    new FileWriter(archivoNumeros)
            );

            for (int i = 0; i <= 1000; i += 2) {
                archivo.write(String.valueOf(i));
                archivo.newLine();
            }

            archivo.close();
            System.out.println("Archivo creado en: " + archivoNumeros.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error al crear el archivo.");
        }
    }
}
