import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Entrada {
    private static final BufferedReader TECLADO =
            new BufferedReader(new InputStreamReader(System.in));

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);

        try {
            return TECLADO.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    public static String leerObligatorio(String mensaje) {
        String texto;

        do {
            texto = leerTexto(mensaje).trim();

            if (texto.isEmpty()) {
                System.out.println(
                        Colores.ROJO + "\tEl campo no puede quedar vacío." + Colores.RESET
                );
            }

            if (texto.contains(";")) {
                System.out.println(
                        Colores.ROJO + "\tNo se permite utilizar punto y coma." + Colores.RESET
                );
                texto = "";
            }

        } while (texto.isEmpty());

        return texto;
    }

    public static int leerEntero(String mensaje) {
        while (true) {
            String dato = leerTexto(mensaje).trim();

            try {
                return Integer.parseInt(dato);
            } catch (NumberFormatException e) {
                System.out.println(
                        Colores.ROJO + "\tIngrese un número entero válido." + Colores.RESET
                );
            }
        }
    }
}
