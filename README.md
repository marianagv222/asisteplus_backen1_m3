# AsistePlus — Backend Módulo 3

Sistema de gestión de asistencia escolar desarrollado en Java. Permite administrar estudiantes, docentes, cursos, acudientes, coordinadores y sesiones de asistencia, con soporte para exportar reportes en PDF.

## Tecnologías utilizadas

- **Java 21**
- **Hibernate 6 (JPA)** — mapeo objeto-relacional
- **PostgreSQL** — base de datos relacional
- **iText 8** — generación de reportes PDF
- **Maven** — gestión de dependencias

## Estructura del proyecto

```
src/main/java/com/example/
├── Acudiente.java
├── Coordinador.java
├── Curso.java
├── Docente.java
├── Estudiante.java
├── SesionAsistencia.java
├── Main.java
├── repository/          # Repositorios para acceso a datos (CRUD)
└── util/
    ├── JpaUtil.java     # Configuración del EntityManager
    └── PdfExporter.java # Exportación a PDF
```

## Funcionalidades

La aplicación corre en consola y ofrece un menú principal con las siguientes opciones:

1. **Gestionar Acudientes** — crear, listar, actualizar y eliminar acudientes
2. **Gestionar Coordinadores** — CRUD de coordinadores
3. **Gestionar Cursos** — CRUD de cursos (nombre, grado, jornada, capacidad)
4. **Gestionar Docentes** — CRUD de docentes
5. **Gestionar Estudiantes** — CRUD de estudiantes, asociados a curso y acudiente
6. **Gestionar Sesiones de Asistencia** — registrar sesiones vinculadas a curso y docente
7. **Exportar a PDF** — generar reportes de cualquier entidad en formato PDF



## Grupo de trabajo

Karina Arboleda Garcia,
Emmanuel Quintero ,
Manuela Bermudez,
Cindy Mariana Gil Velez