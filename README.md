# Snake game

## Castellano ![CastellanoLenguaje](media/es.png)

Simulación del famoso juego desarrollado por Gremlin en los mediados de la década de los 70 y que fue añadido más tarde, en 1998, en los móviles Nokia. Esta implementación se encuentra desarrollada en el lenguaje de Java y como pilar fundamental de esta implementación son los Patrones de Diseño utilizados.

Consta de un conjunto de clases divididas en la parte del Cliente y la parte del Servidor. Cada uno de ellos posee un socket (el del servidor acepta las conexiones y el del cliente las solicita), una hebra que recibe los mensajes del servidor y del cliente y una clase que los envía (streamIn y streamOut, en Cliente y Servidor). La relación entre todas las clases se encuentra en el siguiente dibujo, el cual realicé al comenzar con el proyecto:

![DiseñoJuego](media/diseño.jpg)

## English ![UKLanguage](media/gb.png) ![USLanguage](media/us.png)

Developed more than 30 years ago, this game is a simulation of the classic snake game included in Nokia mobile phones at 1998. This implementation is developed in Java, using Design Patterns. 

This game has some classes distribute on Client and Server. Each one has a socket (client demand a connection and server allow (or not) this connection), a thread which recieves server and client messages and a class wich sends these messages (through a streamIn and streamOut, in Client and Server).
