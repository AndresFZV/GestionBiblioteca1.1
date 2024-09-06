module co.edu.programacion.biblioteca.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.programacion.biblioteca.biblioteca to javafx.fxml;
    exports co.edu.programacion.biblioteca.biblioteca;
    exports co.edu.programacion.biblioteca.biblioteca.Controller;
    opens co.edu.programacion.biblioteca.biblioteca.Controller to javafx.fxml;
}