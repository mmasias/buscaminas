1 - Tablero:
Guarda todas las casillas del juego.
Se encarga de colocar las minas aleatoriamente.
Tiene métodos para mostrar el tablero y actualizarlo.
Comprueba si una casilla tiene mina o está despejada.
Controla si se ha terminado la partida.

2 - Casilla:
Aunque no es una clase separada, cada casilla guarda su estado.
Puede contener mina o estar vacía.
Puede estar revelada o no.
Puede tener minas alrededor (en una versión más avanzada).

3 - Jugador:
Representa al usuario que juega.
Pide coordenadas al usuario y ejecuta la jugada.
Controla si el jugador sigue vivo o ha perdido.
Gestiona las acciones del jugador sobre el tablero.

4 - Juego (Main):
Es el motor principal del juego.
Inicializa el tablero y al jugador.
Controla el desarrollo de la partida con un bucle de juego.
Muestra mensajes según si gana o pierde.
Permite reiniciar la partida o salir del juego.