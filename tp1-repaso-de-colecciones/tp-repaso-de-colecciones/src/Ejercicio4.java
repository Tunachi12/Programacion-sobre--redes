import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio4 {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();

        nombres.add("Ana");
        nombres.add("Bruno");
        nombres.add("Carla");
        nombres.add("Diego");
        nombres.add("Elena");

        String[] colores = {
                Colores.ROJO,
                Colores.VERDE,
                Colores.AMARILLO,
                Colores.AZUL,
                Colores.VIOLETA
        };

        System.out.println("FOR CLÁSICO:");

        for (int i = 0; i < nombres.size(); i++) {
            System.out.println(colores[i % colores.length] + nombres.get(i) + Colores.RESET);
        }

        System.out.println("\nFOR-EACH:");

        int posicionColor = 0;

        for (String nombre : nombres) {
            System.out.println(colores[posicionColor % colores.length] + nombre + Colores.RESET);
            posicionColor++;
        }

        System.out.println("\nITERATOR:");

        Iterator<String> iterador = nombres.iterator();
        posicionColor = 0;

        while (iterador.hasNext()) {
            System.out.println(
                    colores[posicionColor % colores.length]
                            + iterador.next()
                            + Colores.RESET
            );
            posicionColor++;
        }
    }
}
