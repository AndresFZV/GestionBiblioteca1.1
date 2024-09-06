package co.edu.programacion.biblioteca.biblioteca.Model;

import co.edu.programacion.biblioteca.biblioteca.Factory.ModelFactory;
import co.edu.programacion.biblioteca.biblioteca.Services.*;

import java.time.LocalDate;
import java.time.Period;

public class Bibliotecario extends Empleado implements IBibliotecario, IGestionarInventario {

    public Bibliotecario(){
    }

    public Bibliotecario(String nombre, String idEmpleado) {
        super(nombre, idEmpleado);
    }

    @Override
    public String toString() {
        return "Bibliotecario{" +
                ", nombre='" + nombre + '\'' +
                ", idEmpleado='" + idEmpleado + '\'' +
                '}';
    }

    @Override
    public void gestionarPrestamo() {

    }

    @Override
    public void eliminarLibro(Libro libro) {
        if(ModelFactory.getInstance().getGestionBiblioteca().getListaLibros().contains(libro)){
            ModelFactory.getInstance().getGestionBiblioteca().getListaLibros().remove(libro);
            System.out.println("El libro: " + libro.getTitulo() + " ha sido eliminado");
        }else{
            System.out.println("El libro: " + libro.getTitulo() + " no se encuentra");
        }
    }

    @Override
    public void registrarDevolucion(Libro libro, Miembro miembro) {
        if (libro.getEstado().equalsIgnoreCase("Prestado")) {
            libro.setEstado("Disponible");
            // Eliminar el préstamo correspondiente
            Prestamo prestamoARemover = null;
            for (Prestamo prestamo : ModelFactory.getInstance().getGestionBiblioteca().getListaPrestamo()) {
                if (prestamo.getLibro().equals(libro) && prestamo.getMiembro().equals(miembro)) {
                    prestamoARemover = prestamo;
                    break;
                }
            }
            if (prestamoARemover != null) {
                ModelFactory.getInstance().getGestionBiblioteca().getListaPrestamo().remove(prestamoARemover);
                System.out.println("El libro " + libro.getTitulo() + " ha sido devuelto por " + miembro.getNombre() +
                        " con ID: " + miembro.getIdMiembro() + " y el préstamo ha sido eliminado.");
            } else {
                System.out.println("No se encontró un préstamo correspondiente para el libro y el miembro.");
            }
        } else {
            System.out.println("El libro " + libro.getTitulo() + " no está registrado como prestado.");
        }
    }
    @Override
    public void registrarMulta(Prestamo prestamo, LocalDate fechaLimite) {
        if(prestamo.getFechaDevolucion().isAfter(fechaLimite)){
            Period periodo = Period.between(fechaLimite, prestamo.getFechaDevolucion());
            int diasRetraso = periodo.getDays();
            double multa = diasRetraso*5000;
            System.out.println("Multa registrada para: " + prestamo.getMiembro().getNombre() +
                    " por el retraso al devolver el libro: " + prestamo.getLibro().getTitulo() + ": " + multa);
        }else{
            System.out.println("La multa no se aplica ya que el libro se devolvió a tiempo");
        }
    }
    @Override
    public void gestionarItem() {

    }
}
