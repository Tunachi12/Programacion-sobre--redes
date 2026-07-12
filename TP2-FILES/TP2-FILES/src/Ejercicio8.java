import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio8 {
    public static void main(String[] args) {
        Path archivo = Path.of("pagina.html");

        try {
            String contenido = Files.readString(archivo);

            contenido = contenido.replace(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    ""
            );

            Files.writeString(archivo, contenido);

            System.out.println("Se eliminó el Lorem.");

        } catch (IOException e) {
            System.out.println("Error al modificar el HTML.");
        }
    }
}
