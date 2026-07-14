import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio9 {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese una palabra o frase: ");
        String texto = teclado.readLine();

        StringBuilder resultado = new StringBuilder();
        boolean mayuscula = true;

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            if (Character.isLetter(caracter)) {
                if (mayuscula) {
                    resultado.append(Character.toUpperCase(caracter));
                } else {
                    resultado.append(Character.toLowerCase(caracter));
                }

                mayuscula = !mayuscula;
            } else {
                resultado.append(caracter);
            }
        }

        System.out.println("Resultado: " + resultado);
    }
}
