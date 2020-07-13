# AyDS-Ne-ne1-WikipediaData

## Interfaz:
La interfaz a usar se llama ExternalService y el método para obtener la descripción de la película es: 

    fun getCard(movieTitle: String, movieYear: String): Card
   
Se debe pasar el título de la película, y el año.    

## Tipo de Retorno:
El método retorna un objeto *MovieDescriptonResponse*, que tiene el título (title), el resumen de la película (text), la url del logo de wikipedia (path), y el nombre de la fuente de la información (source).
En el caso que la búsqueda falle, todos estos datos se devuelven como cadenas vacías. 
