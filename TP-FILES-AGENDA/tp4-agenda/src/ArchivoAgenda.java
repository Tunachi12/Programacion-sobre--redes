import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class ArchivoAgenda {
    private static final File ARCHIVO = new File("agenda.dat");
    private static final File TEMPORAL = new File("agenda.tmp");

    public static ArrayList<Contacto> cargarContactos() {
        ArrayList<Contacto> contactos = new ArrayList<>();

        if (!ARCHIVO.exists()) {
            return contactos;
        }

        try {
            BufferedReader lector = new BufferedReader(new FileReader(ARCHIVO));
            String linea;

            while ((linea = lector.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] datos = linea.split(";", 4);

                if (datos.length == 4) {
                    String nota = CifradoAES.desencriptar(datos[3]);

                    Contacto contacto = new Contacto(
                            datos[0],
                            datos[1],
                            datos[2],
                            nota
                    );

                    contactos.add(contacto);
                }
            }

            lector.close();

        } catch (Exception e) {
            System.out.println(
                    Colores.ROJO
                            + "\n\tNo se pudo cargar correctamente agenda.dat."
                            + Colores.RESET
            );
        }

        return contactos;
    }

    public static boolean guardarContactos(ArrayList<Contacto> contactos) {
        try {
            PrintWriter escritor = new PrintWriter(new FileWriter(TEMPORAL));

            for (Contacto contacto : contactos) {
                String notaCifrada = CifradoAES.encriptar(
                        contacto.getNotaPrivada()
                );

                escritor.println(
                        contacto.getNombre() + ";"
                                + contacto.getTelefono() + ";"
                                + contacto.getEmail() + ";"
                                + notaCifrada
                );
            }

            escritor.close();

            try {
                Files.move(
                        TEMPORAL.toPath(),
                        ARCHIVO.toPath(),
                        StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.ATOMIC_MOVE
                );

            } catch (AtomicMoveNotSupportedException e) {
                Files.move(
                        TEMPORAL.toPath(),
                        ARCHIVO.toPath(),
                        StandardCopyOption.REPLACE_EXISTING
                );
            }

            return true;

        } catch (Exception e) {
            System.out.println(
                    Colores.ROJO
                            + "\n\tNo se pudo guardar la agenda."
                            + Colores.RESET
            );

            try {
                Files.deleteIfExists(TEMPORAL.toPath());
            } catch (IOException ignored) {
            }

            return false;
        }
    }
}
