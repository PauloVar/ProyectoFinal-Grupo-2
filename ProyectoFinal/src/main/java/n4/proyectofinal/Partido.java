package n4.proyectofinal;

public class Partido {

    private String codigoPartido; // Código único para identificar el partido
    private String nombreEquipoA; // Nombre del equipo A
    private String nombreEquipoB; // Nombre del equipo B
    private String fecha; // Fecha del partido
    private int resultadoEquipoA; // Resultado del equipo A como cadena de texto
    private int resultadoEquipoB; // Resultado del equipo B como cadena de texto

    public Partido(String codigoPartido, String nombreEquipoA, String nombreEquipoB, String fecha, int resultadoEquipoA, int resultadoEquipoB) {
        this.codigoPartido = codigoPartido;
        this.nombreEquipoA = nombreEquipoA;
        this.nombreEquipoB = nombreEquipoB;
        this.fecha = fecha;
        this.resultadoEquipoA = resultadoEquipoA;
        this.resultadoEquipoB = resultadoEquipoB;
    }

    // Getters y setters para cada atributo

    public String getCodigoPartido() {
        return codigoPartido;
    }

    public void setCodigoPartido(String codigoPartido) {
        this.codigoPartido = codigoPartido;
    }

    public String getNombreEquipoA() {
        return nombreEquipoA;
    }

    public void setNombreEquipoA(String nombreEquipoA) {
        this.nombreEquipoA = nombreEquipoA;
    }

    public String getNombreEquipoB() {
        return nombreEquipoB;
    }

    public void setNombreEquipoB(String nombreEquipoB) {
        this.nombreEquipoB = nombreEquipoB;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    @Override
    public String toString() {
        return "Partido: " + nombreEquipoA + " vs " + nombreEquipoB + "\n" +
               "Fecha: " + fecha + "\n" +
               "Resultado: " + resultadoEquipoA + " - " + resultadoEquipoB + "\n";
    }
}


/*
package n4.proyectofinal;

public class Partido {

    private String codigoPartido; // Código único para identificar el partido
    private String nombreEquipoA; // Nombre del equipo A
    private String nombreEquipoB; // Nombre del equipo B
    private String fecha; // Fecha del partido
    private String resultadoEquipoA; // Resultado del equipo A como cadena de texto
    private String resultadoEquipoB; // Resultado del equipo B como cadena de texto

    public Partido(String codigoPartido, String nombreEquipoA, String nombreEquipoB, String fecha, String resultadoEquipoA, String resultadoEquipoB) {
        this.codigoPartido = codigoPartido;
        this.nombreEquipoA = nombreEquipoA;
        this.nombreEquipoB = nombreEquipoB;
        this.fecha = fecha;
        this.resultadoEquipoA = resultadoEquipoA;
        this.resultadoEquipoB = resultadoEquipoB;
    }

    // Getters y setters para cada atributo

    public String getCodigoPartido() {
        return codigoPartido;
    }

    public void setCodigoPartido(String codigoPartido) {
        this.codigoPartido = codigoPartido;
    }

    public String getNombreEquipoA() {
        return nombreEquipoA;
    }

    public void setNombreEquipoA(String nombreEquipoA) {
        this.nombreEquipoA = nombreEquipoA;
    }

    public String getNombreEquipoB() {
        return nombreEquipoB;
    }

    public void setNombreEquipoB(String nombreEquipoB) {
        this.nombreEquipoB = nombreEquipoB;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getResultadoEquipoA() {
        return resultadoEquipoA;
    }

    public void setResultadoEquipoA(String resultadoEquipoA) {
        this.resultadoEquipoA = resultadoEquipoA;
    }

    public String getResultadoEquipoB() {
        return resultadoEquipoB;
    }

    public void setResultadoEquipoB(String resultadoEquipoB) {
        this.resultadoEquipoB = resultadoEquipoB;
    }

    @Override
    public String toString() {
        return "Partido: " + nombreEquipoA + " vs " + nombreEquipoB + "\n" +
               "Fecha: " + fecha + "\n" +
               "Resultado: " + resultadoEquipoA + " - " + resultadoEquipoB + "\n";
    }
}

*/