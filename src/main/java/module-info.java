module university.jala.capstone.capscar {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens university.jala.capstone.capscar to javafx.fxml;
    exports university.jala.capstone.capscar;
    exports university.jala.capstone.capscar.ui;
    opens university.jala.capstone.capscar.ui to javafx.fxml;
}