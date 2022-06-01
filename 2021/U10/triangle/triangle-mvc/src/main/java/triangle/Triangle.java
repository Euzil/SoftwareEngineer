package triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Datenmodell eines Dreiecks. Dieses Modell kann die drei Seitenlängen eines Dreiecks speichern und berechnen, ob das
 * Dreieck mit diesen drei Seitenlängen gleichschenklig, gleichseitig oder ungleichseitig ist.
 */
public class Triangle implements IModel {
    /**
     * Observer des Datenmodells. Diese werden benachrichtigt, sobald sich eine Seitenlänge geändert hat.
     */
    private final List<IObserver> observers = new ArrayList<>();

    @Override
    public void addObservser(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public boolean removeObserver(IObserver observer) {
        return observers.remove(observer);
    }

    /**
     * Hilfsmethode zum Benachrichtigen aller Observer.
     */
    private void notifyObservers() {
        observers.forEach(observer -> observer.notify(this));
    }

    /**
     * Die Seitenlängen des Dreiecks
     */
    private int[] sides = {1, 2, 3};

    @Override
    public int getLength(Side side) {
        return sides[side.ordinal()];
    }

    @Override
    public void setLength(Side side, int value) {
        // Wert aktualisieren
        sides[side.ordinal()] = value;
        // Observer über die Änderung berechtigten
        notifyObservers();
    }

    @Override
    public TriangleType getType() {
        if (sides[0] == sides[1] && sides[1] == sides[2]) {
            return TriangleType.EQUILATERAL;
        } else if (sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]) {
            return TriangleType.ISOSCELES;
        } else if (sides[0] < 0 || sides[1] < 0 || sides[2] < 0) {
            return TriangleType.INVALID;
        }
        return TriangleType.SCALENE;
    }
}
