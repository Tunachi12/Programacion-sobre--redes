import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<>();
        HashMap<String, Integer> notas = new HashMap<>();

        int opcion;

        do {
            System.out.println();
            System.out.println(Colores.CYAN + "===== SISTEMA DE ALUMNOS =====" + Colores.RESET);
            System.out.println("1. Agregar alumno");
            System.out.println("2. Mostrar todos");
            System.out.println("3. Buscar alumno");
            System.out.println("4. Modificar nota");
            System.out.println("5. Mostrar promedio");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Nota: ");
                    int nota = Integer.parseInt(teclado.nextLine());

                    if (!nombres.contains(nombre)) {
                        nombres.add(nombre);
                    }

                    notas.put(nombre, nota);

                    System.out.println(Colores.VERDE + "Alumno agregado." + Colores.RESET);
                    break;

                case 2:
                    if (nombres.isEmpty()) {
                        System.out.println(Colores.ROJO + "No hay alumnos." + Colores.RESET);
                    } else {
                        for (String alumno : nombres) {
                            int notaAlumno = notas.get(alumno);
                            String estado = notaAlumno >= 6
                                    ? Colores.VERDE + "Aprobado"
                                    : Colores.ROJO + "Desaprobado";

                            System.out.println(
                                    alumno + " - Nota: " + notaAlumno
                                            + " - " + estado + Colores.RESET
                            );
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nombre a buscar: ");
                    String buscado = teclado.nextLine();

                    if (notas.containsKey(buscado)) {
                        System.out.println(
                                Colores.VERDE
                                        + buscado
                                        + " tiene nota "
                                        + notas.get(buscado)
                                        + Colores.RESET
                        );
                    } else {
                        System.out.println(
                                Colores.ROJO + "Alumno no encontrado." + Colores.RESET
                        );
                    }
                    break;

                case 4:
                    System.out.print("Nombre del alumno: ");
                    String alumnoModificar = teclado.nextLine();

                    if (notas.containsKey(alumnoModificar)) {
                        System.out.print("Nueva nota: ");
                        int nuevaNota = Integer.parseInt(teclado.nextLine());
                        notas.put(alumnoModificar, nuevaNota);

                        System.out.println(
                                Colores.VERDE + "Nota modificada." + Colores.RESET
                        );
                    } else {
                        System.out.println(
                                Colores.ROJO + "Alumno no encontrado." + Colores.RESET
                        );
                    }
                    break;

                case 5:
                    if (notas.isEmpty()) {
                        System.out.println(Colores.ROJO + "No hay notas." + Colores.RESET);
                    } else {
                        int suma = 0;

                        for (Map.Entry<String, Integer> entrada : notas.entrySet()) {
                            suma += entrada.getValue();
                        }

                        double promedio = (double) suma / notas.size();

                        System.out.println(
                                Colores.AMARILLO
                                        + "Promedio general: "
                                        + promedio
                                        + Colores.RESET
                        );
                    }
                    break;

                case 6:
                    System.out.println(Colores.CYAN + "Programa finalizado." + Colores.RESET);
                    break;

                default:
                    System.out.println(Colores.ROJO + "Opción inválida." + Colores.RESET);
            }

        } while (opcion != 6);
    }
}
