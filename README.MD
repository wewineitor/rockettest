# Test RocketCode

## 📝 Descripción del Proyecto

Este proyecto es un aplicativo web desarrollado utilizando Java 8 y Spring Boot MVC. El objetivo es proporcionar una plataforma sencilla y eficiente para la gestión de tareas.

## Características principales:

- **Java 8**: Lenguaje de programación base del proyecto. 
- **Spring Boot MVC**: Framework para el desarrollo de aplicaciones web. 
- **Maven**: Herramienta de gestión de proyectos que se utiliza para la construcción y administración de dependencias. 
- **Bootstrap**: Framework CSS para diseñar una interfaz de usuario responsiva y atractiva. 
- **MyBatis**: Herramienta de mapeo objeto-relacional (ORM) que facilita la interacción con bases de datos.
- **Pruebas Unitarias**: Se han agregado pruebas unitarias para validar la funcionalidad del aplicativo y asegurar que cada endpoint funcione correctamente.

## ⚡ Instalacion

La base de datos ya está alojada en mi dominio, por lo que no es necesario crear una instancia local para probar la aplicación. Sin embargo, si necesitas configurar una base de datos local, puedes crear la siguiente tabla:
```
CREATE TABLE tasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    initial_date DATE
);
```
Seguido de esto simplemente ejecutalo en tu id de preferencia

## 📌 Puntos importantes
- He agregado pruebas unitarias y he implementado todos los métodos necesarios para realizar un CRUD. Aunque no se solicitaron específicamente todas las funciones ni las pruebas, consideré que era una buena práctica incluirlas, ya que son fundamentales en el desarrollo de software de calidad.
- Para acceder a la aplicación en local, utiliza: http://localhost:8080/
- Para consultar la documentación de la API, dirígete a: http://localhost:8080/swagger-ui/index.html
- La interfaz del frontend se desarrolla utilizando Thymeleaf, elegida por su conveniencia y rapidez.
- Los tests están ubicados en la carpeta unit, que se encuentra dentro de la carpeta tests. Para ejecutarlos, simplemente selecciona el archivo que deseas probar en tu IDE preferido.

## 🛠️ Herramientas utilizadas

<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white">

<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">

<img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white">

<img src="https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white">

<img src="https://img.shields.io/badge/bootstrap-%238511FA.svg?style=for-the-badge&logo=bootstrap&logoColor=white">

## 👤 Autor

[<img src="https://avatars.githubusercontent.com/u/53845240?v=4" width=115><br><sub>Edwin Isaac Avila Garcia</sub>](https://github.com/wewineitor)

[<img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" width=115><br>](https://www.linkedin.com/in/edwinavilaga/)
