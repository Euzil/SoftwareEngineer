package triangle;

import javafx.stage.Stage;

/**
 * Der Controller erzeigt und neue Instanz des Modells und hält diese vor. Außerdem erzeugt er die verschiedenen
 * User Interfaces und registriert diese als Observer am Modell. Die User Interfaces kennen beide diesen Controller
 * und informieren ihn über Ereignisse, wenn der Benutzer mit dem Interface interagiert.
 */
public class Controller implements IEventHandler {
    /**
     * Das Datenmodell: Ein Dreieck.
     */
    private IModel model = new Triangle();

    /**
     * Erzeugt einen neuen Controller und initialisiert die User Interfaces.
     * @param primaryStage Das Hauptfenster der JavaFX-Anwendung
     */
    public Controller(Stage primaryStage) {
        Gui gui = new Gui(this, primaryStage);
        model.addObservser(gui);
        gui.notify(model); // Initiale Notifizierung der GUI
        Cli cli = new Cli(this);
        model.addObservser(cli);
        cli.notify(model); // Initiale Notifizierung der CLI
    }

    @Override
    public void handleSideChanged(Side side, int value) {
        // Wenn die User Interfaces den Controller darüber benachrichtigt haben, dass der Benutzer eine Seitenlänge
        // des Dreiecks ändern will, so reicht der Controller diese Änderung an das Modell weiter.
        model.setLength(side, value);
    }
}
