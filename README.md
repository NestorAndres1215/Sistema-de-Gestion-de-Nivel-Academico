# 🎓 Sistema de Gestión de Nivel Académico

Este proyecto es un sistema web desarrollado en **Java con Spring Boot** y **Thymeleaf**, que permite gestionar y visualizar el **nivel académico de los estudiantes**. Cuenta con funcionalidades como listado de promedios finales, filtrado por estado (aprobado o desaprobado), y un panel administrativo con métricas generales.

---

## 🧰 Tecnologías utilizadas

- **Java 17**: Lenguaje principal para la lógica del sistema.
- **Spring Boot 3.x**: Framework para crear aplicaciones web de manera rápida y estructurada.
- **Spring Web**: Para manejar controladores, rutas y peticiones HTTP.
- **Spring Data JPA**: Para interactuar con la base de datos utilizando entidades y repositorios.
- **Thymeleaf**: Motor de plantillas para generar HTML dinámico desde el backend.
- **MySQL**: Base de datos relacional para almacenar información académica y estudiantil.
- **CSS personalizado**: Estilos adaptados manualmente para lograr un diseño moderno y limpio.
- **JavaScript**: Usado para filtros dinámicos y mejora de la experiencia de usuario.
- **Font Awesome**: Biblioteca de íconos usada para mejorar la interfaz visual.
- **Apache POI (poi-ooxml)**: Librería utilizada para generar y exportar reportes en formato **Excel (.xlsx)**.

---

## 🎯 Funcionalidades principales

- 📋 Listado de niveles académicos con promedio final y estado (Aprobado o Desaprobado).
- 🔍 Filtro dinámico por estado usando JavaScript.
- 👨‍🎓 Visualización clara de la información del estudiante: nombre, apellido y DNI.
- 📊 Panel administrativo con datos clave:
  - Total de estudiantes registrados.
  - Total de notas registradas.
  - Promedio general de todos los estudiantes.
- 📁 Exportación de reportes en formato Excel.
- 💡 Interfaz visual atractiva, responsiva y fácil de usar.

---

## 📘 Curso de Inglés

Este módulo evalúa a los estudiantes en el área de **Inglés**, abarcando habilidades como:

- Comprensión lectora
- Escritura básica
- Comprensión auditiva
- Expresión oral

Las calificaciones se calculan a partir de tres notas principales, generando una **nota final promedio**.

### ✅ Criterios de Evaluación

- La **nota mínima aprobatoria es 13**.
- Si la nota final es menor a 13, el estado del estudiante será marcado como **Desaprobado**.

---

## 📊 Información del Dashboard

En el panel de administración se visualizan las siguientes métricas:

| Métrica              | Descripción                                        |
|----------------------|----------------------------------------------------|
| Total de Estudiantes | Número total de alumnos registrados.               |
| Notas Registradas    | Cantidad de promedios calculados por estudiante.   |
| Promedio General     | Promedio global de todas las notas finales.        |

---

## 🛠️ Cómo ejecutar el proyecto

1. Clona este repositorio.
2. Configura tu base de datos MySQL y actualiza los parámetros en `application.properties`.
3. Ejecuta el proyecto con tu IDE favorito o con `mvn spring-boot:run`.
4. Accede a la aplicación en `http://localhost:8080/dashboard`.

---

## 📁 Estructura base

- `/controller`: Controladores que manejan las peticiones web.
- `/service`: Servicios que contienen la lógica de negocio.
- `/model`: Entidades JPA que representan las tablas.
- `/repository`: Interfaces que interactúan con la base de datos.
- `/templates`: Archivos HTML Thymeleaf.
- `/static`: Recursos estáticos como JS, CSS, imágenes.

---

## 📌 Nota

Este sistema está diseñado para ser sencillo, extensible y educativo. Puedes adaptarlo para otros cursos, agregar autenticación, exportación de notas, etc.

---

## 🙋 Autor

Desarrollado por **[Nestor Andres ]** – Estudiante y desarrollador Full Stack.

