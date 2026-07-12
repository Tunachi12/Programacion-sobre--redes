import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio6 {

    public static boolean esPrimo(int numero) {
        if (numero < 2) {
            return false;
        }

        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String rutaNumeros = System.getProperty("user.home")
                + File.separator + "Documents"
                + File.separator + "NumerosTP"
                + File.separator + "números.txt";

        String carpetaPrimos = System.getProperty("user.home")
                + File.separator + "Documents"
                + File.separator + "PrimosTP";

        File directorio = new File(carpetaPrimos);
        directorio.mkdirs();

        File archivoPrimos = new File(directorio, "primos.dat");

        try {
            BufferedReader lector = new BufferedReader(
                    new FileReader(rutaNumeros)
            );

            BufferedWriter escritor = new BufferedWriter(
                    new FileWriter(archivoPrimos)
            );

            String linea;

            while ((linea = lector.readLine()) != null) {
                int numero = Integer.parseInt(linea);

                if (esPrimo(numero)) {
                    escritor.write(linea);
                    escritor.newLine();
                }
            }

            lector.close();
            escritor.close();

            System.out.println("Archivo creado en: " + archivoPrimos.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error al crear el archivo de primos.");
        }
    }
}
