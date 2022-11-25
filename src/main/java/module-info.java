module com.example.mealplanner {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;


    opens com.example.mealplanner to javafx.fxml, com.google.gson;
    exports com.example.mealplanner;
}