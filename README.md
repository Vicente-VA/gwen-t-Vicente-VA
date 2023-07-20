# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---

## Tarea 2: Entrega final
- Se utilizaron varios dispatch para jugar las cartas, intentando aislar lo mas posible cada uno de los elementos que interactuan para jugar una carta
- Se utiliza **IPlayUnit** y **IPlayWeather** para el double dispatch en el caso de *Player* y **IPlayUnit** para *Section* pues solo reciben cartas, pero los metodos de estas interfaces están modificados en **IBoard** para indicar además quien juega la carta
- Los metodos involucrados en los dispatch retornan booleanos para evitar el uso de exceptions. Esto lo hice principalmente porque no me hacia demasiado sentido que el programa entero se caiga cuando no se pueda jugar una carta (por ejemplo), y ayudaba para los assert de algunos test. Además, no sabía donde poner los try-catch por las vueltas que se dan los dispatch.
- La inicializacion de los *Player* y *Board* se hace en el orden Player 1, Player 2 (... Player N), Board(P1, P2). Los jugadores se inicializan con **NullBoard** (tableros que no permiten jugar cartas) y al inicializar *Board* se asigna el mismo a P1 y P2. *Board* utiliza a los jugadores para saber quien jugo la carta (y posicionarla en la seccion que le corresponde) y *Player* utiliza al tablero para saber a donde tiene que ir la carta jugada (y eventualmente saber las cartas que hay en el campo).
![diagrama](https://github.com/dcc-cc3002/gwen-t-Bysholo/assets/89215981/5a91ef0f-e851-4919-83e3-a840d05e1d59)
