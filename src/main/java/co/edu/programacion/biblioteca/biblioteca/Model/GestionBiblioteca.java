package co.edu.programacion.biblioteca.biblioteca.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionBiblioteca {

    private String nombre;
    private List<Miembro> listaMiembro = new ArrayList<>();
    private List<Empleado> listaEmpleado = new ArrayList<>();
    private List<Prestamo> listaPrestamo = new ArrayList<>();
    private List<Bibliotecario> listaBibliotecario = new ArrayList<>();
    private List<Libro> listaLibros = new ArrayList<>();

    public GestionBiblioteca() {
    }

    public GestionBiblioteca(String nombre, List<Miembro> listaMiembro, List<Empleado> listaEmpleado, List<Prestamo> listaPrestamo,
                             List<Bibliotecario> listaBibliotecario, List<Libro> listaLibros) {
        this.nombre = nombre;
        this.listaMiembro = listaMiembro;
        this.listaEmpleado = listaEmpleado;
        this.listaPrestamo = listaPrestamo;
        this.listaBibliotecario = listaBibliotecario;
        this.listaLibros = listaLibros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Miembro> getListaMiembro() {
        return listaMiembro;
    }

    public void setListaMiembro(List<Miembro> listaMiembro) {
        this.listaMiembro = listaMiembro;
    }

    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }
    public void setListaEmpleado(List<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public List<Prestamo> getListaPrestamo() {
        return listaPrestamo;
    }
    public void setListaPrestamo(List<Prestamo> listaPrestamo) {
        this.listaPrestamo = listaPrestamo;
    }

    public List<Bibliotecario> getListaBibliotecario() {
        return listaBibliotecario;
    }
    public void setListaBibliotecario(List<Bibliotecario> listaBibliotecario) {
        this.listaBibliotecario = listaBibliotecario;
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }
    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    @Override
    public String toString() {
        return "GestionBiblioteca{" +
                "libros=" + listaLibros.size() + " libros, " +
                "miembros=" + listaMiembro.size() + " miembros, " +
                "empleados=" + listaEmpleado.size() + " empleados, " +
                "bibliotecarios=" + listaBibliotecario.size() + " bibliotecarios" +
                '}';
    }

    public void registrarBibliotecario(String nombre, String idEmpleado) {
        Bibliotecario nuevoBibliotecario = new Bibliotecario();
        nuevoBibliotecario.setNombre(nombre);
        nuevoBibliotecario.setIdEmpleado(idEmpleado);
        listaBibliotecario.add(nuevoBibliotecario);
        System.out.println("Bibliotecario registrado correctamente");
    }
    public void registrarEmpleado(String nombre, String idEmpleado) {
        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setNombre(nombre);
        nuevoEmpleado.setIdEmpleado(idEmpleado);
        listaEmpleado.add(nuevoEmpleado);
        System.out.println("Empleado registrado correctamente");
    }
    public void registrarMiembro(String nombre, String idMiembro) {
        Miembro nuevoMiembro = new Miembro();
        nuevoMiembro.setNombre(nombre);
        nuevoMiembro.setIdMiembro(idMiembro);
        listaMiembro.add(nuevoMiembro);
        System.out.println("Miembro registrado correctamente");
    }
    public void registrarLibro(String titulo, String autor, String isbn, String estado) {
        Libro nuevoLibro = new Libro();
        nuevoLibro.setTitulo(titulo);
        nuevoLibro.setAutor(autor);
        nuevoLibro.setISBN(isbn);
        nuevoLibro.setEstado(estado);
        listaLibros.add(nuevoLibro);
        System.out.println("Libro registrado correctamente");
    }
    public void mostrarLibros(){
        for(Libro libro : getListaLibros()){
            System.out.println(libro);
        }
    }
    public void mostrarBibliotecario(){
        for(Bibliotecario bibliotecario : getListaBibliotecario()){
            System.out.println(bibliotecario);
        }
    }
    public void mostrarEmpleados(){
        for(Empleado empleado : getListaEmpleado()){
            System.out.println(empleado);
        }
    }
    public void mostrarMiembros(){
        for(Miembro miembro : getListaMiembro()){
            System.out.println(miembro);
        }
    }
    public void mostrarPrestamos(){
        for(Prestamo prestamo : getListaPrestamo()){
            System.out.println(prestamo);
        }
    }

    public void registrarPrestamo(Miembro miembro, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Libro libro){
        Prestamo nuevoPrestamo = new Prestamo();
        nuevoPrestamo.setMiembro(miembro);
        nuevoPrestamo.setFechaPrestamo(fechaPrestamo);
        nuevoPrestamo.setFechaDevolucion(fechaDevolucion);
        nuevoPrestamo.setLibro(libro);
        listaPrestamo.add(nuevoPrestamo);
        System.out.println("Préstamo registrado correctamente");
    }

}


