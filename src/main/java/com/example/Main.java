package com.example;

import com.example.repository.AcudienteRepository;
import com.example.repository.CoordinadorRepository;
import com.example.repository.CursoRepository;
import com.example.repository.DocenteRepository;
import com.example.repository.EstudianteRepository;
import com.example.repository.SesionAsistenciaRepository;

import com.example.util.JpaUtil;
import com.example.util.PdfExporter;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static EntityManager em;
    private static AcudienteRepository acudienteRepo;
    private static CoordinadorRepository coordinadorRepo;
    private static CursoRepository cursoRepo;
    private static DocenteRepository docenteRepo;
    private static EstudianteRepository estudianteRepo;
    private static SesionAsistenciaRepository sesionRepo;

    public static void main(String[] args) {
        em = JpaUtil.getEntityManager();
        acudienteRepo = new AcudienteRepository(em);
        coordinadorRepo = new CoordinadorRepository(em);
        cursoRepo = new CursoRepository(em);
        docenteRepo = new DocenteRepository(em);
        estudianteRepo = new EstudianteRepository(em);
        sesionRepo = new SesionAsistenciaRepository(em);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Gestionar Acudientes");
            System.out.println("2. Gestionar Coordinadores");
            System.out.println("3. Gestionar Cursos");
            System.out.println("4. Gestionar Docentes");
            System.out.println("5. Gestionar Estudiantes");
            System.out.println("6. Gestionar Sesiones de Asistencia");
            System.out.println("7. Exportar a PDF");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> menuAcudientes();
                case 2 -> menuCoordinadores();
                case 3 -> menuCursos();
                case 4 -> menuDocentes();
                case 5 -> menuEstudiantes();
                case 6 -> menuSesiones();
                case 7 -> menuExportarPDF();
                case 0 -> exit = true;
                default -> System.out.println("Opción no válida.");
            }
        }
        JpaUtil.close();
        System.out.println("Saliendo...");
    }

    // ─────────────────────────────────────────────
    // ACUDIENTES
    // ─────────────────────────────────────────────
    private static void menuAcudientes() {
        System.out.println("\n--- GESTIÓN DE ACUDIENTES ---");
        System.out.println("1. Crear");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.print("Opción: ");
        int opt = scanner.nextInt();
        scanner.nextLine();

        switch (opt) {
            case 1 -> {
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Teléfono: ");
                String telefono = scanner.nextLine();
                System.out.print("Parentesco: ");
                String parentesco = scanner.nextLine();
                System.out.print("Email: ");
                acudienteRepo.save(new Acudiente(nombre, telefono, parentesco));
                System.out.println("Acudiente guardado.");
            }
            case 2 -> acudienteRepo.findAll().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID a actualizar: ");
                long id = scanner.nextLong();
                scanner.nextLine();
                acudienteRepo.findById(id).ifPresentOrElse(a -> {
                    System.out.print("Nuevo nombre: ");
                    a.setName(scanner.nextLine());
                    System.out.print("Nuevo teléfono: ");
                    a.setTelefono(scanner.nextLine());
                    System.out.print("Nuevo parentesco: ");
                    a.setParentesco(scanner.nextLine());
                    System.out.print("Nuevo email: ");
                    a.setEmail(scanner.nextLine());
                    acudienteRepo.update(a);
                    System.out.println("Acudiente actualizado.");
                }, () -> System.out.println("No encontrado."));
            }
            case 4 -> {
                System.out.print("ID a eliminar: ");
                long id = scanner.nextLong();
                acudienteRepo.findById(id).ifPresentOrElse(a -> {
                    acudienteRepo.delete(a);
                    System.out.println("Acudiente eliminado.");
                }, () -> System.out.println("No encontrado."));
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    // ─────────────────────────────────────────────
    // COORDINADORES
    // ─────────────────────────────────────────────
    private static void menuCoordinadores() {
        System.out.println("\n--- GESTIÓN DE COORDINADORES ---");
        System.out.println("1. Crear");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.print("Opción: ");
        int opt = scanner.nextInt();
        scanner.nextLine();

        switch (opt) {
            case 1 -> {
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Teléfono: ");
                String telefono = scanner.nextLine();
                System.out.print("Área a cargo: ");
                String area = scanner.nextLine();
                coordinadorRepo.save(new Coordinador(nombre, email, telefono, area));
                System.out.println("Coordinador guardado.");
            }
            case 2 -> coordinadorRepo.findAll().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID a actualizar: ");
                long id = scanner.nextLong();
                scanner.nextLine();
                coordinadorRepo.findById(id).ifPresentOrElse(c -> {
                    System.out.print("Nuevo nombre: ");
                    c.setName(scanner.nextLine());
                    System.out.print("Nuevo email: ");
                    c.setEmail(scanner.nextLine());
                    System.out.print("Nuevo teléfono: ");
                    c.setTelefono(scanner.nextLine());
                    System.out.print("Nueva área a cargo: ");
                    c.setArea(scanner.nextLine());
                    coordinadorRepo.update(c);
                    System.out.println("Coordinador actualizado.");
                }, () -> System.out.println("No encontrado."));
            }
            case 4 -> {
                System.out.print("ID a eliminar: ");
                long id = scanner.nextLong();
                coordinadorRepo.findById(id).ifPresentOrElse(c -> {
                    coordinadorRepo.delete(c);
                    System.out.println("Coordinador eliminado.");
                }, () -> System.out.println("No encontrado."));
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    // ─────────────────────────────────────────────
    // CURSOS
    // ─────────────────────────────────────────────
    private static void menuCursos() {
        System.out.println("\n--- GESTIÓN DE CURSOS ---");
        System.out.println("1. Crear");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.print("Opción: ");
        int opt = scanner.nextInt();
        scanner.nextLine();

        switch (opt) {
            case 1 -> {
                System.out.print("Nombre del curso: ");
                String nombre = scanner.nextLine();
                System.out.print("Grado: ");
                String grado = scanner.nextLine();
                System.out.print("Jornada (Mañana/Tarde): ");
                String jornada = scanner.nextLine();
                System.out.print("Capacidad máxima: ");
                int capacidad = scanner.nextInt();
                scanner.nextLine();
                cursoRepo.save(new Curso(nombre, grado, jornada, capacidad));
                System.out.println("Curso guardado.");
            }
            case 2 -> cursoRepo.findAll().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID a actualizar: ");
                long id = scanner.nextLong();
                scanner.nextLine();
                cursoRepo.findById(id).ifPresentOrElse(c -> {
                    System.out.print("Nuevo nombre: ");
                    c.setName(scanner.nextLine());
                    System.out.print("Nuevo grado: ");
                    c.setGrado(scanner.nextLine());
                    System.out.print("Nueva jornada: ");
                    c.setJornada(scanner.nextLine());
                    System.out.print("Nueva capacidad: ");
                    c.setCapacidad(scanner.nextInt());
                    scanner.nextLine();
                    cursoRepo.update(c);
                    System.out.println("Curso actualizado.");
                }, () -> System.out.println("No encontrado."));
            }
            case 4 -> {
                System.out.print("ID a eliminar: ");
                long id = scanner.nextLong();
                cursoRepo.findById(id).ifPresentOrElse(c -> {
                    cursoRepo.delete(c);
                    System.out.println("Curso eliminado.");
                }, () -> System.out.println("No encontrado."));
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    // ─────────────────────────────────────────────
    // DOCENTES
    // ─────────────────────────────────────────────
    private static void menuDocentes() {
        System.out.println("\n--- GESTIÓN DE DOCENTES ---");
        System.out.println("1. Crear");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.print("Opción: ");
        int opt = scanner.nextInt();
        scanner.nextLine();

        switch (opt) {
            case 1 -> {
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Teléfono: ");
                String telefono = scanner.nextLine();
                System.out.print("Especialidad: ");
                docenteRepo.save(new Docente(nombre, email, telefono));
                System.out.println("Docente guardado.");
            }
            case 2 -> docenteRepo.findAll().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID a actualizar: ");
                long id = scanner.nextLong();
                scanner.nextLine();
                docenteRepo.findById(id).ifPresentOrElse(d -> {
                    System.out.print("Nuevo nombre: ");
                    d.setName(scanner.nextLine());
                    System.out.print("Nuevo email: ");
                    d.setEmail(scanner.nextLine());
                    System.out.print("Nuevo teléfono: ");
                    d.setTelefono(scanner.nextLine());
                    System.out.print("Nueva especialidad: ");
                    d.setEspecialidad(scanner.nextLine());
                    docenteRepo.update(d);
                    System.out.println("Docente actualizado.");
                }, () -> System.out.println("No encontrado."));
            }
            case 4 -> {
                System.out.print("ID a eliminar: ");
                long id = scanner.nextLong();
                docenteRepo.findById(id).ifPresentOrElse(d -> {
                    docenteRepo.delete(d);
                    System.out.println("Docente eliminado.");
                }, () -> System.out.println("No encontrado."));
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    // ─────────────────────────────────────────────
    // ESTUDIANTES
    // ─────────────────────────────────────────────
    private static void menuEstudiantes() {
        System.out.println("\n--- GESTIÓN DE ESTUDIANTES ---");
        System.out.println("1. Crear");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.print("Opción: ");
        int opt = scanner.nextInt();
        scanner.nextLine();

        switch (opt) {
            case 1 -> {
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
                System.out.print("ID del curso: ");
                long cursoId = scanner.nextLong();
                scanner.nextLine();
                System.out.print("ID del acudiente: ");
                long acudienteId = scanner.nextLong();
                scanner.nextLine();

                Optional<Curso> curso = cursoRepo.findById(cursoId);
                Optional<Acudiente> acudiente = acudienteRepo.findById(acudienteId);

                if (curso.isEmpty()) {
                    System.out.println("Curso no encontrado.");
                    return;
                }
                if (acudiente.isEmpty()) {
                    System.out.println("Acudiente no encontrado.");
                    return;
                }

                estudianteRepo.save(new Estudiante(nombre, fechaNacimiento, curso.get(), acudiente.get()));
                System.out.println("Estudiante guardado.");
            }
            case 2 -> estudianteRepo.findAll().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID a actualizar: ");
                long id = scanner.nextLong();
                scanner.nextLine();
                estudianteRepo.findById(id).ifPresentOrElse(e -> {
                    System.out.print("Nuevo nombre: ");
                    e.setName(scanner.nextLine());
                    System.out.print("Nueva fecha de nacimiento (YYYY-MM-DD): ");
                    e.setFechaNacimiento(LocalDate.parse(scanner.nextLine()));
                    System.out.print("Nuevo ID de curso: ");
                    long cId = scanner.nextLong();
                    scanner.nextLine();
                    cursoRepo.findById(cId).ifPresentOrElse(curso -> e.setCurso(curso),
                            () -> System.out.println("Curso no encontrado, se mantiene el anterior."));
                    estudianteRepo.update(e);
                    System.out.println("Estudiante actualizado.");
                }, () -> System.out.println("No encontrado."));
            }
            case 4 -> {
                System.out.print("ID a eliminar: ");
                long id = scanner.nextLong();
                estudianteRepo.findById(id).ifPresentOrElse(e -> {
                    estudianteRepo.delete(e);
                    System.out.println("Estudiante eliminado.");
                }, () -> System.out.println("No encontrado."));
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    // ─────────────────────────────────────────────
    // SESIONES DE ASISTENCIA
    // ─────────────────────────────────────────────
    /**
     * 
     */
    private static void menuSesiones() {
        System.out.println("\n--- GESTIÓN DE SESIONES DE ASISTENCIA ---");
        System.out.println("1. Crear");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.print("Opción: ");
        int opt = scanner.nextInt();
        scanner.nextLine();

        switch (opt) {
            case 1 -> {
                System.out.print("Fecha (YYYY-MM-DD): ");
                LocalDate fecha = LocalDate.parse(scanner.nextLine());
                System.out.print("ID del curso: ");
                long cursoId = scanner.nextLong();
                scanner.nextLine();
                System.out.print("ID del docente: ");
                long docenteId = scanner.nextLong();
                scanner.nextLine();
                System.out.print("Observaciones: ");
                String obs = scanner.nextLine();

                Optional<Curso> curso = cursoRepo.findById(cursoId);
                Optional<Docente> docente = docenteRepo.findById(docenteId);

                if (curso.isEmpty()) {
                    System.out.println("Curso no encontrado.");
                    return;
                }
                if (docente.isEmpty()) {
                    System.out.println("Docente no encontrado.");
                    return;
                }

                SesionAsistencia sesion = new SesionAsistencia();
                sesion.setFecha(fecha);
                sesion.setCurso(curso.get());
                sesion.setDocente(docente.get());
                sesion.setObservaciones(obs);
                sesionRepo.save(sesion);
                System.out.println("Sesión de asistencia guardada.");
            }
            case 2 -> sesionRepo.findAll().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID a actualizar: ");
                long id = scanner.nextLong();
                scanner.nextLine();
                sesionRepo.findById(id).ifPresentOrElse(s -> {
                    System.out.print("Nueva fecha (YYYY-MM-DD): ");
                    s.setFecha(LocalDate.parse(scanner.nextLine()));
                    System.out.print("Nuevo ID de docente: ");
                    long dId = scanner.nextLong();
                    scanner.nextLine();
                    docenteRepo.findById(dId).ifPresentOrElse(docente -> s.setDocente(docente),
                            () -> System.out.println("Docente no encontrado, se mantiene el anterior."));
                    System.out.print("Nuevas observaciones: ");
                    s.setObservaciones(scanner.nextLine());
                    sesionRepo.update(s);
                    System.out.println("Sesión actualizada.");
                }, () -> System.out.println("No encontrado."));
            }
            case 4 -> {
                System.out.print("ID a eliminar: ");
                long id = scanner.nextLong();
                sesionRepo.findById(id).ifPresentOrElse(s -> {
                    sesionRepo.delete(s);
                    System.out.println("Sesión eliminada.");
                }, () -> System.out.println("No encontrado."));
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    // ─────────────────────────────────────────────
    // EXPORTAR A PDF
    // ─────────────────────────────────────────────
    private static void menuExportarPDF() {
        System.out.println("\n--- EXPORTAR A PDF ---");
        System.out.println("1. Exportar Estudiantes");
        System.out.println("2. Exportar Cursos");
        System.out.println("3. Exportar Docentes");
        System.out.println("4. Exportar Acudientes");
        System.out.println("5. Exportar Sesiones de Asistencia");
        System.out.println("6. Exportar Coordinadores");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        int opt = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (opt) {
                case 1 -> {
                    System.out.print("Nombre del archivo (sin .pdf): ");
                    String archivo = scanner.nextLine().trim();
                    if (archivo.isEmpty()) archivo = "reporte_estudiantes";
                    PdfExporter.exportarEstudiantes(estudianteRepo.findAll(), archivo + ".pdf");
                }
                case 2 -> {
                    System.out.print("Nombre del archivo (sin .pdf): ");
                    String archivo = scanner.nextLine().trim();
                    if (archivo.isEmpty()) archivo = "reporte_cursos";
                    PdfExporter.exportarCursos(cursoRepo.findAll(), archivo + ".pdf");
                }
                case 3 -> {
                    System.out.print("Nombre del archivo (sin .pdf): ");
                    String archivo = scanner.nextLine().trim();
                    if (archivo.isEmpty()) archivo = "reporte_docentes";
                    PdfExporter.exportarDocentes(docenteRepo.findAll(), archivo + ".pdf");
                }
                case 4 -> {
                    System.out.print("Nombre del archivo (sin .pdf): ");
                    String archivo = scanner.nextLine().trim();
                    if (archivo.isEmpty()) archivo = "reporte_acudientes";
                    PdfExporter.exportarAcudientes(acudienteRepo.findAll(), archivo + ".pdf");
                }
                case 5 -> {
                    System.out.print("Nombre del archivo (sin .pdf): ");
                    String archivo = scanner.nextLine().trim();
                    if (archivo.isEmpty()) archivo = "reporte_sesiones";
                    PdfExporter.exportarSesiones(sesionRepo.findAll(), archivo + ".pdf");
                }
                case 6 -> {
                    System.out.print("Nombre del archivo (sin .pdf): ");
                    String archivo = scanner.nextLine().trim();
                    if (archivo.isEmpty()) archivo = "reporte_coordinadores";
                    PdfExporter.exportarCoordinadores(coordinadorRepo.findAll(), archivo + ".pdf");
                }
                case 0 -> {}
                default -> System.out.println("Opción no válida.");
            }
        } catch (Exception e) {
            System.out.println("Error al exportar a PDF: " + e.getMessage());
        }
    }
}