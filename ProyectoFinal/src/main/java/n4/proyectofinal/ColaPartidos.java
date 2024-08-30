package n4.proyectofinal;

import javax.swing.JOptionPane;

public class ColaPartidos {

    private NodoPartido cabeza;
    private NodoPartido cola;

    public ColaPartidos() { // constructor de la clase, establecidas en null para el comienzo
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarPartido(Partido partido) { // contiene el partido para agregar a la cola de partidos
        NodoPartido nuevoNodo = new NodoPartido(partido);
        if (cola == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else { // si acaso ya hay partidos en la cola
            cola.siguiente = nuevoNodo; //el nodo 2(digamos) se queda apunntando al nodo 1 (que estaba alli primero)
            cola = nuevoNodo;//ahora el nuevo partido(2) está atrás del primero(1), tal como en la CCSS
        }
    }

    public Partido siguientePartido() { // extrae cada partido
        if (cabeza == null) {
            return null;
        }
        Partido partido = cabeza.partido; //partido(minuscula) es un objeto de tipo Partido
        //AL QUE CABEZA ESTÁ apuntando es al frente
        cabeza = cabeza.siguiente; // ahora la cabeza es el partido que le seguía al primero de la cola, osea la jupa
        if (cabeza == null) { // osea que si no hay niguna cabeza
            cola = null; // tampoco hay cola
        }
        return partido; // el partido ya extraido se devuelve
    }

    public void listarPartidos(Evento evento) {
        NodoPartido actual = cabeza;
        StringBuilder sb = new StringBuilder();

        if (actual == null) {
            JOptionPane.showMessageDialog(null, "No hay partidos en la cola.", "Lista de Partidos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        while (actual != null) {
            sb.append("Código de partido: ")
                    .append(actual.partido.getCodigoPartido())
                    .append("\n")
                    .append(" - Información: ")
                    .append("\n")
                    .append(actual.partido.getNombreEquipoA() + " (Equipo A)")
                    .append(" vs ")
                    .append(actual.partido.getNombreEquipoB() + " (Equipo B)")
                    .append("\n")
                    .append(" - Fecha: ")
                    .append("\n")
                    .append(actual.partido.getFecha())
                    .append("\n")
                    .append(" - Resultado de parido: ")
                    //.append(actual.partido.getResultadoEquipoA()+actual.partido.getNombreEquipoA())
                    .append("\n")
                    .append(actual.partido.getNombreEquipoA() + ": " + actual.partido.getResultadoEquipoA())
                    .append("\n")
                    .append(actual.partido.getNombreEquipoB() + ": " + actual.partido.getResultadoEquipoB())// Añadir el resultado del partido
                    .append("\n")
                    .append(" - Integrantes del evento para los equipos A o B:\n")
                    .append(evento.obtenerListaParticipantes()) // Agrega la lista de participantes
                    .append("------------------------------------------")
                    .append("\n");

            actual = actual.siguiente;
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Partidos", JOptionPane.INFORMATION_MESSAGE);
    }

    public Partido buscarPartido(String codigoPartido) {// POR CODIGO LO BUSCA
        NodoPartido actual = cabeza;
        while (actual != null) {
            Partido partido = actual.partido;
            if (partido.getCodigoPartido().equalsIgnoreCase(codigoPartido)) {
                return partido;
            }
            actual = actual.siguiente;
        }
        return null; // Si no se encuentra el partido
    }

    // Nuevo método para eliminar un partido específico pero por código
    public boolean eliminarPartido(String codigoPartido) {
        if (cabeza == null) {
            return false; // La cola está vacía
        }

        // Si el partido a eliminar está en la cabeza
        if (cabeza.partido.getCodigoPartido().equalsIgnoreCase(codigoPartido)) {
            cabeza = cabeza.siguiente;
            if (cabeza == null) {
                cola = null; // La cola ahora está vacía
            }
            return true; // Partido eliminado
        }

        // Para otros casos, recorremos la cola
        NodoPartido actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.partido.getCodigoPartido().equalsIgnoreCase(codigoPartido)) {
                actual.siguiente = actual.siguiente.siguiente;
                if (actual.siguiente == null) {
                    cola = actual; // Si eliminamos el último nodo
                }
                return true; // Partido eliminado
            }
            actual = actual.siguiente;
        }

        return false; // Si no se encuentra el partido
    }

    public NodoPartido getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoPartido cabeza) {
        this.cabeza = cabeza;
    }

    public NodoPartido getCola() {
        return cola;
    }

    // agarra un partido ya nodeado,
    public void setCola(NodoPartido cola) {
        this.cola = cola;
    }
}

/*
package n4.proyectofinal;

import javax.swing.JOptionPane;

public class ColaPartidos {

    private NodoPartido cabeza;
    private NodoPartido cola;

    public ColaPartidos() { // constructor de la clase, establecidas en null para el comienzo
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarPartido(Partido partido) { // contiene el partido para agregar a la cola de partidos
        NodoPartido nuevoNodo = new NodoPartido(partido);
        if (cola == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else { // si acaso ya hay partidos en la cola
            cola.siguiente = nuevoNodo; //el nodo 2(digamos) se queda apunntando al nodo 1 (que estaba alli primero)
            cola = nuevoNodo;//ahora el nuevo partido(2) está atrás del primero(1), tal como en la CCSS
        }
    }

    public Partido siguientePartido() { // extrae cada partido
        if (cabeza == null) {
            return null;
        }
        Partido partido = cabeza.partido; //partido(minuscula) es un objeto de tipo Partido
        //AL QUE CABEZA ESTÁ apuntando es al frente
        cabeza = cabeza.siguiente; // ahora la cabeza es el partido que le seguía al primero de la cola, osea la jupa
        if (cabeza == null) { // osea que si no hay niguna cabeza
            cola = null; // tampoco hay cola
        }
        return partido; // el partido ya extraido se devuelve
    }

    /*
    public void listarPartidos() { // ahoora con joption paen
        NodoPartido actual = cabeza;
        StringBuilder sb = new StringBuilder();
        
        
        if (actual == null) {
            JOptionPane.showMessageDialog(null, "no hay partidos en la cola.", "Lista de Partidos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }


        while (actual != null) {
            sb.append(("Codigo de partido:"))
                    .append(actual.partido.getCodigoPartido())
                    .append("\n")
                    .append("Información:")
                    .append(actual.partido.getNombreEquipoB())
                    .append(" vs ")
                    .append(actual.partido.getNombreEquipoB())
                    .append(" - ")
                    .append(actual.partido.getFecha())
                    .append(" - Resultado: ")
                    .append(actual.partido.getResultado()) // Añadir el resultado del partido
                    .append("\n")
                    .append("Integrantes del evento para los equipos A o B:");
            

            actual = actual.siguiente;
        }
         
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Partidos", JOptionPane.INFORMATION_MESSAGE);

    }
     

    public void listarPartidos(Evento evento) { // Añadimos el evento como parámetro
        NodoPartido actual = cabeza;
        StringBuilder sb = new StringBuilder();

        if (actual == null) {
            JOptionPane.showMessageDialog(null, "No hay partidos en la cola.", "Lista de Partidos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        while (actual != null) {
            sb.append("Código de partido: ")
                    .append(actual.partido.getCodigoPartido())
                    .append("\n")
                    .append("Información: ")
                    .append(actual.partido.getNombreEquipoA())
                    .append(" vs ")
                    .append(actual.partido.getNombreEquipoB())
                    .append(" - ")
                    .append(actual.partido.getFecha())
                    .append(" - Resultado: ")
                    .append(actual.partido.getResultado()) // Añadir el resultado del partido
                    .append("\n")
                    .append("Integrantes del evento para los equipos A o B:\n")
                    .append(evento.obtenerListaParticipantes()) // Agrega la lista de participantes
                    .append("\n");

            actual = actual.siguiente;
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Partidos", JOptionPane.INFORMATION_MESSAGE);
    }

    public Partido buscarPartido(String codigoPartido) {// POR CODIGO LO BUSCA
        NodoPartido actual = cabeza;
        while (actual != null) {
            Partido partido = actual.partido;
            if (partido.getCodigoPartido().equalsIgnoreCase(codigoPartido)) {
                return partido;
            }
            actual = actual.siguiente;
        }
        return null; // Si no se encuentra el partido
    }

    // Nuevo método para eliminar un partido específico pero por código
    public boolean eliminarPartido(String codigoPartido) {
        if (cabeza == null) {
            return false; // La cola está vacía
        }

        // Si el partido a eliminar está en la cabeza
        if (cabeza.partido.getCodigoPartido().equalsIgnoreCase(codigoPartido)) {
            cabeza = cabeza.siguiente;
            if (cabeza == null) {
                cola = null; // La cola ahora está vacía
            }
            return true; // Partido eliminado
        }

        // Para otros casos, recorremos la cola
        NodoPartido actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.partido.getCodigoPartido().equalsIgnoreCase(codigoPartido)) {
                actual.siguiente = actual.siguiente.siguiente;
                if (actual.siguiente == null) {
                    cola = actual; // Si eliminamos el último nodo
                }
                return true; // Partido eliminado
            }
            actual = actual.siguiente;
        }

        return false; // Si no se encuentra el partido
    }

    public NodoPartido getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoPartido cabeza) {
        this.cabeza = cabeza;
    }

    public NodoPartido getCola() {
        return cola;
    }

    // agarra un partido ya nodeado,
    public void setCola(NodoPartido cola) {
        this.cola = cola;
    }
}
*/