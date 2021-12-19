
## Properties

---

- @Controller: Cuando hay solicitudes entrantes
  - @RestMapping: Para enrutamientos
  - @RestController: Para devolver elementos, subtipo de @Controller
- JpaRepository esta vacio porque es una interfaz, se pueden especificar las
cosas que queramos, pero por defecto tiene todos los metodos de JpaRepository, como findAll,
findbyId, etc.
- Para acceder con MySql en resources->application.properties:
```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/{schemaName}
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  ```
-