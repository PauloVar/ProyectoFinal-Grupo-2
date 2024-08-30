package n4.proyectofinal;

import javax.swing.JOptionPane;

public class Evento {

    private String nombre;
    private String fecha;
    private String ubicacion;
    private NodoParticipante cabezaParticipante; // Lista doblemente enlazada para participantes, esto solo es la cabeza
    private ColaPartidos colaPartidos; // Cola personalizada para partidos
    private PilaResultados pilaResultados; // Pila para los resultados 
    private Clasificacion clasificacion; // para el arbol de clasificacion

    public Evento(String nombre, String fecha, String ubicacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.cabezaParticipante = null;
        this.colaPartidos = new ColaPartidos(); // Inicializar la cola de partidos
        this.pilaResultados = new PilaResultados();
        this.clasificacion = new Clasificacion();
    }

    // Métodos para gestionar participantes en una lista doblemente enlazada
    public void agregarParticipante(Participante participante) {
        NodoParticipante nuevoNodo = new NodoParticipante(participante); // nuevo participante, representado como nuevoNodo
        if (cabezaParticipante == null) {
            cabezaParticipante = nuevoNodo; //si no hay cabeza
        } else {
            NodoParticipante actual = cabezaParticipante; //agarra la cabeza, LA CABEZA NO CAMBIA, va a ser la misma
            while (actual.siguiente != null) { //recorre la lista hasta el útimo nodo
                actual = actual.siguiente; // osea agarra al que sigue
            }
            actual.siguiente = nuevoNodo; //cuando por fin se llega al ultimo nodo
            nuevoNodo.anterior = actual; // el nuevo nodo SE PONE AL FINAL DE LA LISTA
        }
    }

    public void eliminarParticipante(String nombre) {
        NodoParticipante actual = cabezaParticipante; // Agarra el primer nodo de la lista

        while (actual != null) { // Recorre la lista hasta llegar al final
            if (actual.participante.getNombre().equals(nombre)) { // Si encuentra el participante
                if (actual.anterior != null) {
                    // Si el nodo a eliminar no es la cabeza (primer nodo)
                    //ACTUAL es el nodo a eliminar, aqui le estamos diciendo al de atras de actual que apunte al de adelante de actual
                    actual.anterior.siguiente = actual.siguiente;
                } else {// Si el nodo a eliminar es la cabeza osea que el nodo anterior es nulo
                    /*
            Nodo A <-> Nodo B <-> Nodo C

            Nodo A (anterior = null, siguiente = Nodo B)
            Nodo B (anterior = Nodo A, siguiente = Nodo C)
            Nodo C (anterior = Nodo B, siguiente = null)
                     */

                    cabezaParticipante = actual.siguiente;
                }

                if (actual.siguiente != null) {
                    // Si el nodo a eliminar no es el último nodo
                    actual.siguiente.anterior = actual.anterior;
                }
                return; // Sale del método después de eliminar el nodo
            }
            actual = actual.siguiente; // Mueve al siguiente nodo
        }
    }

    public void listarParticipantes() { // SOLO PARA CONSULTAR EN GENERAL LOS PARTICIPANTES DE UN EVENTO
        NodoParticipante actual = cabezaParticipante;
        if (actual == null) {
            JOptionPane.showMessageDialog(null, "No hay participantes en este evento.");
            return;
        }

        StringBuilder listaParticipantes = new StringBuilder();
        while (actual != null) {
            listaParticipantes.append(actual.participante.getNombre())
                    .append(" - Edad: ").append(actual.participante.getEdad())
                    .append(" - Equipo: ").append(actual.participante.getEquipo())
                    .append("\n");
            actual = actual.siguiente;

        }
        JOptionPane.showMessageDialog(null, listaParticipantes.toString(), "Lista de Participantes", JOptionPane.INFORMATION_MESSAGE);
    }

    public String obtenerListaParticipantes() { // Para cuando se consultan los partidos 
        NodoParticipante actual = cabezaParticipante;
        StringBuilder listaParticipantes = new StringBuilder();
        while (actual != null) {
            listaParticipantes.append(actual.participante.getNombre())
                    .append(" - Edad: ").append(actual.participante.getEdad())
                    .append(" - Equipo: ").append(actual.participante.getEquipo())
                    .append("\n");
            actual = actual.siguiente;
        }
        return listaParticipantes.toString();
    }

    public void clasificarResultados() {
        Clasificacion clasificacionNueva = new Clasificacion();
        this.clasificacion = clasificacionNueva;
        NodoPartido actual = colaPartidos.getCabeza();

        while (actual != null) {
            Partido partido = actual.partido;
            String equipoA = partido.getNombreEquipoA();
            String equipoB = partido.getNombreEquipoB();
            int resultadoA = partido.getResultadoEquipoA();
            int resultadoB = partido.getResultadoEquipoB();

            if (resultadoA > resultadoB) {
                clasificacion.agregarEquipo(equipoA, resultadoA);
                clasificacion.agregarEquipo(equipoB, resultadoB);
            } else {
                clasificacion.agregarEquipo(equipoB, resultadoB);
                clasificacion.agregarEquipo(equipoA, resultadoA);
            }

            actual = actual.siguiente;
        }
    }

    public void mostrarClasificacion() {
        clasificacion.mostrarClasificacionCompleta();
    }

    public void agregarPartido(Partido partido) {
        colaPartidos.agregarPartido(partido);
        pilaResultados.apilar(partido.getResultadoEquipoA(), partido.getResultadoEquipoB());
        //mostrarClasificacion(); // +++++++++++++Hayu que hacer luego un metodo que si lo muestre por aparte
    }

    public void confirmarClasificar() {
        System.err.println("Se clasificaron los partidos");
        clasificarResultados();
        mostrarClasificacion();;
    }

    public Partido siguientePartido() {
        return colaPartidos.siguientePartido();
    }

    public void listarPartidos() {
        colaPartidos.listarPartidos(this);// this es opara pasar el evento actualzqw
    }

    // Actualización del método eliminarPartidos para usar el método correcto de ColaPartidos
    public void eliminarPartido(String codigoPartido) {
        colaPartidos.eliminarPartido(codigoPartido);
    }

    // Actualización del método buscarPartidos para usar el método correcto de ColaPartidos
    public Partido buscarPartido(String codigoPartido) {
        return colaPartidos.buscarPartido(codigoPartido);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public NodoParticipante getCabezaParticipante() {
        return cabezaParticipante;
    }

    public void setCabezaParticipante(NodoParticipante cabezaParticipante) {
        this.cabezaParticipante = cabezaParticipante;
    }

    public ColaPartidos getColaPartidos() {
        return colaPartidos;
    }

    public void setColaPartidos(ColaPartidos colaPartidos) {
        this.colaPartidos = colaPartidos;
    }
}
