import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese un párrafo: ");
        String parrafo = teclado.readLine();

        System.out.print("Palabra a buscar: ");
        String buscar = teclado.readLine();

        System.out.print("Palabra de reemplazo: ");
        String reemplazo = teclado.readLine();

        String resultado = parrafo.replace(buscar, reemplazo);

        System.out.println("Resultado: " + resultado);
    }
}
