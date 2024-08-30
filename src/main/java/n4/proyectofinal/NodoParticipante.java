package n4.proyectofinal;

public class NodoParticipante {

    Participante participante;//objeto tipo Partificpante llamado participante, representa solo a 1
    NodoParticipante anterior;
    NodoParticipante siguiente;

    public NodoParticipante(Participante participante) {
        this.participante = participante;
    }
}
