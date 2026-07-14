import java.util.ArrayList;

public class Agenda {
    private final ArrayList<Contacto> contactos;

    public Agenda() {
        contactos = ArchivoAgenda.cargarContactos();
    }

    public void agregar() {
        titulo("AGREGAR CONTACTO");

        String nombre = Entrada.leerObligatorio("\tNombre: ");
        String telefono = Entrada.leerObligatorio("\tTeléfono: ");
        String email = Entrada.leerObligatorio("\tEmail: ");
        String nota = Entrada.leerObligatorio("\tNota privada: ");

        if (buscarPosicion(nombre) != -1) {
            mensajeError("Ya existe un contacto con ese nombre.");
            pausar();
            return;
        }

        contactos.add(new Contacto(nombre, telefono, email, nota));

        if (ArchivoAgenda.guardarContactos(contactos)) {
            mensajeExito("Contacto agregado correctamente.");
        }

        pausar();
    }

    public void mostrar() {
        titulo("LISTA DE CONTACTOS");

        if (contactos.isEmpty()) {
            mensajeAlerta("La agenda está vacía.");
            pausar();
            return;
        }

        System.out.printf(
                Colores.CYAN + "%-4s %-20s %-16s %-28s %-30s%n" + Colores.RESET,
                "N°", "NOMBRE", "TELÉFONO", "EMAIL", "NOTA PRIVADA"
        );

        System.out.println(
                Colores.AZUL
                        + "----------------------------------------------------------------------------------------------------"
                        + Colores.RESET
        );

        for (int i = 0; i < contactos.size(); i++) {
            Contacto contacto = contactos.get(i);

            System.out.printf(
                    "%-4d %-20s %-16s %-28s %-30s%n",
                    i + 1,
                    contacto.getNombre(),
                    contacto.getTelefono(),
                    contacto.getEmail(),
                    contacto.getNotaPrivada()
            );
        }

        pausar();
    }

    public void editar() {
        titulo("EDITAR CONTACTO");

        if (contactos.isEmpty()) {
            mensajeAlerta("No hay contactos para editar.");
            pausar();
            return;
        }

        String buscado = Entrada.leerObligatorio("\tNombre del contacto: ");
        int posicion = buscarPosicion(buscado);

        if (posicion == -1) {
            mensajeError("Contacto no encontrado.");
            pausar();
            return;
        }

        Contacto contacto = contactos.get(posicion);

        System.out.println(
                Colores.AMARILLO
                        + "\n\tIngrese los nuevos datos:"
                        + Colores.RESET
        );

        String nombre = Entrada.leerObligatorio("\tNombre: ");
        String telefono = Entrada.leerObligatorio("\tTeléfono: ");
        String email = Entrada.leerObligatorio("\tEmail: ");
        String nota = Entrada.leerObligatorio("\tNota privada: ");

        contacto.setNombre(nombre);
        contacto.setTelefono(telefono);
        contacto.setEmail(email);
        contacto.setNotaPrivada(nota);

        if (ArchivoAgenda.guardarContactos(contactos)) {
            mensajeExito("Contacto editado correctamente.");
        }

        pausar();
    }

    public void eliminar() {
        titulo("ELIMINAR CONTACTO");

        if (contactos.isEmpty()) {
            mensajeAlerta("No hay contactos para eliminar.");
            pausar();
            return;
        }

        String buscado = Entrada.leerObligatorio("\tNombre del contacto: ");
        int posicion = buscarPosicion(buscado);

        if (posicion == -1) {
            mensajeError("Contacto no encontrado.");
            pausar();
            return;
        }

        Contacto contacto = contactos.get(posicion);

        System.out.println(
                Colores.AMARILLO
                        + "\n\tSe eliminará: "
                        + contacto.getNombre()
                        + Colores.RESET
        );

        String confirmar = Entrada.leerTexto("\t¿Confirmar? (S/N): ");

        if (confirmar.equalsIgnoreCase("S")) {
            contactos.remove(posicion);

            if (ArchivoAgenda.guardarContactos(contactos)) {
                mensajeExito("Contacto eliminado.");
            }

        } else {
            mensajeAlerta("Operación cancelada.");
        }

        pausar();
    }

    private int buscarPosicion(String nombre) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }

        return -1;
    }

    private void titulo(String texto) {
        System.out.println();
        System.out.println(
                Colores.AZUL
                        + "╔════════════════════════════════════════════════════╗"
                        + Colores.RESET
        );

        System.out.printf(
                Colores.AZUL + "║ %-50s ║%n" + Colores.RESET,
                texto
        );

        System.out.println(
                Colores.AZUL
                        + "╚════════════════════════════════════════════════════╝"
                        + Colores.RESET
        );
    }

    private void mensajeExito(String texto) {
        System.out.println(
                Colores.VERDE + "\n\t✔ " + texto + Colores.RESET
        );
    }

    private void mensajeError(String texto) {
        System.out.println(
                Colores.ROJO + "\n\t✘ " + texto + Colores.RESET
        );
    }

    private void mensajeAlerta(String texto) {
        System.out.println(
                Colores.AMARILLO + "\n\t⚠ " + texto + Colores.RESET
        );
    }

    private void pausar() {
        Entrada.leerTexto(
                Colores.VIOLETA
                        + "\n\tPresione ENTER para continuar..."
                        + Colores.RESET
        );
    }
}
