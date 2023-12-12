module applebank.appbancodefinitivo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.web;
    requires java.desktop;
    requires jakarta.persistence;



    exports UserRegistration;
    exports Cuentas;
    exports DAO;
    exports Interfaces;
    exports Pantallas;
    exports PersistenceJPA;
    exports Seguridad;
    exports Tests;
    exports UserDashboard;


    opens DAO to jakarta.persistence;
    opens PersistenceJPA to org.hibernate.orm.core;


    requires org.hibernate.orm.core;





    opens applebank.appbancodefinitivo to javafx.fxml;
    exports applebank.appbancodefinitivo;
}