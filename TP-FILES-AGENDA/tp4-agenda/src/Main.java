public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        int opcion;

        do {
            mostrarMenu();
            opcion = Entrada.leerEntero(
                    Colores.BLANCO + "\tSeleccione una opción: " + Colores.RESET
            );

            switch (opcion) {
                case 1:
                    agenda.agregar();
                    break;

                case 2:
                    agenda.mostrar();
                    break;

                case 3:
                    agenda.editar();
                    break;

                case 4:
                    agenda.eliminar();
                    break;

                case 5:
                    System.out.println(
                            Colores.VERDE
                                    + "\n\tAgenda cerrada correctamente.\n"
                                    + Colores.RESET
                    );
                    break;

                default:
                    System.out.println(
                            Colores.ROJO
                                    + "\n\tOpción incorrecta."
                                    + Colores.RESET
                    );
            }

        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println(
                Colores.CYAN
                        + "╔══════════════════════════════════════╗"
                        + Colores.RESET
        );

        System.out.println(
                Colores.CYAN
                        + "║          AGENDA ENCRIPTADA           ║"
                        + Colores.RESET
        );

        System.out.println(
                Colores.CYAN
                        + "╠══════════════════════════════════════╣"
                        + Colores.RESET
        );

        System.out.println("\t" + Colores.AMARILLO + "1)" + Colores.RESET
                + " Agregar contacto");
        System.out.println("\t" + Colores.AMARILLO + "2)" + Colores.RESET
                + " Mostrar contactos");
        System.out.println("\t" + Colores.AMARILLO + "3)" + Colores.RESET
                + " Editar contacto");
        System.out.println("\t" + Colores.AMARILLO + "4)" + Colores.RESET
                + " Eliminar contacto");
        System.out.println("\t" + Colores.AMARILLO + "5)" + Colores.RESET
                + " Salir");

        System.out.println(
                Colores.CYAN
                        + "╚══════════════════════════════════════╝"
                        + Colores.RESET
        );
    }
}
