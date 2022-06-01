package triangle;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Die GUI ist ein User Interface. Über das Observer-Pattern erfährt die Schnittstelle von
 * Änderungen des Modells und zeigt diese an. Wenn der Benutzer mit dem Interface interagiert, werden entsprechende
 * Ereignisse an den Controller weitergereicht. Dieser ist als EventHandler bekannt.
 */
public class Gui implements IObserver {
    /**
     * ChangeListener, die auf Änderungen der einzelnen Textfelder reagieren
     */
    private final List<ChangeListener<String>> changeListeners = new ArrayList<>();

    /**
     * Die Textfelder zur Eingabe der Seitenlängen des Dreiecks
     */
    private final List<TextField> textFields = new ArrayList<>();

    /**
     * Label für die Ausgabe des Ergebnisses
     */
    private Text result = new Text();

    /**
     * Der Ereignisbehandler für Ereignisse, wenn der Benutzer mit der CLI interagiert
     */
    private IEventHandler eventHandler;

    /**
     * Erzeugt eine neue GUI
     * @param eventHandler Der Ereignisbehandler für Ereignisse, wenn der Benutzer mit der GUI interagiert
     * @param primaryStage Das Hauptfenster der JavaFX-Anwendung
     */
    public Gui(IEventHandler eventHandler, Stage primaryStage) {
        this.eventHandler = eventHandler;

        // Titel der Anwendung setzen, der als Überschrift des Hauptfensters angezeigt wird
        primaryStage.setTitle("Dreieck");

        // Wir verwenden eine GridPane für das Layout und ordnen die Label und Textfelder in diesem Raster an
        GridPane root = new GridPane();
        root.setVgap(20);
        root.setHgap(10);
        root.setAlignment(Pos.CENTER);

        // Beschriftungen der drei Label
        final List<String> captions = List.of("a", "b", "c");

        // Wir legen drei beschriftete Textfelder für die Seitenlängen des Dreiecks an. Jedes Textfeld erhält eine
        // eigene Ereignisbehandlung, die reagiert, wenn der Benutzer den Wert des Textfelds ändern. Wir informieren
        // dann den Controller über diese Änderung.
        for (int row = 0; row < 3; row++) {
            // Textfeld anlegen und Textfeld und passendes Label der GUI hinzufügen
            TextField textField = new TextField();
            textFields.add(textField);
            root.add(new Text(captions.get(row)), 0, row);
            root.add(textField, 1, row);

            // Aktuelle Seite. Diese Variable steht in der Ereignisbehandlung unten zur Verfügung, sodass diese jeweils
            // weiß, für welche Seite sich gerade der Wert geändert hat
            Side side = Side.values()[row];

            // Neue Ereignisbehandlung für dieses Textfeld anlegen
            ChangeListener<String> changeListener = ((observableValue, oldValue, newValue) -> {
                try {
                    // Parsen und Interpretieren der Nutzereingabe
                    int value = Integer.parseInt(newValue);
                    // Weitergabe der Benutzereingabe an den Ereignisbehandler
                    eventHandler.handleSideChanged(side, value);
                    textField.setStyle(""); // Hintergrundfarbe zurücksetzen
                } catch (NumberFormatException e) {
                    // Im Fehlerfall Hintergrundfarbe setzen
                    textField.setStyle("-fx-control-inner-background: red;");
                    result.setText("ungültige Eingabe");
                }
            });
            changeListeners.add(changeListener);
            textField.textProperty().addListener(changeListener);
        }

        // Label zur Anzeige des Ergebnisses der GUI hinzufügen
        root.add(result, 0,3, 2, 1);

        // Größe des Fensters setzen und Fenster anzeigen
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    @Override
    public void notify(IModel sender) {
        // Sobald sich das Datenmodell ändert, werden wir benachrichtigt. Wir setzen dann die aktuellen Werte des Modells
        // in die Textfelder und das Label für die Ausgabe des Ergebnisses.
        for (int row = 0; row < 3; row++) {
            TextField textField = textFields.get(row);
            Side side = Side.values()[row];
            textField.setStyle(""); // Hintergrundfarbe zurücksetzen
            // ChangeListener dieses Textfelds entfernen, damit unsere Änderung nicht weitergereicht wird
            textField.textProperty().removeListener(changeListeners.get(row));
            textField.setText(Integer.toString(sender.getLength(side)));
            // ChangeListener dieses Textfelds wieder hinzufügen
            textField.textProperty().addListener(changeListeners.get(row));
        }
        // Ergebnis im entsprechenden Label anzeigen
        result.setText(GermanConstants.TRIANGLE.get(sender.getType()));
    }
}
