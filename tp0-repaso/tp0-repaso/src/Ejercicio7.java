import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio7 {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese una contraseña: ");
        String contrasena = teclado.readLine();

        boolean longitudValida = contrasena.length() >= 8;
        boolean tieneNumero = false;
        boolean contieneClave = contrasena.toLowerCase().contains("clave");

        for (int i = 0; i < contrasena.length(); i++) {
            if (Character.isDigit(contrasena.charAt(i))) {
                tieneNumero = true;
                break;
            }
        }

        if (longitudValida && tieneNumero && !contieneClave) {
            System.out.println("La contraseña es segura.");
        } else {
            System.out.println("La contraseña es vulnerable.");
        }
    }
}
