import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio11 {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Nombre del producto: ");
        String producto = teclado.readLine();

        System.out.print("Cantidad comprada: ");
        int cantidad = Integer.parseInt(teclado.readLine());

        System.out.print("Precio unitario: ");
        double precio = Double.parseDouble(teclado.readLine().replace(",", "."));

        StringBuilder recibo = new StringBuilder();

        recibo.append("Producto: ").append(producto);
        recibo.append(" | Cantidad: ").append(cantidad);
        recibo.append(" | Precio unitario: $").append(precio);
        recibo.append(" | Total: $").append(cantidad * precio);

        System.out.println(recibo.toString());
    }
}
