# ms-tickets-v1
Proyecto
===================

API shows

Requisitos previos
------------------

Versión Java 17

Pruebas de API
------------------
Puede realizarlo por:

`localhost:8080`

`159.223.158.227:8080`

Configuración
-------------

1.  Clonar el repositorio: `git clone https://github.com/miguelmariguin/ms-tickets-v1.git`
2.  Instalar dependencias: `mvn compile`
3.  Para correr la aplicación: `mvn spring-boot:run`

Uso
---

Para utilizar los puntos solicitados, se detallan a continuación:

### Crear una reserva

Enviar una solicitud POST a `/createReserva` con el siguiente cuerpo:
Ejemplo para que Juan Perez compre 4 entradas de $100-

POST
`localhost:8080/createReserva`
`159.223.158.227:8080/createReserva `
 
`{     "reserva": {         "dni": "123123",         "apellidos": "Perez",         "nombres": "Juan"     },     "compra": [         {             "cantidad": 4,             "precio": 100,             "funcion_id": 1         }     ] }`

### Obtener detalles de una Función del Show

Enviar una solicitud GET a `/funcionDetail?showId=2` con el siguiente formato:

GET 
`localhost:8080/funcionDetail?showId=2`
`159.223.158.227:8080/funcionDetail?showId=2`

### Obtener todos los shows

Enviar una solicitud GET a `/shows` para obtener todos los shows:
GET
`localhost:8080/shows`
`159.223.158.227:8080/shows`

### Reiniciar
Para reiniciar los datos de la BD en memoria utilizada H2 puede recargar los datos para seguir probando la API.

Enviar una solicitud GET a `/reset` para reiniciar el sistema:

GET
`localhost:8080/reset`
`159.223.158.227:8080/reset`

### Filtrar shows por fecha y precio

Enviar una solicitud GET a `/shows` con los parámetros `fechaInicio`, `fechaFin`, `precioMin` y `precioMax` para filtrar los shows según los criterios especificados:

GET

`localhost:8080/shows?fechaInicio=2023-10-01&fechaFin=2023-11-21`

`159.223.158.227:8080/shows?fechaInicio=2023-10-01&fechaFin=2023-11-21`


`localhost:8080/shows?fechaInicio=2023-10-01&fechaFin=2023-11-21&precioMin=0&precioMax=1000`

`159.223.158.227:8080/shows?fechaInicio=2023-10-01&fechaFin=2023-11-21&precioMin=0&precioMax=1000`


Autor
-----

Miguel Mariguin
