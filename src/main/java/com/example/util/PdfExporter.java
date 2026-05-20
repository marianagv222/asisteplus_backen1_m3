package com.example.util;

import com.example.*;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

public class PdfExporter {

    /**
     * Exporta una lista de estudiantes a PDF
     */
    public static void exportarEstudiantes(List<Estudiante> estudiantes, String nombreArchivo) throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(nombreArchivo);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Título
        document.add(new Paragraph("REPORTE DE ESTUDIANTES")
                .setFontSize(18)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER));
        document.add(new Paragraph("Fecha: " + LocalDate.now())
                .setTextAlignment(TextAlignment.CENTER));
        document.add(new Paragraph("\n"));

        // Tabla
        Table table = new Table(new float[]{1, 2, 2, 2, 2});
        table.setWidth(UnitValue.createPercentValue(100));

        // Encabezados
        agregarhEncabezado(table, "ID");
        agregarhEncabezado(table, "Nombre");
        agregarhEncabezado(table, "Fecha de Nacimiento");
        agregarhEncabezado(table, "Curso");
        agregarhEncabezado(table, "Acudiente");

        // Filas de datos
        for (Estudiante est : estudiantes) {
            table.addCell(String.valueOf(est.getId()));
            table.addCell(est.getName());
            table.addCell(est.getFechaNacimiento().toString());
            table.addCell(est.getCurso() != null ? est.getCurso().getName() : "N/A");
            table.addCell(est.getAcudiente() != null ? est.getAcudiente().getName() : "N/A");
        }

        document.add(table);
        document.close();
        System.out.println("✓ PDF de estudiantes generado: " + nombreArchivo);
    }

    /**
     * Exporta una lista de cursos a PDF
     */
    public static void exportarCursos(List<Curso> cursos, String nombreArchivo) throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(nombreArchivo);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Título
        document.add(new Paragraph("REPORTE DE CURSOS")
                .setFontSize(18)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER));
        document.add(new Paragraph("Fecha: " + LocalDate.now())
                .setTextAlignment(TextAlignment.CENTER));
        document.add(new Paragraph("\n"));

        // Tabla
        Table table = new Table(new float[]{1, 2, 1.5f, 1.5f, 1.5f});
        table.setWidth(UnitValue.createPercentValue(100));

        // Encabezados
        agregarhEncabezado(table, "ID");
        agregarhEncabezado(table, "Nombre");
        agregarhEncabezado(table, "Grado");
        agregarhEncabezado(table, "Jornada");
        agregarhEncabezado(table, "Capacidad");

        // Filas de datos
        for (Curso curso : cursos) {
            table.addCell(String.valueOf(curso.getId()));
            table.addCell(curso.getName());
            table.addCell(curso.getGrado());
            table.addCell(curso.getJornada());
            table.addCell(String.valueOf(curso.getCapacidad()));
        }

        document.add(table);
        document.close();
        System.out.println("✓ PDF de cursos generado: " + nombreArchivo);
    }

    /**
     * Exporta una lista de docentes a PDF
     */
    public static void exportarDocentes(List<Docente> docentes, String nombreArchivo) throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(nombreArchivo);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Título
        document.add(new Paragraph("REPORTE DE DOCENTES")
                .setFontSize(18)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER));
        document.add(new Paragraph("Fecha: " + LocalDate.now())
                .setTextAlignment(TextAlignment.CENTER));
        document.add(new Paragraph("\n"));

        // Tabla
        Table table = new Table(new float[]{1, 2, 2, 2});
        table.setWidth(UnitValue.createPercentValue(100));

        // Encabezados
        agregarhEncabezado(table, "ID");
        agregarhEncabezado(table, "Nombre");
        agregarhEncabezado(table, "Especialidad");
        agregarhEncabezado(table, "Teléfono");

        // Filas de datos
        for (Docente doc : docentes) {
            table.addCell(String.valueOf(doc.getId()));
            table.addCell(doc.getName());
            table.addCell(doc.getEspecialidad());
            table.addCell(doc.getTelefono());
        }

        document.add(table);
        document.close();
        System.out.println("✓ PDF de docentes generado: " + nombreArchivo);
    }

    /**
     * Exporta una lista de acudientes a PDF
     */
    public static void exportarAcudientes(List<Acudiente> acudientes, String nombreArchivo) throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(nombreArchivo);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Título
        document.add(new Paragraph("REPORTE DE ACUDIENTES")
                .setFontSize(18)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER));
        document.add(new Paragraph("Fecha: " + LocalDate.now())
                .setTextAlignment(TextAlignment.CENTER));
        document.add(new Paragraph("\n"));

        // Tabla
        Table table = new Table(new float[]{1, 2, 2, 2, 2});
        table.setWidth(UnitValue.createPercentValue(100));

        // Encabezados
        agregarhEncabezado(table, "ID");
        agregarhEncabezado(table, "Nombre");
        agregarhEncabezado(table, "Teléfono");
        agregarhEncabezado(table, "Parentesco");
        agregarhEncabezado(table, "Email");

        // Filas de datos
        for (Acudiente acu : acudientes) {
            table.addCell(String.valueOf(acu.getId()));
            table.addCell(acu.getName());
            table.addCell(acu.getTelefono());
            table.addCell(acu.getParentesco());
            table.addCell(acu.getEmail() != null ? acu.getEmail() : "N/A");
        }

        document.add(table);
        document.close();
        System.out.println("✓ PDF de acudientes generado: " + nombreArchivo);
    }

    /**
     * Exporta una lista de sesiones de asistencia a PDF
     */
    public static void exportarSesiones(List<SesionAsistencia> sesiones, String nombreArchivo) throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(nombreArchivo);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Título
        document.add(new Paragraph("REPORTE DE SESIONES DE ASISTENCIA")
                .setFontSize(18)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER));
        document.add(new Paragraph("Fecha: " + LocalDate.now())
                .setTextAlignment(TextAlignment.CENTER));
        document.add(new Paragraph("\n"));

        // Tabla
        Table table = new Table(new float[]{1, 2, 2, 2, 3});
        table.setWidth(UnitValue.createPercentValue(100));

        // Encabezados
        agregarhEncabezado(table, "ID");
        agregarhEncabezado(table, "Fecha");
        agregarhEncabezado(table, "Curso");
        agregarhEncabezado(table, "Docente");
        agregarhEncabezado(table, "Observaciones");

        // Filas de datos
        for (SesionAsistencia ses : sesiones) {
            table.addCell(String.valueOf(ses.getId()));
            table.addCell(ses.getFecha().toString());
            table.addCell(ses.getCurso() != null ? ses.getCurso().getName() : "N/A");
            table.addCell(ses.getDocente() != null ? ses.getDocente().getName() : "N/A");
            table.addCell(ses.getObservaciones() != null ? ses.getObservaciones() : "");
        }

        document.add(table);
        document.close();
        System.out.println("✓ PDF de sesiones generado: " + nombreArchivo);
    }

    /**
     * Exporta una lista de coordinadores a PDF
     */
    public static void exportarCoordinadores(List<Coordinador> coordinadores, String nombreArchivo) throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(nombreArchivo);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Título
        document.add(new Paragraph("REPORTE DE COORDINADORES")
                .setFontSize(18)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER));
        document.add(new Paragraph("Fecha: " + LocalDate.now())
                .setTextAlignment(TextAlignment.CENTER));
        document.add(new Paragraph("\n"));

        // Tabla
        Table table = new Table(new float[]{1, 2, 2, 2});
        table.setWidth(UnitValue.createPercentValue(100));

        // Encabezados
        agregarhEncabezado(table, "ID");
        agregarhEncabezado(table, "Nombre");
        agregarhEncabezado(table, "Área");
        agregarhEncabezado(table, "Teléfono");

        // Filas de datos
        for (Coordinador coord : coordinadores) {
            table.addCell(String.valueOf(coord.getId()));
            table.addCell(coord.getName());
            table.addCell(coord.getArea());
            table.addCell(coord.getTelefono());
        }

        document.add(table);
        document.close();
        System.out.println("✓ PDF de coordinadores generado: " + nombreArchivo);
    }

    /**
     * Método auxiliar para agregar encabezados a la tabla
     */
    private static void agregarhEncabezado(Table table, String texto) {
        table.addCell(new Paragraph(texto)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER));
    }
}
