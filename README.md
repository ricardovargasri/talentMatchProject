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

### Autenticación

- Registro de usuario nuevo
- Login de usuario existente

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
