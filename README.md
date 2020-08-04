# venta

#### Ejecutar Proyecto
`mvn spring-boot:run`


#### Ingreso

Realizar un request Post `http://localhost:8080/login` con las siguientes credenciales

`{
    "username": "user",
    "password": "pass"
}`

#### Comunicación API

Se utilizó JWT para mantener la sesión por lo que al llamar al endpoint de ingreso
se obtendrá en el header un token de la siguiente forma

`eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTk2NDg1NjQ5fQ.F01mWc8F2keIsxve2tMiBlWv2OWH-mGEBL3pUeACA08HVa0zv0mmIDPCObh6XxnmwhU1xJdFdAoihNRDGkmH0g`

Para llamar a las api se debe agregar un header AUTH-TOKEN con el token obtenido 
al llamar al login (La sesión dura 30 min)

#### API VENTAS

- crear una venta
`http://localhost:8080/venta/crear`  <br>
- obtener ventas del día `http://localhost:8080/venta/hoy`

#### Swagger
`http://localhost:8080/swagger-ui.html`


by Rafael Sifontes