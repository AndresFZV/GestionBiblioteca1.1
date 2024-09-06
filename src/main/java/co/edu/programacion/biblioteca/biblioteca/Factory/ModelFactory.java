package co.edu.programacion.biblioteca.biblioteca.Factory;

import co.edu.programacion.biblioteca.biblioteca.Model.*;

import java.time.LocalDate;

public class ModelFactory {

    private static ModelFactory modelFactory;
    private GestionBiblioteca gestionBiblioteca;

    private ModelFactory(){
        inicializarDatos();
    }

    public static ModelFactory getInstance(){
        if(modelFactory == null){
            modelFactory = new ModelFactory();
        }

        return modelFactory;
    }

    public GestionBiblioteca getGestionBiblioteca() {
        return gestionBiblioteca;
    }

    public void registrarBibliotecario(String nombre, String idEmpleado){
        gestionBiblioteca.registrarBibliotecario(nombre, idEmpleado);
    }

    public void registrarEmpleado(String nombre, String idEmpleado){
        gestionBiblioteca.registrarEmpleado(nombre, idEmpleado);
    }
    public void registrarMiembro(String nombre, String idMiembro){
        gestionBiblioteca.registrarMiembro(nombre, idMiembro);
    }
    public void registrarLibro(String titulo, String autor, String ISBN,String  estado){
        gestionBiblioteca.registrarLibro(titulo, autor,ISBN, estado);
    }

    public void mostrarLibros(){
        gestionBiblioteca.mostrarLibros();
    }
    public void mostrarBibliotecarios(){
        gestionBiblioteca.mostrarBibliotecario();
    }
    public void mostrarEmpleados(){
        gestionBiblioteca.mostrarEmpleados();
    }
    public void mostrarMiembros(){
        gestionBiblioteca.mostrarMiembros();
    }
    public void mostrarPrestamos(){
        gestionBiblioteca.mostrarPrestamos();
    }
    public void registrarPrestamo(Miembro miembro, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Libro libro){
       gestionBiblioteca.registrarPrestamo(miembro, fechaPrestamo, fechaDevolucion, libro);

    }

    private void inicializarDatos() {
        gestionBiblioteca = new GestionBiblioteca();
        Bibliotecario bibliotecario1 = new Bibliotecario();
        bibliotecario1.setNombre("Andrés");
        bibliotecario1.setIdEmpleado("0104");
        gestionBiblioteca.getListaBibliotecario().add(bibliotecario1);

        Empleado empleado1 = new Empleado();
        empleado1.setNombre("David");
        empleado1.setIdEmpleado("1050");
        Empleado empleado2 = new Empleado();
        empleado2.setNombre("John");
        empleado2.setIdEmpleado("8050");
        gestionBiblioteca.getListaEmpleado().add(empleado1);
        gestionBiblioteca.getListaEmpleado().add(empleado2);

        Miembro miembro1 = new Miembro();
        miembro1.setNombre("Stiven");
        miembro1.setIdMiembro("1012");
        Miembro miembro2 = new Miembro();
        miembro2.setNombre("Angelica");
        miembro2.setIdMiembro("3108");
        Miembro miembro3 = new Miembro();
        miembro3.setNombre("Sebastian");
        miembro3.setIdMiembro("9988");
        gestionBiblioteca.getListaMiembro().add(miembro1);
        gestionBiblioteca.getListaMiembro().add(miembro2);
        gestionBiblioteca.getListaMiembro().add(miembro3);

        Libro libro1 = new Libro();
        libro1.setTitulo("Don Quijote de la Mancha");
        libro1.setAutor("Miguel de Cervantes");
        libro1.setISBN("8430598677");
        libro1.setEstado("Disponible");
        Libro libro2 = new Libro();
        libro2.setTitulo("El principito");
        libro2.setAutor("Antoine Saint");
        libro2.setISBN("1234567890");
        libro2.setEstado("Prestado");
        Libro libro3 = new Libro();
        libro3.setTitulo("Cien años de soledad");
        libro3.setAutor("Gabriel García Marquez");
        libro3.setISBN("843760494X");
        libro3.setEstado("Prestado");
        Libro libro4 = new Libro();
        libro4.setTitulo("La Odisea");
        libro4.setAutor("Homero");
        libro4.setISBN("1539427692");
        libro4.setEstado("Prestado");
        Libro libro5 = new Libro();
        libro5.setTitulo("Viaje al centro de la tierra");
        libro5.setAutor("Julio Verne");
        libro5.setISBN("101284043Q");
        libro5.setEstado("Disponible");
        gestionBiblioteca.getListaLibros().add(libro1);
        gestionBiblioteca.getListaLibros().add(libro2);
        gestionBiblioteca.getListaLibros().add(libro3);
        gestionBiblioteca.getListaLibros().add(libro4);
        gestionBiblioteca.getListaLibros().add(libro5);

        Prestamo prestamo1 = new Prestamo();
        prestamo1.setFechaPrestamo(LocalDate.of(2024, 8,27));
        prestamo1.setFechaDevolucion(LocalDate.of(2024, 8,31));
        prestamo1.setMiembro(miembro1);
        prestamo1.setLibro(libro2);
        Prestamo prestamo2 = new Prestamo();
        prestamo2.setFechaPrestamo(LocalDate.of(2024, 8,25));
        prestamo2.setFechaDevolucion(LocalDate.of(2024, 9,5));
        prestamo2.setMiembro(miembro2);
        prestamo2.setLibro(libro3);
        Prestamo prestamo3 = new Prestamo();
        prestamo3.setFechaPrestamo(LocalDate.of(2024, 8,20));
        prestamo3.setFechaDevolucion(LocalDate.of(2024, 8,31));
        prestamo3.setMiembro(miembro3);
        prestamo3.setLibro(libro4);
        gestionBiblioteca.getListaPrestamo().add(prestamo1);
        gestionBiblioteca.getListaPrestamo().add(prestamo2);
        gestionBiblioteca.getListaPrestamo().add(prestamo3);
    }
}
