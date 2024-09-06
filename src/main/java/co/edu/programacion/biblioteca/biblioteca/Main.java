package co.edu.programacion.biblioteca.biblioteca;

import co.edu.programacion.biblioteca.biblioteca.Factory.ModelFactory;
import co.edu.programacion.biblioteca.biblioteca.Model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ModelFactory modelFactory = ModelFactory.getInstance();
        Scanner in = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n***Gestión Biblioteca***");
            System.out.println("1.Registros nuevo en la biblioteca");
            System.out.println("2.Consultar registros de la biblioteca");
            System.out.println("3.Opciones biblioteca");
            System.out.println("Seleccione una opción: ");
            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    nuevoRegistro(modelFactory, in);
                    break;
                case 2:
                    nuevaConsulta(modelFactory, in);
                    break;
                case 3:
                    opcionesBibliotecario(modelFactory, in);
                case 4:
                    System.out.println("Saliendo del menú");
                default:
                    System.out.println("La opción no existe");
            }
        } while (opcion != 4);
        in.close();
    }
    private static void nuevoRegistro(ModelFactory modelFactory, Scanner in) {
        int opcion;
        do {
            System.out.println("1.Registrar un nuevo bibliotecario");
            System.out.println("2.Registrar un nuevo empleado");
            System.out.println("3.Registrar un nevo miembro");
            System.out.println("4.Registrar un nuevo libro");
            System.out.println("5.Salir");
            System.out.println("Seleccione una opción: ");
            opcion = in.nextInt();
            in.nextLine();
            switch (opcion) {
                case 1:
                    registrarBibliotecario(modelFactory, in);
                    break;
                case 2:
                    registrarEmpleado(modelFactory, in);
                    break;
                case 3:
                    registrarMiembro(modelFactory, in);
                    break;
                case 4:
                    registrarLibro(modelFactory, in);
                    break;
                case 5:
                    System.out.println("Saliendo del menú");
                    break;
                default:
                    System.out.println("La opción no existe");
            }
        } while (opcion != 5);
    }

    private static void nuevaConsulta(ModelFactory modelFactory, Scanner in) {
        int opcion;
        do {
            System.out.println("1.Consultar libros de la biblioteca");
            System.out.println("2.Consultar bibliotecarios de la biblioteca");
            System.out.println("3.Consultar empleados de la biblioteca");
            System.out.println("4.Consultar miembros de la biblioteca");
            System.out.println("5.Consultar prestamos de la biblioteca");
            System.out.println("6.Salir");
            System.out.println("Seleccione una opción: ");
            opcion = in.nextInt();
            in.nextLine();
            switch (opcion) {
                case 1:
                    modelFactory.mostrarLibros();
                    break;
                case 2:
                    modelFactory.mostrarBibliotecarios();
                    break;
                case 3:
                    modelFactory.mostrarEmpleados();
                    break;
                case 4:
                    modelFactory.mostrarMiembros();
                    break;
                case 5:
                    modelFactory.mostrarPrestamos();
                    break;
                case 6:
                    System.out.println("Saliendo del menú");
                default:
                    System.out.println("La opción no existe");
            }
        } while (opcion != 6);
    }

    private static void opcionesBibliotecario(ModelFactory modelFactory, Scanner in) {
        int opcion;
        do {
            System.out.println("1.Eliminar libro");
            System.out.println("2.Registrar préstamo");
            System.out.println("3.Registrar devolución");
            System.out.println("4.Registrar multa");
            System.out.println("5.Salir");
            System.out.println("Seleccione una opción: ");
            opcion = in.nextInt();
            in.nextLine();
            switch (opcion) {
                case 1:
                    eliminarLibro(modelFactory, in);
                    break;
                case 2:
                    registrarPrestamo(modelFactory, in);
                    break;
                case 3:
                    registrarDevolucion(modelFactory, in);
                    break;
                case 4:
                    registrarMulta(modelFactory, in);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("La opción no existe");
            }
        } while (opcion != 5);
    }

    private static void registrarBibliotecario(ModelFactory modelFactory, Scanner in) {
        in.nextLine();
        System.out.println("Ingrese el nombre del bibliotecario: ");
        String nombre = in.nextLine();
        System.out.println("Ingrese el ID del bibliotecario:  ");
        String id = in.nextLine();
        modelFactory.registrarBibliotecario(nombre, id);
    }

    private static void registrarEmpleado(ModelFactory modelFactory, Scanner in) {
        in.nextLine();
        System.out.println("Ingrese el nombre del empleado: ");
        String nombre = in.nextLine();
        System.out.println("Ingrese el id del empleado: ");
        String id = in.nextLine();
        modelFactory.registrarEmpleado(nombre, id);
    }

    private static void registrarMiembro(ModelFactory modelFactory, Scanner in) {
        in.nextLine();
        System.out.println("Ingrese el nombre del miembro: ");
        String nombre = in.nextLine();
        System.out.println("Ingrese el id del miembro: ");
        String id = in.nextLine();
        modelFactory.registrarMiembro(nombre, id);
    }

    private static void registrarLibro(ModelFactory modelFactory, Scanner in) {
        in.nextLine();
        System.out.println("Ingrese el titulo del libro:");
        String titulo = in.nextLine();
        System.out.println("Ingrese el nombre del autor: ");
        String autor = in.nextLine();
        System.out.println("Ingrese el ISBN del libro: ");
        String ISBN = in.nextLine();
        System.out.println("Estado del libro: ");
        String estado = in.nextLine();
        modelFactory.registrarLibro(titulo, autor, ISBN, estado);
    }

    private static void eliminarLibro(ModelFactory modelFactory, Scanner in) {
        System.out.println("Ingrese el título del libro que desea eliminar:");
        String titulo = in.nextLine();
        Libro eliminarLibro = null;
        for (Libro libro : modelFactory.getGestionBiblioteca().getListaLibros()) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                eliminarLibro = libro;
                break;
            }
        }
        if (eliminarLibro != null) {
            Bibliotecario bibliotecario = modelFactory.getGestionBiblioteca().getListaBibliotecario().get(0);
            bibliotecario.eliminarLibro(eliminarLibro);
        } else {
            System.out.println("El libro con el título '" + titulo + "' no se encuentra en el inventario.");
        }
    }

    private static void registrarPrestamo(ModelFactory modelFactory, Scanner in) {
        System.out.println("Ingrese el ID del miembro que solicita el prestamo: ");
        String idMiembro = in.nextLine();
        System.out.println("Ingrese el titulo del libro que desea prestar: ");
        String titulo = in.nextLine();
        System.out.println("Ingrese la fecha del prestamo (YYYY-MM-DD): ");
        LocalDate fechaPrestamo = LocalDate.parse(in.nextLine());
        System.out.println("Ingrese fecha de devolucion (YYYY-MM-DD): ");
        LocalDate fechaDevolucion = LocalDate.parse(in.nextLine());
        Miembro miembro = null;
        for (Miembro m : modelFactory.getGestionBiblioteca().getListaMiembro()) {
            if (m.getIdMiembro().equals(idMiembro)) {
                miembro = m;
                break;
            }
        }
        if (miembro == null) {
            System.out.println("No se encontró el ID ingresado.");
        } else {
            Libro libro = null;
            for (Libro l : modelFactory.getGestionBiblioteca().getListaLibros()) {
                if (l.getTitulo().equalsIgnoreCase(titulo)) {
                    libro = l;
                    break;
                }
            }
            if (libro == null) {
                System.out.println("No se encontró el libro con el título ingresado.");
            } else {
                modelFactory.registrarPrestamo(miembro, fechaPrestamo, fechaDevolucion, libro);
                System.out.println("El préstamo ha sido registrado exitosamente.");
            }
        }
    }
    private static void registrarDevolucion(ModelFactory modelFactory, Scanner in) {
        System.out.println("Ingrese el título del libro que se desea devolver:");
        String titulo = in.nextLine();
        System.out.println("Ingrese el ID del miembro que realiza la devolución:");
        String idMiembro = in.nextLine();
        // Buscar el libro en la lista
        Libro libro = null;
        for (Libro devolver : modelFactory.getGestionBiblioteca().getListaLibros()) {
            if (devolver.getTitulo().equalsIgnoreCase(titulo)) {
                libro = devolver;
                break;
            }
        }
        // Buscar el miembro en la lista
        Miembro miembro = null;
        for (Miembro m : modelFactory.getGestionBiblioteca().getListaMiembro()) {
            if (m.getIdMiembro().equals(idMiembro)) {
                miembro = m;
                break;
            }
        }
        // Si ambos se encuentran, proceder con la devolución
        if (libro != null && miembro != null) {
            Bibliotecario bibliotecario = modelFactory.getGestionBiblioteca().getListaBibliotecario().get(0);
            bibliotecario.registrarDevolucion(libro, miembro);
        } else {
            System.out.println("No se encontró el libro o el miembro en el sistema.");
        }
    }
    private static void registrarMulta(ModelFactory modelFactory, Scanner in) {
        System.out.println("Ingrese el ID del miembro asociado al préstamo:");
        String idMiembro = in.nextLine();
        Prestamo prestamo = null;
        for (Prestamo p : modelFactory.getGestionBiblioteca().getListaPrestamo()) {
            if (p.getMiembro().getIdMiembro().equals(idMiembro)) {
                prestamo = p;
                break;
            }
        }
        if (prestamo != null) {
            System.out.println("Ingrese la fecha límite de devolución (YYYY-MM-DD):");
            String fechaLimiteStr = in.nextLine();
            LocalDate fechaLimite = LocalDate.parse(fechaLimiteStr);
            Bibliotecario bibliotecario = modelFactory.getGestionBiblioteca().getListaBibliotecario().get(0);
            bibliotecario.registrarMulta(prestamo, fechaLimite);
        } else {
            System.out.println("No se encontró un préstamo para el miembro con ID: " + idMiembro);
        }
    }
}