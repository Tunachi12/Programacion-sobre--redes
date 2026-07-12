public class Main {
    public static void main(String[] args) {
        ArchivoInventario.crearArchivo();

        int opcion;

        do {
            mostrarMenu();
            opcion = Entrada.leerEnteroPositivo(
                    Colores.BLANCO + "\tSeleccione una opción: " + Colores.RESET
            );

            switch (opcion) {
                case 1:
                    Inventario.agregarProducto();
                    break;

                case 2:
                    Inventario.mostrarProductos();
                    break;

                case 3:
                    Inventario.editarProducto();
                    break;

                case 4:
                    Inventario.eliminarProducto();
                    break;

                case 5:
                    System.out.println(
                            Colores.VERDE
                                    + "\n\tPrograma finalizado.\n"
                                    + Colores.RESET
                    );
                    break;

                default:
                    System.out.println(
                            Colores.ROJO
                                    + "\n\tLa opción ingresada no existe."
                                    + Colores.RESET
                    );
                    Entrada.leerTexto(
                            "\tPresione ENTER para continuar..."
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
                        + "║       ADMINISTRADOR DE STOCK         ║"
                        + Colores.RESET
        );

        System.out.println(
                Colores.CYAN
                        + "╠══════════════════════════════════════╣"
                        + Colores.RESET
        );

        System.out.println("\t" + Colores.AMARILLO + "1)" + Colores.RESET
                + " Agregar producto");
        System.out.println("\t" + Colores.AMARILLO + "2)" + Colores.RESET
                + " Mostrar inventario");
        System.out.println("\t" + Colores.AMARILLO + "3)" + Colores.RESET
                + " Editar producto");
        System.out.println("\t" + Colores.AMARILLO + "4)" + Colores.RESET
                + " Eliminar producto");
        System.out.println("\t" + Colores.AMARILLO + "5)" + Colores.RESET
                + " Salir");

        System.out.println(
                Colores.CYAN
                        + "╚══════════════════════════════════════╝"
                        + Colores.RESET
        );
    }
}
