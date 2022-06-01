module triangle {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens triangle;
    exports triangle;
}
