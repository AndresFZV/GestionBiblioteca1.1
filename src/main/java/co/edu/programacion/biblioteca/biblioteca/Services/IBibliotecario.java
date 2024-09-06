package co.edu.programacion.biblioteca.biblioteca.Services;

import co.edu.programacion.biblioteca.biblioteca.Model.*;

import java.time.LocalDate;

public interface IBibliotecario {
    void gestionarPrestamo();
    void eliminarLibro(Libro libro);
    void registrarDevolucion(Libro libro, Miembro miembro);
    void registrarMulta(Prestamo prestamo, LocalDate fechaLimite);
}

