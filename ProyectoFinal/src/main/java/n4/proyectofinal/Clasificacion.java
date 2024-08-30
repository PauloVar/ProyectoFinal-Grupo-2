package n4.proyectofinal;

import javax.swing.JOptionPane;

public class Clasificacion { // Este es el arbol

    private NodoArbol raiz;

    public Clasificacion() {
        this.raiz = null;
    }

    public void agregarEquipo(String nombreEquipo, int puntos) {
        raiz = agregarEquipoRec(raiz, nombreEquipo, puntos);
    }

    private NodoArbol agregarEquipoRec(NodoArbol nodo, String nombreEquipo, int puntos) {
        if (nodo == null) {
            return new NodoArbol(nombreEquipo, puntos);
        }

        if (puntos > nodo.getPuntos()) {
            nodo.setDerecho(agregarEquipoRec(nodo.getDerecho(), nombreEquipo, puntos));
        } else {
            nodo.setIzquierdo(agregarEquipoRec(nodo.getIzquierdo(), nombreEquipo, puntos));
        }

        return nodo;
    }

    public void mostrarClasificacionCompleta() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clasificación completa:\n");
        mostrarClasificacionRec(raiz, sb);
        sb.append("\nTop 3 equipos:\n");
        mostrarTopTresRec(raiz, sb, 3);

        JOptionPane.showMessageDialog(null, sb.toString(), "Clasificación y Top 3", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarClasificacionRec(NodoArbol nodo, StringBuilder sb) {
        if (nodo != null) {
            mostrarClasificacionRec(nodo.getDerecho(), sb);
            sb.append("Equipo: ").append(nodo.getNombreEquipo()).append(" - Puntos: ").append(nodo.getPuntos()).append("\n");
            mostrarClasificacionRec(nodo.getIzquierdo(), sb);
        }
    }

    private int mostrarTopTresRec(NodoArbol nodo, StringBuilder sb, int count) {
        if (nodo != null && count > 0) {
            count = mostrarTopTresRec(nodo.getDerecho(), sb, count);

            if (count > 0) {
                sb.append("Equipo: ").append(nodo.getNombreEquipo()).append(" - Puntos: ").append(nodo.getPuntos()).append("\n");
                count--;
            }

            count = mostrarTopTresRec(nodo.getIzquierdo(), sb, count);
        }
        return count;
    }
}
