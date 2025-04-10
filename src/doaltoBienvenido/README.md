# Buscaminas en Java

Este es un sencillo juego de Buscaminas implementado en Java. Se juega en consola y permite al usuario ingresar coordenadas para despejar casillas de un tablero de 6x6, evitando minas.

## Cómo funciona

1. **Inicio del juego**: El programa inicia automáticamente el juego cuando se ejecuta `Juego.java`.
2. **Mostrar el tablero**: El tablero de 6x6 se muestra en consola con casillas ocultas (`_`).
3. **Ingresar coordenadas**: El jugador introduce dos números (fila y columna) entre 1 y 6 para seleccionar una casilla.
4. **Comprobación de la casilla**:
   - Si la casilla contiene una mina, el juego termina con un mensaje de "BOOM!!, Explotaste una mina y perdiste!".
   - Si no hay mina, la casilla se marca como despejada (`D`).
5. **Condiciones de victoria o derrota**:
   - El jugador gana si logra despejar todas las casillas sin minas.
   - El jugador pierde si selecciona una mina.
6. **Reinicio del juego**: Al finalizar una partida, el jugador puede elegir si quiere jugar de nuevo.

## Archivos principales

- `Juego.java`: Clase principal que inicia el juego.
- `Buscaminas.java`: Gestiona el flujo del juego y permite reiniciar partidas.
- `Jugador.java`: Maneja las acciones del jugador y su estado (si sigue vivo o no).
- `Tablero.java`: Representa el tablero de juego, coloca minas y gestiona la lógica de despeje.


