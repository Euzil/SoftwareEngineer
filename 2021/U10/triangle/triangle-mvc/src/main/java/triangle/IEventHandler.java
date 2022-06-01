package triangle;

/**
 * Schnittstelle für Ereignisbehandlungen von Ereignissen in den Nutzerinterfaces GUI und CLI
 */
public interface IEventHandler {
    /**
     * Der Benutzer hat eine Seitenlänge geändert
     * @param side Welche Seite wurde editiert?
     * @param value Was ist die neue Länge der Seite?
     */
    void handleSideChanged(Side side, int value);
}
