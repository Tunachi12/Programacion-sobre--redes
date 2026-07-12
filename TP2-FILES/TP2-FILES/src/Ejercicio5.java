import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio5 {
    public static void main(String[] args) {
        String ruta = System.getProperty("user.home")
                + File.separator + "Documents"
                + File.separator + "NumerosTP"
                + File.separator + "números.txt";

        ArrayList<String> numeros = new ArrayList<>();

        try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            String linea;

            while ((linea = lector.readLine()) != null) {
                int numero = Integer.parseInt(linea);

                if (numero % 3 != 0) {
                    numeros.add(linea);
                }
            }

            lector.close();

            BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta));

            for (String numero : numeros) {
                escritor.write(numero);
                escritor.newLine();
            }

            escritor.close();
            System.out.println("Se eliminaron los múltiplos de 3.");

        } catch (IOException e) {
            System.out.println("Error al modificar el archivo.");
        }
    }
}
