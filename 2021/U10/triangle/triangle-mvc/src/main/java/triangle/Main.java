package triangle;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Dieses JavaFX-Programm nimmt drei Integer-Zahlen entgegen. Jede Zahl wird dabei als Seitenlänge eines Dreiecks
 * verstanden. Das Programm gibt aus, ob das Dreieck mit diesen drei Seitenlängen gleichschenklig, gleichseitig oder
 * ungleichseitig ist. Die Applikation dient primär der Demonstration des MVC-Musters.
 */
public class Main extends Application {
    /**
     * Einstiegspunkt der Kommandozeilenapplikation
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Wir erzeugen einen neuen Controller und geben diesem das Hauptfenster mit. Alles Weitere passiert im
        // Controller.
        new Controller(primaryStage);
    }
}
