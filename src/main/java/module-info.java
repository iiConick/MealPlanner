module com.example.mealplanner {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;


    opens com.example.mealplanner to javafx.fxml, com.google.gson;
    exports com.example.mealplanner;
    exports com.example.mealplanner.Controllers;
    opens com.example.mealplanner.Controllers to com.google.gson, javafx.fxml;
    exports com.example.mealplanner.Models;
    opens com.example.mealplanner.Models to com.google.gson, javafx.fxml;
}