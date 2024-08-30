 package n4.proyectofinal;

public class PilaResultados {
    private NodoResultado cima;

    public PilaResultados() {
        this.cima = null;
    }

    public void apilar(int resultadoEquipoA, int resultadoEquipoB) {
        NodoResultado nuevoNodo = new NodoResultado(resultadoEquipoA, resultadoEquipoB);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
        listarResultados();
    }

    public NodoResultado desapilar() {
        if (cima == null) {
            return null; // La pila está vacía
        }
        NodoResultado resultado = cima;
        cima = cima.getSiguiente();
        return resultado;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void listarResultados() {
        NodoResultado actual = cima;
        StringBuilder sb = new StringBuilder();

        if (actual == null) {
            sb.append("No hay resultados en la pila.");
        } else {
            while (actual != null) {
                sb.append("Resultado de pila: ")
                  .append(actual.getResultadoEquipoA())
                  .append(" - ")
                  .append(actual.getResultadoEquipoB())
                  .append("\n");
                actual = actual.getSiguiente();
            }
        }
        System.out.println(sb.toString());
    }
}
