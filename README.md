# FullStack 1 - Actividad Formativa 3

## API Movies

Api creada con Springboot para gestionar registro de películas.

## Dependencias

* Lombok
* Springboot-starter-web
* Sprinboot-devtools
* Springboot-starter-data-jpa
* Oracle Driver: ojdbc
* oracle pki
* osdt_core
* osdt_cert
* spring-boot-starter-hateoas

## Configurar variables de entorno para conexión a Oracle Cloud

* Copiar archivo .env.example y renombrar a .env
* Completar las variables de entorno relacionadas con el nombre de la base de datos, dirección del Wallet descomprimido,
nombre de usuario y password.

## Endpoints para ambiente de Desarrollo

* GET: Obtener todas las películas: http://localhost:8080/movies/getAllMovies
* GET: Obtener película por ID: http://localhost:8080/movies/{id}
* POST: Crear un nuevo registro de película: http://localhost:8080/movies
* PUT: Actualizar una película: http://localhost:8080/movies/{id}
* DELETE: Eliminar una película: http://localhost:8080/movies/{id}

## Ejemplo para Request Body

```json
{
    "title":"Titanic",
    "year":1997,
    "director":"James Cameron",
    "genre":"Romance",
    "synopsis":"Historia de amor previa al hundimiento del Titanic"
}
```

## Actividad Formativa 5

* Agregar pruebas unitarias
* Implementar HATEOAS