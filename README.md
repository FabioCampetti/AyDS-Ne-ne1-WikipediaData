# AyDS-Ne-ne1-WikipediaData

## Interfaz:
La interfaz a usar se llama WikipediaService, se lo instancia de la siguiente manera: 

    WikipediaService.getInstance()

El método para obtener la descripción de la película es: 

    fun getCard(movieTitle: String, movieYear: String): Card

## Tipo de Retorno:
El método retorna un objeto *Card*, que tiene el título (title), el resumen de la película (text), y la url del logo de wikipedia (path).
En el caso que la búsqueda falle, todos estos datos se devuelven como cadenas vacías. 
