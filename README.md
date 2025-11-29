# APPLICATIONFULLSTACK_CRUD_WITH_JWT
Aplicación Full Stack con Angular y Spring Boot - Prueba Tecnica

 # Backend - Fullstack Test
 ## Requisitos- Java 17- Gradle- SQL Server
 ## Ejecutar
 1. Configurar `src/main/resources/application.properties` con credenciales y JWT secret
 2. `mvn clean package`
 3. `mvn spring-boot:run`
 ## Endpoints principales- POST /auth/login  -> { email, password }- POST /auth/register -> create user (for tests)- GET/api/products- POST /api/products- PUT /api/products/{id}- DELETE /api/products/{id