package n4.proyectofinal;

import javax.swing.JOptionPane;

public class Menu {

    private ListaEventos listaEventos = new ListaEventos();
    private ColaPartidos colaPartidos = new ColaPartidos();
    private PilaResultados pilaResultados = new PilaResultados();

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            String[] opciones = {"Administrador", "Espectador", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione un rol:",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (seleccion) {
                case 0: // Administrador
                    menuAdministrador();
                    break;
                case 1: // Espectador
                    menuEspectador();
                    break;
                case 2: // Salir
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Selección inválida. Intente nuevamente.");
            }
        }
    }

    private void menuAdministrador() {
        boolean regresar = false;
        while (!regresar) {
            String[] opciones = {"Registrar Evento", "Modificar Evento", "Consultar", "Regresar"};
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción de administrador:",
                    "Menú Administrador",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (seleccion) {
                case 0: // Registrar Evento
                    registrarEvento();
                    break;
                case 1: // Modificar Evento
                    modificarEvento();
                    break;
                case 2: // Consultar
                    menuConsultar();
                    break;
                case 3: // Regresar
                    regresar = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Selección inválida. Intente nuevamente.");
            }
        }
    }

    private void menuEspectador() {
        boolean regresar = false;
        while (!regresar) {
            String[] opciones = {"Consultar", "Regresar"};
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción de espectador:",
                    "Menú Espectador",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (seleccion) {
                case 0: // Consultar
                    menuConsultar();
                    break;
                case 1: // Regresar
                    regresar = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Selección inválida. Intente nuevamente.");
            }
        }
    }

    private void menuConsultar() {
        boolean regresar = false;
        while (!regresar) {
            String[] opciones = {"Consultar Eventos", "Consultar Información y Resultados", "Consultar Participantes", "Regresar"};
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción de consulta:",
                    "Menú de Consultas",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (seleccion) {
                case 0: // Consultar Eventos
                    consultarEventos();
                    break;
                case 1: // Consultar Información y Resultados
                    consultarResultados();
                    break;
                case 2: // Consultar Participantes
                    consultarParticipantes();
                    break;
                case 3: // Regresar
                    regresar = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Selección inválida. Intente nuevamente.");
            }
        }
    }

    private void registrarEvento() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del evento:");
        if (nombre == null || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del evento no puede estar vacío.");
            return;
        }

        String fecha = JOptionPane.showInputDialog("Ingrese la fecha del evento (dd/MM/yyyy):");
        if (fecha == null || fecha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La fecha del evento no puede estar vacía.");
            return;
        }

        String ubicacion = JOptionPane.showInputDialog("Ingrese la ubicación del evento:");
        if (ubicacion == null || ubicacion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La ubicación del evento no puede estar vacía.");
            return;
        }

        Evento evento = new Evento(nombre, fecha, ubicacion);
        listaEventos.agregarEvento(evento);
        JOptionPane.showMessageDialog(null, "Evento registrado exitosamente.");
    }

    private void modificarEvento() {
        String nombreEvento = JOptionPane.showInputDialog("Ingrese el nombre del evento a modificar:");
        Evento evento = listaEventos.buscarEventoPorNombre(nombreEvento);

        if (evento == null) {
            JOptionPane.showMessageDialog(null, "Evento no encontrado.");
            return;
        }

        boolean regresar = false;
        while (!regresar) {
            String[] opciones = {"Modificar Datos del Evento", "Modificar Participantes", "Modificar Partidos", "Regresar"};
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción para modificar:",
                    "Modificar Evento",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (seleccion) {
                case 0: // Modificar Datos del Evento
                    modificarDatosEvento(evento);
                    break;
                case 1: // Modificar Participantes
                    modificarParticipantes(evento);
                    break;
                case 2: // Modificar Partidos
                    modificarPartidos(evento);
                    break;
                case 3: // Regresar
                    regresar = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Selección inválida. Intente nuevamente.");
            }
        }
    }

    private void modificarDatosEvento(Evento evento) {
        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del evento:", evento.getNombre());
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            evento.setNombre(nuevoNombre);
        }

        String nuevaFecha = JOptionPane.showInputDialog("Ingrese la nueva fecha del evento (dd/MM/yyyy):", evento.getFecha());
        if (nuevaFecha != null && !nuevaFecha.isEmpty()) {
            evento.setFecha(nuevaFecha);
        }

        String nuevaUbicacion = JOptionPane.showInputDialog("Ingrese la nueva ubicación del evento:", evento.getUbicacion());
        if (nuevaUbicacion != null && !nuevaUbicacion.isEmpty()) {
            evento.setUbicacion(nuevaUbicacion);
        }

        JOptionPane.showMessageDialog(null, "Datos del evento modificados exitosamente.");
    }

    private void modificarParticipantes(Evento evento) {
        boolean regresar = false;
        while (!regresar) {
            String[] opciones = {"Agregar Participante", "Eliminar Participante", "Listar Participantes", "Regresar"};
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción para los participantes:",
                    "Modificar Participantes",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (seleccion) {
                case 0: // Agregar Participante
                    agregarParticipante(evento);
                    break;
                case 1: // Eliminar Participante
                    eliminarParticipante(evento);
                    break;
                case 2: // Listar Participantes
                    evento.listarParticipantes();
                    break;
                case 3: // Regresar
                    regresar = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Selección inválida. Intente nuevamente.");
            }
        }
    }

    private void agregarParticipante(Evento evento) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del participante:");
        if (nombre == null || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del participante no puede estar vacío.");
            return;
        }

        String edadStr = JOptionPane.showInputDialog("Ingrese la edad del participante:");
        int edad;
        try {
            edad = Integer.parseInt(edadStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Edad inválida. Debe ser un número.");
            return;
        }

        String equipo = JOptionPane.showInputDialog("Ingrese el equipo del participante (Equipo A o B):");
        if (equipo == null || equipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El equipo del participante no puede estar vacío.");
            return;
        }

        if (!equipo.equals("A") && !equipo.equals("B")) {
            JOptionPane.showMessageDialog(null, "El equipo debe ser 'A' o 'B'.");
            return;
        }

        Participante participante = new Participante(nombre, edad, equipo);
        evento.agregarParticipante(participante);
        JOptionPane.showMessageDialog(null, "Participante agregado exitosamente.");
    }

    private void eliminarParticipante(Evento evento) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del participante a eliminar:");
        if (nombre == null || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del participante no puede estar vacío.");
            return;
        }

        evento.eliminarParticipante(nombre);
        JOptionPane.showMessageDialog(null, "Participante eliminado exitosamente.");
    }

    private void modificarPartidos(Evento evento) {
        boolean regresar = false;
        while (!regresar) {
            String[] opciones = {"Añadir Partido", "Modificar Codigo del Partido", "Modificar Resultado del Partido", "Modificar Fecha del Partido", "Eliminar Partido", "Listar Partidos", "Clasificar", "Regresar"};
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción para los partidos:",
                    "Modificar Partidos",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (seleccion) {
                case 0: // Añadir Partido
                    anadirPartido(evento);
                    break;
                case 1: // Modificar Codigo del Partido
                    modificarCodigoPartido(evento);
                    break;
                case 2: // Modificar Codigo del Partido
                    modificarResultadoPartido(evento);
                    break;
                case 3: // Modificar Codigo del Partido
                    modificarFechaPartido(evento);
                    break;
                case 4: // Eliminar Partido
                    eliminarPartido(evento);
                    break;
                case 5: // Listar Partidos
                    listarPartidos(evento);
                case 6: // Listar Partidos
                    confirmarClasificar(evento);
                    break;
                case 7: // Regresar
                    regresar = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Selección inválida. Intente nuevamente.");
            }
        }
    }

    /*
    private void anadirPartido(Evento evento) {
        String codigoPartido = JOptionPane.showInputDialog("Ingrese el código del nuevo partido:");
        if (codigoPartido == null || codigoPartido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El código del partido no puede estar vacío.");
            return;
        }

        String nombreEquipoA = JOptionPane.showInputDialog("Ingrese el nombre del primer equipo (Este será el equipo A):");
        if (nombreEquipoA == null || nombreEquipoA.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del primer equipo no puede estar vacío.");
            return;
        }

        String nombreEquipoB = JOptionPane.showInputDialog("Ingrese el nombre del segundo equipo (Este será el equipo B):");
        if (nombreEquipoB == null || nombreEquipoB.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del segundo equipo no puede estar vacío.");
            return;
        }

        String fecha = JOptionPane.showInputDialog("Ingrese la fecha del partido (dd/MM/yyyy):");
        if (fecha == null || fecha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La fecha del partido no puede estar vacía.");
            return;
        }

        String resultadoEquipoA = JOptionPane.showInputDialog("Ingrese el resultado del equipo A:");
        if (resultadoEquipoA == null || resultadoEquipoA.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El resultado del partido no puede estar vacío.");
            return;
        }
        
        String resultadoEquipoB = JOptionPane.showInputDialog("Ingrese el resultado del equipo B:");
        if (resultadoEquipoB == null || resultadoEquipoB.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El resultado del partido no puede estar vacío.");
            return;
        }
        
        Partido nuevoPartido = new Partido(codigoPartido, nombreEquipoA, nombreEquipoB, fecha, resultadoEquipoA,resultadoEquipoB);
        evento.agregarPartido(nuevoPartido);
        JOptionPane.showMessageDialog(null, "Partido añadido exitosamente.");
    }
     */
    private void modificarCodigoPartido(Evento evento) {
        String codigoPartidoActual = JOptionPane.showInputDialog("Ingrese el código actual del partido:");
        Partido partido = evento.buscarPartido(codigoPartidoActual);

        if (partido == null) {
            JOptionPane.showMessageDialog(null, "Partido no encontrado.");
            return;
        }

        String nuevoCodigo = JOptionPane.showInputDialog("Ingrese el nuevo código del partido:");
        if (nuevoCodigo != null && !nuevoCodigo.isEmpty()) {
            partido.setCodigoPartido(nuevoCodigo); //nuevo codigo
            JOptionPane.showMessageDialog(null, "Código del partido modificado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El código del partido no puede estar vacío.");
        }
    }

    /*
    private void modificarResultadoPartido(Evento evento) {
        String codigoPartidoActual = JOptionPane.showInputDialog("Ingrese el código del partido que contiene el resultado a cambiar:");
        Partido partido = evento.buscarPartido(codigoPartidoActual);

        if (partido == null) {
            JOptionPane.showMessageDialog(null, "Partido no encontrado.");
            return;
        }

        String nuevoResultadoEquipoA = JOptionPane.showInputDialog("Ingrese el nuevo resultado del equipo A ("+partido.getNombreEquipoA()+"): ");
        if (nuevoResultadoEquipoA != null && !nuevoResultadoEquipoA.isEmpty()) {
            partido.setResultadoEquipoA(nuevoResultadoEquipoA); 
            JOptionPane.showMessageDialog(null, "Resultado del partido modificado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El resultado del partido no puede estar vacío.");
        }
        
        String nuevoResultadoEquipoB = JOptionPane.showInputDialog("Ingrese el nuevo resultado del equipo B ("+partido.getNombreEquipoB()+"): ");
        if (nuevoResultadoEquipoB!= null && !nuevoResultadoEquipoB.isEmpty()) {
            partido.setResultadoEquipoB(nuevoResultadoEquipoB); 
            JOptionPane.showMessageDialog(null, "Resultado del partido modificado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El resultado del partido no puede estar vacío.");
        }
    }
     */
    private void modificarResultadoPartido(Evento evento) {
        String codigoPartidoActual = JOptionPane.showInputDialog("Ingrese el código del partido que contiene el resultado a cambiar:");
        Partido partido = evento.buscarPartido(codigoPartidoActual);

        if (partido == null) {
            JOptionPane.showMessageDialog(null, "Partido no encontrado.");
            return;
        }

        int nuevoResultadoEquipoA;
        try {
            nuevoResultadoEquipoA = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo resultado del equipo A (" + partido.getNombreEquipoA() + "):"));
            partido.setResultadoEquipoA(nuevoResultadoEquipoA);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El resultado del equipo A debe ser un número entero.");
            return;
        }

        int nuevoResultadoEquipoB;
        try {
            nuevoResultadoEquipoB = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo resultado del equipo B (" + partido.getNombreEquipoB() + "):"));
            partido.setResultadoEquipoB(nuevoResultadoEquipoB);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El resultado del equipo B debe ser un número entero.");
            return;
        }

        JOptionPane.showMessageDialog(null, "Resultado del partido modificado exitosamente.");
    }

    private void confirmarClasificar(Evento evento) {
        evento.confirmarClasificar();
    }

    private void anadirPartido(Evento evento) {
        String codigoPartido = JOptionPane.showInputDialog("Ingrese el código del nuevo partido:");
        if (codigoPartido == null || codigoPartido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El código del partido no puede estar vacío.");
            return;
        }

        String nombreEquipoA = JOptionPane.showInputDialog("Ingrese el nombre del primer equipo (Este será el equipo A):");
        if (nombreEquipoA == null || nombreEquipoA.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del primer equipo no puede estar vacío.");
            return;
        }

        String nombreEquipoB = JOptionPane.showInputDialog("Ingrese el nombre del segundo equipo (Este será el equipo B):");
        if (nombreEquipoB == null || nombreEquipoB.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del segundo equipo no puede estar vacío.");
            return;
        }

        String fecha = JOptionPane.showInputDialog("Ingrese la fecha del partido (dd/MM/yyyy):");
        if (fecha == null || fecha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La fecha del partido no puede estar vacía.");
            return;
        }

        JOptionPane.showMessageDialog(null, "NOTA: Si el partido no se ha jugado procure poner los resulatos de los equipos en 0, puede ser cambiado luego");

        int puntuacionEquipoA;
        try {
            puntuacionEquipoA = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el resultado del equipo A (número entero):"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El resultado del equipo A debe ser un número entero.");
            return;
        }

        int puntuacionEquipoB;
        try {
            puntuacionEquipoB = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el resultado del equipo B (número entero):"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El resultado del equipo B debe ser un número entero.");
            return;
        }

        Partido nuevoPartido = new Partido(codigoPartido, nombreEquipoA, nombreEquipoB, fecha, puntuacionEquipoA, puntuacionEquipoB);
        evento.agregarPartido(nuevoPartido);
        JOptionPane.showMessageDialog(null, "Partido añadido exitosamente.");
    }

    private void modificarFechaPartido(Evento evento) {
        String codigoPartidoActual = JOptionPane.showInputDialog("Ingrese el código del partido que contiene la fecha a cambiar:");
        Partido partido = evento.buscarPartido(codigoPartidoActual);

        if (partido == null) {
            JOptionPane.showMessageDialog(null, "Partido no encontrado.");
            return;
        }

        String nuevaFecha = JOptionPane.showInputDialog("Ingrese la nueva fecha del partido:");
        if (nuevaFecha != null && !nuevaFecha.isEmpty()) {
            partido.setFecha(nuevaFecha); //nuevo codigo
            JOptionPane.showMessageDialog(null, "Fecha del partido modificada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El resultado del partido no puede estar vacío.");
        }
    }

    private void eliminarPartido(Evento evento) {
        String codigoPartido = JOptionPane.showInputDialog("Ingrese el código del partido a eliminar:");
        if (codigoPartido == null || codigoPartido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El código del partido no puede estar vacío.");
            return;
        }

        evento.eliminarPartido(codigoPartido);
        JOptionPane.showMessageDialog(null, "Partido eliminado exitosamente.");
    }
    
    private void listarPartidos(Evento evento) {
        evento.listarPartidos();
    }

    private void consultarEventos() {
        listaEventos.listarEventos();
    }

    private void consultarResultados() { 
        String nombreEvento = JOptionPane.showInputDialog("Ingrese el nombre del evento para consultar resultados:");
        Evento evento = listaEventos.buscarEventoPorNombre(nombreEvento);

        if (evento == null) {
            JOptionPane.showMessageDialog(null, "Evento no encontrado.");
            return;
        }
        evento.listarPartidos();
    }

    private void consultarParticipantes() {
        String nombreEvento = JOptionPane.showInputDialog("Ingrese el nombre del evento para consultar participantes:");
        Evento evento = listaEventos.buscarEventoPorNombre(nombreEvento);

        if (evento == null) {
            JOptionPane.showMessageDialog(null, "Evento no encontrado.");
            return;
        }

        evento.listarParticipantes();
    }
}
