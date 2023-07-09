# Entrega Parcial 4 | Tarea 3

Para esta entrega, deberá iniciar la implementación del controlador del videojuego, junto con sus
respectivas fases. Estas fases corresponden a la sección 1.5 del enunciado del proyecto (a excepción
de la sección 1.5.1), donde son definidas las reglas. 

En específico, se les pide:

1. Crear una rama llamada ``tarea-3/entrega-parcial-4``. Recuerde hacer *checkout* a esta rama 
    para realizar la tarea.
2. Diseñe un diagrama de estados para modelar el flujo de la partida. Por ejemplo, algunos estados
   posibles podrían ser:
   - Estado inicial de la partida
   - Estado de la partida cuando un jugador está decidiendo si jugar una carta o pasar su turno
   - La computadora está jugando
3. Implemente los patrones de diseño necesarios para modelar los estados de la partida.
4. Implemente los métodos necesarios en el controlador para inicializar una partida.

No se requiere que implemente todo el controlador ni el flujo del juego, solamente definir cuáles
son los estados posibles y qué acciones gatillan las transiciones entre estados. 
Por ejemplo, si un jugador decide jugar una carta, el estado del juego debiera cambiar; implemente
el método que causa el cambio de estado (y realice el cambio de estado en sí mismo), pero no es
necesario que se realice la acción de jugar la carta.
Es decir, basta con que sus métodos realicen los cambios de estado, aunque no realicen las acciones
específicas de cada estado.

Todos los métodos que implementen deben tener sus respectivos tests.

## Diagrama de estados

Se le pide que diseñe un diagrama de estados (dibujo) para modelar el flujo de la partida.
Para esto, debe

- Identificar los estados posibles de la partida
- Identificar las transiciones entre estados
- Identificar los eventos que disparan las transiciones

Se le recomienda hacer este diagrama _**ANTES**_ de comenzar a implementar los estados, ya que
esto le permitirá tener una visión más clara de cómo debe implementar los estados (va a terminar
beneficiándose de esto).

Para dibujar el diagrama de estados, puede utilizar cualquier herramienta que le acomode.
Puede usar, por ejemplo, [draw.io](https://app.diagrams.net).

El diagrama debe incluirse en el archivo ``README.md`` de su proyecto.
Para hacer esto, debe subir el archivo a su repositorio, por ejemplo en la carpeta ``docs``, con
el nombre ``diagrama-estados.png``. Luego, debe incluir la imagen en el archivo ``README.md``:

```markdown
# Gwen't
...

## Diagrama de estados

![Diagrama de estados](docs/diagrama-estados.png)
```

## Ejemplo

```scala
class GameController {
    // Estado actual del juego
    var state: GameState = new StartState(this)

    def startGame(): Unit = { 
        state.startGame()
        /* ... */
    }

    def playCard(card: Card): Unit = {
        /* ... */
    }

    def endTurn(): Unit = {
        /* ... */
    }
}

class GameState {
    def startGame(): Unit = { /* ... */ }
    def playCard(card: Card): Unit = { /* ... */ }
    def endTurn(): Unit = { /* ... */ }
}

class StartState(controller: GameController) extends GameState {
    override def startGame(): Unit = {
        /* ... */
        controller.state = new /* ... */
    }

    override def playCard(card: Card): Unit = {
        /* ... */
        controller.state = new /* ... */
    }

    override def endTurn(): Unit = {
        /* ... */
        controller.state = new /* ... */
    }
}
```

> Nota:
> Tenga en cuenta que esto es **solo un ejemplo** para ilustrar la idea, no es necesario que lo 
> implemente de esta forma.
> Use este ejemplo como _inspiración_ para implementar su solución.

## Entrega

Para hacer entrega de la tarea ustedes deberán crear un *pull request* desde la rama
``tarea-3/entrega-parcial-4`` a la rama ``master`` llamado ``Tarea 3 - Entrega Parcial 4``.

Es importante que **no hagan merge** de la rama ``tarea-3/entrega-parcial-4`` a la rama ``master``
para que el cuerpo docente pueda revisar su *pull request*.

Por *U-Cursos* debe entregar un único archivo llamado ``entrega-parcial-4.txt`` con el siguiente 
contenido:

```
Nombre: <nombre completo>
Pull Request: <link al pull request>
```

## Evaluación

Para la evaluación de esta tarea se revisará que se cumplan los siguientes puntos:

- Se incluyó un diagrama de estados en el archivo ``README.md``.
- Existe implementación de alguno(s) de los estados que aparecen en el diagrama.

La realización de esta tarea es **obligatoria** y corresponde a 0.3 puntos de la nota final de la 
Tarea 3.
