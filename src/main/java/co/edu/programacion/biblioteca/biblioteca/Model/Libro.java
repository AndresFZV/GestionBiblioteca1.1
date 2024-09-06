package co.edu.programacion.biblioteca.biblioteca.Model;

public class Libro {
    public String titulo;
    public String autor;
    public String ISBN;
    public String estado;

    public Libro(){
    }

    public Libro(String titulo, String autor, String ISBN,String estado){
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        this.ISBN = iSBN;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", iSBN='" + ISBN + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
