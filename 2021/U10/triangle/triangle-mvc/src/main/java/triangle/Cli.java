package triangle;

import java.util.Scanner;

/**
 * Die Kommandozeilenschnittstelle ist ein User Interface. Über das Observer-Pattern erfährt die Schnittstelle von
 * Änderungen des Modells und zeigt diese an. Wenn der Benutzer mit dem Interface interagiert, werden entsprechende
 * Ereignisse an den Controller weitergereicht. Dieser ist als EventHandler bekannt.
 */
public class Cli implements IObserver {
    /**
     * Der Ereignisbehandler für Ereignisse, wenn der Benutzer mit der CLI interagiert
     */
    private IEventHandler eventHandler;

    /**
     * Erzeugt eine neue CLI
     * @param eventHandler Der Ereignisbehandler für Ereignisse, wenn der Benutzer mit der CLI interagiert
     */
    public Cli(IEventHandler eventHandler) {
        this.eventHandler = eventHandler;

        // Wir führen die CLI in einer Endlosschleife in einem eigenen Thread aus, damit wir mit synchronen
        // Funktionen von der Standardeingabe lesen können
        new Thread(() -> {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                try {
                    String line = scanner.nextLine(); // Dieser Aufruf blockiert bis zur nächsten Nutzereingabe
                    // Parsen der Nutzereingabe
                    String[] parts = line.split("\\s*=\\s*");
                    if (parts.length == 2) {
                        // Interpretation der Nutzereingabe
                        Side side = Side.valueOf(parts[0].toUpperCase());
                        int length = Integer.parseInt(parts[1]);
                        // Weitergabe der Benutzereingabe an den Ereignisbehandler
                        eventHandler.handleSideChanged(side, length);
                    } else {
                        System.err.println("ungültige Eingabe");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("ungültige Zahl");
                } catch (IllegalArgumentException e) {
                    System.err.println("Ungültige Seite");
                }
            }
        }).start();
    }

    @Override
    public void notify(IModel sender) {
        // Sobald sich das Datenmodell ändert, werden wir benachrichtigt. Wir geben dann die aktuellen Werte des Modells
        // auf der Standardausgabe aus.
        System.out.println("a = " + sender.getLength(Side.A) + ", b = " + sender.getLength(Side.B) + ", c = " +
                sender.getLength(Side.C) + ": " + GermanConstants.TRIANGLE.get(sender.getType()));
    }
}
