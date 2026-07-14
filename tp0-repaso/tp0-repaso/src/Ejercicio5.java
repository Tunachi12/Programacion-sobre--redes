import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio5 {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese su correo electrónico: ");
        String correo = teclado.readLine();

        int posicionArroba = correo.indexOf("@");

        if (posicionArroba > 0) {
            String usuario = correo.substring(0, posicionArroba).toLowerCase();
            usuario = usuario.substring(0, 1).toUpperCase() + usuario.substring(1);

            System.out.println("Bienvenido/a, " + usuario + ".");
        } else {
            System.out.println("Correo inválido.");
        }
    }
}
