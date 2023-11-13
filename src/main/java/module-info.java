module applebank.appbancodefinitivo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.web;
    requires java.desktop;
    requires jakarta.persistence;


    exports Pantallas;
    exports Controllers;
    exports Interfaces;
    exports Tests;




    opens applebank.appbancodefinitivo to javafx.fxml;
    exports applebank.appbancodefinitivo;
}