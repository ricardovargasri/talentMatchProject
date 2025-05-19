# TalentVistas - Sistema de Gestión de Usuarios

## Descripción

TalentVistas es un sistema de autenticación y gestión de usuarios desarrollado con Spring Boot, que proporciona funcionalidades seguras de registro y autenticación de usuarios utilizando JWT (JSON Web Tokens).

## Características Principales

- Registro de usuarios
- Autenticación mediante JWT
- Encriptación segura de contraseñas
- Validación de correos electrónicos únicos
- Gestión de sesiones de usuario

## Tecnologías Utilizadas

- Java con Spring Boot
- Spring Security
- JWT para autenticación
- Base de datos (JPA/Hibernate)
- Lombok para reducción de código boilerplate

## Estructura del Proyecto

El proyecto sigue una arquitectura en capas:

- `model`: Entidades del dominio
- `dto`: Objetos de transferencia de datos
- `repository`: Capa de acceso a datos
- `service`: Lógica de negocio
- `security`: Configuración de seguridad y JWT

## Endpoints Principales

### Endpoints de Autenticación (`/api/auth`)

#### Registro de Usuario

- **URL**: `/api/auth/register`
- **Método**: POST
- **Descripción**: Registra un nuevo usuario en el sistema
- **Cuerpo de la solicitud**:
  ```json
  {
    "email": "usuario@ejemplo.com",
    "password": "contraseña",
    "nombre": "Nombre Usuario",
    "apellido": "Apellido Usuario"
  }
  ```
- **Respuesta**: Token JWT de autenticación
- **Autenticación**: No requiere token

#### Inicio de Sesión

- **URL**: `/api/auth/login`
- **Método**: POST
- **Descripción**: Autentica a un usuario y genera un token JWT
- **Cuerpo de la solicitud**:
  ```json
  {
    "email": "usuario@ejemplo.com",
    "password": "contraseña"
  }
  ```
- **Respuesta**: Token JWT de autenticación
- **Autenticación**: No requiere token

### Endpoints de Ideas (`/api/ideas`)

#### Crear Idea

- **URL**: `/api/ideas`
- **Método**: POST
- **Descripción**: Crea una nueva idea en el sistema
- **Autenticación**: Requiere token JWT
- **Cuerpo de la solicitud**:
  ```json
  {
    "titulo": "Título de la idea",
    "descripcion": "Descripción detallada",
    "categoria": "CATEGORIA",
    "estado": "ESTADO"
  }
  ```

#### Obtener Todas las Ideas

- **URL**: `/api/ideas`
- **Método**: GET
- **Descripción**: Obtiene la lista de todas las ideas
- **Autenticación**: No requiere token

#### Obtener Ideas por Creador

- **URL**: `/api/ideas/creator/{creatorId}`
- **Método**: GET
- **Descripción**: Obtiene todas las ideas creadas por un usuario específico
- **Parámetros**:
  - `creatorId`: ID del creador
- **Autenticación**: No requiere token

#### Obtener Idea por ID

- **URL**: `/api/ideas/{ideaId}`
- **Método**: GET
- **Descripción**: Obtiene los detalles de una idea específica
- **Parámetros**:
  - `ideaId`: ID de la idea
- **Autenticación**: No requiere token

#### Mostrar Interés en una Idea

- **URL**: `/api/ideas/{ideaId}/interest`
- **Método**: POST
- **Descripción**: Registra el interés de un usuario en una idea específica
- **Parámetros**:
  - `ideaId`: ID de la idea
- **Autenticación**: Requiere token JWT

#### Obtener Ideas por Categoría

- **URL**: `/api/ideas/category/{category}`
- **Método**: GET
- **Descripción**: Obtiene todas las ideas de una categoría específica
- **Parámetros**:
  - `category`: Categoría de las ideas
- **Autenticación**: No requiere token

#### Obtener Ideas por Estado

- **URL**: `/api/ideas/status/{status}`
- **Método**: GET
- **Descripción**: Obtiene todas las ideas con un estado específico
- **Parámetros**:
  - `status`: Estado de las ideas
- **Autenticación**: No requiere token

### Notas sobre Autenticación

- Los endpoints que requieren autenticación necesitan incluir el token JWT en el encabezado de la solicitud:
  ```
  Authorization: Bearer <token>
  ```
- Los endpoints públicos no requieren token de autenticación
- Las respuestas de error incluirán un mensaje descriptivo en español
- Todas las solicitudes y respuestas utilizan el formato JSON

## Requisitos del Sistema

- Java 11 o superior
- Maven para gestión de dependencias
- Base de datos compatible con JPA

## Configuración y Ejecución

1. Clonar el repositorio
2. Configurar las propiedades de la base de datos en `application.properties`
3. Ejecutar `mvn clean install`
4. Iniciar la aplicación con `mvn spring-boot:run`

## Seguridad

- Todas las contraseñas se almacenan encriptadas
- Autenticación basada en tokens JWT
- Validación de datos de entrada

## Contribución

Si deseas contribuir al proyecto, por favor:

1. Haz un fork del repositorio
2. Crea una rama para tu feature
3. Envía un pull request

## Licencia

Este proyecto está bajo la Licencia MIT.

## Contacto

Para más información o reportar problemas, por favor crear un issue en el repositorio.
