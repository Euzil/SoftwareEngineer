package triangle;

/**
 * Schnittstelle für das Datenmodell
 */
public interface IModel {
    /**
     * Füge dem Datenmodell einen neuen Observer hinzu. Dieser wird benachrichtigt, sobald sich Werte des Modells
     * ändern.
     * @param observer der Observer
     */
    void addObservser(IObserver observer);

    /**
     * Entferne einen Observer wieder. Dieser wird dann nicht mehr benachrichtigt.
     * @param observer der Observer
     * @return
     */
    boolean removeObserver(IObserver observer);

    /**
     * Liefert die aktuell im Datenmodell gespeicherte Seitenlänge für die gegebene Seite des Dreiecks.
     * @param side die Seite
     * @return die Länge der gegebenen Seite
     */
    int getLength(Side side);

    /**
     * Setzt die Seitenlänge einer Seite des Datenmodells
     * @param side die Seite
     * @param value die neue Länge der Seite
     */
    void setLength(Side side, int value);

    /**
     * Gibt den Typ des aktuell im Modell gespeicherten Dreiecks zurück. In der Implementierung dieser Methode findet
     * die eigentliche Berechnung statt. Die ist in dieser Beispielanwendung bewusst sehr banal, da es um die
     * Veranschaulichung von MVC an einem möglichst einfachen Beispiel geht.
     * @return der Typ des aktuell im Modell gespeicherten Dreiecks
     */
    TriangleType getType();
}
