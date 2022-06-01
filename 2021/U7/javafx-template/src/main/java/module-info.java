module example {
    requires javafx.controls;
    requires transitive javafx.graphics;

    exports triangle;
    opens triangle;
}
