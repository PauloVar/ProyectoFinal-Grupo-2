package n4.proyectofinal;

public class NodoEvento {

    Evento evento;
    NodoEvento anterior;
    NodoEvento siguiente;

    public NodoEvento(Evento evento) {
        this.evento = evento;
    }
}
