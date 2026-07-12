import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio4 {
    public static void main(String[] args) {
        String ruta = System.getProperty("user.home")
                + File.separator + "Documents"
                + File.separator + "NumerosTP"
                + File.separator + "números.txt";

        try {
            BufferedReader archivo = new BufferedReader(new FileReader(ruta));
            String linea;

            while ((linea = archivo.readLine()) != null) {
                System.out.println(linea);
            }

            archivo.close();

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo.");
        }
    }
}
