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

    public static String leerTextoObligatorio(String mensaje) {
        String texto;

        do {
            texto = leerTexto(mensaje).trim();

            if (texto.isEmpty()) {
                System.out.println(Colores.ROJO + "\tEl campo no puede quedar vacío."
                        + Colores.RESET);
            }

            if (texto.contains(";")) {
                System.out.println(Colores.ROJO
                        + "\tNo se permite utilizar punto y coma."
                        + Colores.RESET);
                texto = "";
            }

        } while (texto.isEmpty());

        return texto;
    }

    public static String tipoDeNumero(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return "NO_NUMERICO";
        }

        texto = texto.trim().replace(",", ".");

        try {
            Integer.parseInt(texto);
            return "ENTERO";
        } catch (NumberFormatException e) {
            try {
                Float.parseFloat(texto);
                return "DECIMAL";
            } catch (NumberFormatException ex) {
                return "NO_NUMERICO";
            }
        }
    }

    public static int convertirAEntero(String texto) {
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static float convertirAFloat(String texto) {
        try {
            return Float.parseFloat(texto.trim().replace(",", "."));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int leerEnteroPositivo(String mensaje) {
        while (true) {
            String dato = leerTexto(mensaje);
            String tipo = tipoDeNumero(dato);

            if (tipo.equals("ENTERO")) {
                int numero = convertirAEntero(dato);

                if (numero >= 0) {
                    return numero;
                }
            }

            System.out.println(Colores.ROJO
                    + "\tIngrese un número entero igual o mayor que cero."
                    + Colores.RESET);
        }
    }

    public static float leerPrecio(String mensaje) {
        while (true) {
            String dato = leerTexto(mensaje);
            String tipo = tipoDeNumero(dato);

            if (tipo.equals("ENTERO") || tipo.equals("DECIMAL")) {
                float numero = convertirAFloat(dato);

                if (numero >= 0) {
                    return numero;
                }
            }

            System.out.println(Colores.ROJO
                    + "\tIngrese un número válido igual o mayor que cero."
                    + Colores.RESET);
        }
    }
}
