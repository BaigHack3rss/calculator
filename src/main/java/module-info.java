module com.jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.jfx to javafx.fxml;
    exports com.jfx;
}
