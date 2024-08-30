package n4.proyectofinal;

import javax.swing.JOptionPane;

public class ListaEventos {

    private NodoEvento cabeza;

    public ListaEventos() {
        this.cabeza = null;
    }

    public void agregarEvento(Evento evento) {
        NodoEvento nuevoNodo = new NodoEvento(evento);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoEvento actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public void eliminarEvento(String nombre) {
        NodoEvento actual = cabeza;
        NodoEvento anterior = null;
        while (actual != null) {
            if (actual.evento.getNombre().equals(nombre)) {
                if (anterior != null) {
                    anterior.siguiente = actual.siguiente;
                } else {
                    cabeza = actual.siguiente;
                }
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }

    public void listarEventos() {
        NodoEvento actual = cabeza;
        if (actual == null) {
            JOptionPane.showMessageDialog(null, "No hay eventos para mostrar.");
            return;
        }

        StringBuilder listaEventos = new StringBuilder();
        while (actual != null) {
            listaEventos.append("Nombre: ").append(actual.evento.getNombre())
                    .append(" - Fecha: ").append(actual.evento.getFecha())
                    .append(" - Ubicación: ").append(actual.evento.getUbicacion())
                    .append("\n");
            actual = actual.siguiente;
        }

        JOptionPane.showMessageDialog(null, listaEventos.toString(), "Lista de Eventos", JOptionPane.INFORMATION_MESSAGE);
    }

    public Evento buscarEventoPorNombre(String nombre) {
        NodoEvento actual = cabeza;
        while (actual != null) {
            if (actual.evento.getNombre().equalsIgnoreCase(nombre)) {
                return actual.evento;
            }
            actual = actual.siguiente;
        }
        return null; // Retorna null si no se encuentra el evento
    }
}
