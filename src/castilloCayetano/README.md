# Buscaminas

## Introducción

El Buscaminas es un juego clásico en el que el objetivo es despejar todas las celdas que no contienen minas. El jugador puede realizar dos acciones principales:

1. **Despejar una celda**: Revela el contenido de la celda seleccionada.
2. **Marcar una celda**: Marca una celda sospechosa de contener una mina.

El juego termina cuando:

- El jugador despeja todas las celdas sin minas (¡Victoria!).
- El jugador pisa una mina (¡Derrota!).

## Ejemplo de Juego

### **Inicio del Juego**

```
  0 1 2 3 4
0 - - - - -
1 - - - - -
2 - - - - -
3 - - - - -
4 - - - - -
```

¿Qué deseas hacer? (1: Despejar, 2: Marcar):

### **Primer Movimiento**

El jugador decide **despejar** la celda en la posición `(1, 1)`:

¿Qué deseas hacer? (1: Despejar, 2: Marcar):
1

Introduce la fila y columna (separadas por un espacio):
1
1

```
  0 1 2 3 4
0       1 -
1       2 -
2 1 1 2 3 -
3 - - - - -
4 - - - - -
```

### **Segundo Movimiento**

El jugador decide **marcar** la celda en la posición `(0, 4)` como sospechosa de contener una mina:

¿Qué deseas hacer? (1: Despejar, 2: Marcar):
2

Introduce la fila y columna (separadas por un espacio):
0
4

```
  0 1 2 3 4
0       1 M
1       2 -
2 1 1 2 3 -
3 - - - - -
4 - - - - -
```

### **Varias Jugadas despues**

```
  0 1 2 3 4 
0       1 M
1       2 -
2 1 1 2 3 -
3 1 M 3 - -
4 1 1 - - -
```

¿Qué deseas hacer? (1: Despejar, 2: Marcar):
1

Introduce la fila y columna (separadas por un espacio):
4 2

```
  0 1 2 3 4 
0       1 M
1       2 -
2 1 1 2 3 -
3 1 M 3 - -
4 1 1 3 - -
```

### **Último Movimiento**

El jugador decide **despejar** la celda en la posición `(1, 4)`, pero pisa una mina:

¿Qué deseas hacer? (1: Despejar, 2: Marcar):
1

Introduce la fila y columna (separadas por un espacio):
1 4
¡Has pisado una mina! Fin del juego.

```
  0 1 2 3 4
0       1 M
1       2 *
2 1 1 2 3 *
3 1 * 3 * -
4 1 1 3 * -
```

¡Has perdido!
