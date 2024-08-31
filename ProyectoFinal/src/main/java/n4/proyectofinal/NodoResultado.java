package n4.proyectofinal;

public class NodoResultado { //estos nodos son para la pila de resultados
    private int resultadoEquipoA;
    private int resultadoEquipoB;
    private NodoResultado siguiente;

    public NodoResultado(int resultadoEquipoA, int resultadoEquipoB) {
        this.resultadoEquipoA = resultadoEquipoA;
        this.resultadoEquipoB = resultadoEquipoB;
        this.siguiente = null;
    }

    public int getResultadoEquipoA() {
        return resultadoEquipoA;
    }

    public void setResultadoEquipoA(int resultadoEquipoA) {
        this.resultadoEquipoA = resultadoEquipoA;
    }

    public int getResultadoEquipoB() {
        return resultadoEquipoB;
    }

    public void setResultadoEquipoB(int resultadoEquipoB) {
        this.resultadoEquipoB = resultadoEquipoB;
    }

    public NodoResultado getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoResultado siguiente) {
        this.siguiente = siguiente;
    }
}
