# *Api Rest CRUD básico utilizando Spring Boot y MySQL*

Basic CRUD Rest API using Spring Boot, Mysql, JPA and Hibernate.

## Steps to Setup


**1. Clone the application**

```bash
https://github.com/HugoStevenPoveda/ApiMascota.git
```
**2. Create Mysql database**
```bash
CREATE DATABASE mascota
```
Ejecutar la siguiente sentencia SQL
```bash
INSERT INTO mascotas(nombre,edad,descripcion) VALUES 
("missi",45,"gata blanca"),
("pepe",5,"perro blanca"),
("lalo",25,"loro verde"),
("titin",15,"gallo blanca"),
("blanquito",55,"iguana ");

```  

**3.Database connection configuration MySQL**
+ open  ApiMascota/src/main/resources/application.properties
+ change `spring.datasource.username` and `spring.datasource.password`

**4.Run with Spring Tool Suite**

![Run](/imageREADME/run.JPG)

The app will start running at <http://localhost:8080>


**5.Enter the following URL**
<http://localhost:8080/swagger-ui.html>
you can see the API documentation thanks to Swagger.

**Entidad**
![mascota](/imageREADME/mascota.JPG)

## Explore Rest APIs

The app defines following CRUD APIs.

### Mascota

| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| GET  | /mascota| Return all pets| [JSON](#signup) |
| GET  | /mascota/{id}| Return pet for by id | [JSON](#signup) |
| POST   | /mascota | Create new pet| [JSON](#signin) |
| PUT  | /mascota/{id}| if the pet exists then update| [JSON](#signup) |
| DELETE   | /mascota/{id}|  if the pet exists then delete| String |


![Swagger](/imageREADME/rest.JPG)