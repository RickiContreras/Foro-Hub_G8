# Foro Hub_G8 API 🚀
¡Bienvenido al repositorio de la API REST del proyecto Foro Hub!

Este proyecto es una API de backend construida con Spring Boot que simula un foro de preguntas y respuestas. Permite a los usuarios crear, leer, actualizar y eliminar tópicos, con una capa de seguridad robusta para proteger la información.

🌟 Características Principales
- **API RESTful**: Endpoints bien definidos y organizados para la gestión de tópicos.
- **CRUD de Tópicos**: Funcionalidades completas para la creación, lectura, actualización y eliminación de tópicos.
- **Validación de Negocio**: Asegura la integridad de los datos, evitando el registro de tópicos duplicados y campos vacíos.
- **Seguridad con JWT**: Implementa un sistema de autenticación y autorización utilizando JSON Web Tokens (JWT) para proteger los endpoints.
- **Persistencia de Datos**: Utiliza MySQL para la base de datos y Flyway para la gestión de migraciones del esquema.

🛠️ Tecnologías Utilizadas
- Java 17
- Spring Boot 3.5.4
- Spring Data JPA
- Spring Security
- MySQL
- Flyway
- Lombok
- Auth0 JWT

🚦 Prerrequisitos
Para poder ejecutar este proyecto en tu entorno local, necesitas tener instalado:
- JDK 17 o superior
- Maven
- MySQL
- Un cliente de base de datos como MySQL Workbench
- Una herramienta para probar APIs como Insomnia o Postman

🚀 Configuración y Ejecución
Sigue estos pasos para configurar y ejecutar la API en tu máquina.

### Paso 1: Clonar el Repositorio
Clona este repositorio en tu máquina local.

```bash
https://github.com/RickiContreras/Foro-Hub_G8.git
```

### Paso 2: Configurar la Base de Datos
Abre tu cliente de base de datos (por ejemplo, MySQL Workbench).  
Inicia sesión en tu servidor MySQL.  
Ejecuta el siguiente comando para crear la base de datos que usará la aplicación.

```sql
CREATE DATABASE `foro-hub`;
```

Flyway se encargará de crear las tablas **topicos** y **usuarios** automáticamente cuando se ejecute la aplicación por primera vez.

### Paso 3: Insertar un Usuario de Prueba
Para poder autenticarte y probar la API, necesitas un usuario en la base de datos.  
Ejecuta el siguiente comando para insertar un usuario con la contraseña `123456` (ya encriptada con BCrypt).

```sql
USE `foro-hub`;
INSERT INTO `usuarios` (`nombre`, `email`, `clave`) VALUES ('admin', 'admin@foro.hub', '$2a$10$vG.W1L5.B2F0G9.G12j9.F0vG.W1L5.B2F0G9.G12j9.F0');
```

### Paso 4: Configurar application.properties
Abre el archivo `src/main/resources/application.properties` y configura los detalles de tu base de datos.

```properties
spring.application.name=Foro-Hub_G8

spring.datasource.url=jdbc:mysql://localhost/foro-hub?createDatabaseIfNotExist=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=TU_CONTRASEÑA_MYSQL

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.cache.use_second_level_cache=false

spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration

server.error.include-stacktrace=never

api.security.secret=1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef
```

⚠️ Importante: Reemplaza `TU_CONTRASEÑA_MYSQL` con la contraseña de tu usuario root en MySQL.

### Paso 5: Ejecutar la Aplicación
Desde la terminal en el directorio raíz del proyecto, ejecuta el siguiente comando para iniciar la API:

```bash
./mvnw spring-boot:run
```

Si todo está configurado correctamente, verás el log de la aplicación indicando que se ha iniciado en el puerto 8080.

---

🌐 Endpoints de la API

| HTTP Method | URL             | Description |
|-------------|-----------------|-------------|
| **POST**    | /login          | Autentica un usuario y devuelve un token JWT. |
| **POST**    | /topicos        | Crea un nuevo tópico. (Requiere autenticación) |
| **GET**     | /topicos        | Lista todos los tópicos. (Requiere autenticación) |
| **GET**     | /topicos/{id}   | Muestra un tópico por su ID. (Requiere autenticación) |
| **PUT**     | /topicos/{id}   | Actualiza un tópico existente. (Requiere autenticación) |
| **DELETE**  | /topicos/{id}   | Elimina un tópico por su ID. (Requiere autenticación) |

---

🔑 Cómo Probar la API (con Insomnia)
Para probar la API, sigue este flujo de trabajo:

1. **Obtener un token**: Envía una solicitud POST a `http://localhost:8080/login` con el email y la clave del usuario de prueba. La respuesta será un objeto JSON con el token.
2. **Usar el token**: Para las demás solicitudes (CRUD de tópicos), ve a la pestaña **Auth**, selecciona **Bearer Token** y pega el token que obtuviste en el paso anterior.
3. **Enviar la petición**: Ahora puedes enviar las solicitudes a los endpoints de tópicos con el token en el encabezado `Authorization`.

---

✅ ¡Y listo! Ya puedes interactuar con todos los endpoints protegidos de la API.
