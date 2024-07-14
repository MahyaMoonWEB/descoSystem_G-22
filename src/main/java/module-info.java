module com.example.descosystem_g22 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.descosystem_g22 to javafx.fxml;
    exports com.example.descosystem_g22;
}