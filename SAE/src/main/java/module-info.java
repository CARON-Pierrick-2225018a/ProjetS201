module projetsismique.sae {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires eu.hansolo.fx.countries;
    requires eu.hansolo.fx.heatmap;
    requires javafx.swing;
    requires com.gluonhq.maps;
    requires java.sql;
    requires com.gluonhq.attach.util;
    opens seismeApp.Model to javafx.base;
    opens seismeApp to javafx.fxml;
    exports seismeApp;
    exports seismeApp.View;
    opens seismeApp.View to javafx.fxml;
}