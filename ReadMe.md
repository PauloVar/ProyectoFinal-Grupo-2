# Proyecto de Gestión de Eventos Deportivos

# Grupo 2 

## Integrantes:
- Paulo Vargas Valenciano
- Eduardo Ramos Rodriguez

## Funcionalidad del Proyecto:

### Gestión de eventos deportivos:
El programa gestiona eventos deportivos, donde cada evento contiene una cola de partidos que se disputan entre equipos.

### Almacenamiento de eventos:
Cada evento está almacenado en una lista enlazada simple.

### Participantes en eventos:
Cada evento contiene participantes, los cuales están en una lista doblemente enlazada.

### Modificación de datos:
Los datos de los eventos, partidos y participantes pueden ser eliminados o modificados.

### Almacenamiento de resultados:
Los resultados de los partidos son guardados en una pila y en un árbol binario.

### Registro de partidos:
Los partidos son registrados en la clase `Evento`, que almacena los equipos y los puntos obtenidos por cada uno.

### Clasificación de equipos:
Para clasificar a los equipos, el programa utiliza la clase `Clasificacion`, que emplea un árbol binario. Este árbol organiza a los equipos según los puntos acumulados: la raíz contiene al equipo con más puntos, los nodos izquierdos a los equipos con menos puntos, y los nodos derechos a los equipos con más puntos.

### Actualización del árbol de clasificación:
Cada partido se lee desde la cola, y los equipos involucrados se agregan al árbol binario de clasificación. Si un equipo ya existe en el árbol, sus puntos se actualizan acumulativamente.

### Visualización de resultados:
Todo este proceso asegura que los resultados sean fáciles de visualizar y entender para el usuario final y para el administrador. Los usuarios y administradores emplean menús con `JOptionPane` para navegar en el sistema, proporcionando una presentación ordenada y un resumen claro de la información en cada evento.
