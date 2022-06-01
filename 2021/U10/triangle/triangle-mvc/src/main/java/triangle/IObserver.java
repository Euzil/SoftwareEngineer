package triangle;

/**
 * Schnittstelle für einen Observer. Dieser wird benachrichtigt, sobald sich Werte am Modell ändern.
 */
public interface IObserver {
    /**
     * Benachrichtigung, dass sich Werte am Modell geändert haben.
     * @param sender Das Modell, dessen Werte sich gändert haben
     */
    void notify(IModel sender);
}
