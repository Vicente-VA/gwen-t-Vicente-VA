# Entrega Parcial 5 | Tarea 3

Para esta entrega, deberá implementar los efectos de las cartas, mencionados en la sección 1.4 del
proyecto semestral.

En específico, se les pide:

1. Crear una rama llamada ``tarea-3/entrega-parcial-5``. Recuerde hacer *checkout* a esta rama 
    para realizar la tarea.
2. Implemente los patrones de diseño necesarios para modelar los efectos de una carta.

Nótese que, a diferencia de la entrega parcial anterior, existe más de una manera de implementar
dicha funcionalidad.

Como consejo, desarrolle su idea primero en base a los patrones que considere más atingentes y luego
mida la facilidad personal de realizar uno de ellos.

**Importante:** El controlador no debe por ningún motivo ser partícipe de la aplicación de estos
efectos, ni gestionarlos de alguna manera. *No es su responsabilidad*. Piense entonces qué entidad
debiese encargarse de que las cartas puedan enterarse de que apareció una carta que le aplicará
dicho efecto. (Debiese ser lo suficientemente directo como para no darle muchas vueltas)

Todos los métodos que implementen deben tener sus respectivos tests.

## Entrega

Para hacer entrega de la tarea ustedes deberán crear un *pull request* desde la rama
``tarea-3/entrega-parcial-5`` a la rama ``master`` llamado ``Tarea 3 - Entrega Parcial 5``.

Es importante que **no hagan merge** de la rama ``tarea-3/entrega-parcial-5`` a la rama ``master``
para que el cuerpo docente pueda revisar su *pull request*.

Por *U-Cursos* debe entregar un único archivo llamado ``entrega-parcial-5.txt`` con el siguiente 
contenido:

```
Nombre: <nombre completo>
Pull Request: <link al pull request>
```

## Evaluación

Para la evaluación de esta tarea se revisará que se cumpla el siguiente punto:

- Existe al menos un efecto funcional para cualquier tipo de carta. (no necesariamente bien
diseñado)

La realización de esta tarea es **obligatoria** y corresponde a 0.3 puntos de la nota final de la 
Tarea 3.
