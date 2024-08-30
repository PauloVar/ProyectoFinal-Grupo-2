package n4.proyectofinal;

public class NodoArbol { // solo representa el nodo del arbol
    private String nombreEquipo;
    private int puntos;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    public NodoArbol(String nombreEquipo, int puntos) {
        this.nombreEquipo = nombreEquipo;
        this.puntos = puntos;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Getters y setters
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }
}

