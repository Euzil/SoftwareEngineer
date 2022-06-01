module example {
    requires javafx.controls;
    requires transitive javafx.graphics;

    exports triangle;
    opens triangle;
    exports triangle.views;
    opens triangle.views;
}
