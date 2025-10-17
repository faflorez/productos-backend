### Productos Backend — Spring Boot

Este proyecto es una **API REST** desarrollada con **Spring Boot**, conectada a una base de datos **MySQL**, que permite gestionar productos (crear, listar, actualizar y eliminar).

---

## #Tecnologías usadas

- **Java 17**
- **Spring Boot 3.5.6**
  - Spring Web
  - Spring Data JPA
- **MySQL 8**
- **Gradle / Maven**
- **HikariCP** (conexión a base de datos)
- **CORS Configuration (WebConfig)** para conexión con frontend en React

---

## Configuración del entorno

### Base de datos MySQL

Crea la base de datos:

### sql
CREATE DATABASE productosdb;
Credenciales por defecto (en application.properties):

spring.datasource.url=jdbc:mysql://localhost:3306/productosdb
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8081

### Ejecución del proyecto

En IntelliJ IDEA o terminal:

./gradlew bootRun

o

./mvnw spring-boot:run

El servidor se ejecutará en:
http://localhost:8080

### Endpoints disponibles
Método	Endpoint	Descripción
GET	/productos/	Lista todos los productos
POST	/productos/	Crea un nuevo producto
PUT	/productos/{id}	Actualiza un producto existente
DELETE	/productos/{id}	Elimina un producto por ID

Ejemplo de JSON:

{
  "nombre": "Café",
  "precio": 4500,
  "cantidad": 10
}

### Configuración de CORS

Se habilitó una configuración global para permitir la comunicación con el frontend (React en puerto 3000):

@CrossOrigin(origins = "http://localhost:3000")

o mediante la clase WebConfig.java:

registry.addMapping("/**")
        .allowedOrigins("http://localhost:3000")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*")
        .allowCredentials(true);

### Conexión con Frontend

Frontend desarrollado con React (en carpeta productos-frontend).

La API debe estar ejecutándose antes de iniciar el frontend:

npm start

URL de conexión en React:

http://localhost:8080/productos/

### Autor

Fabian Alexander Florez Salamanca
Desarrollado como parte de una prueba técnica en Spring Boot.
