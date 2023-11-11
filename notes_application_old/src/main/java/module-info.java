module notes_application {
    requires javafx.controls;
    requires javafx.fxml;

    opens notes_application to javafx.fxml;
    exports notes_application;
}
