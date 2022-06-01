package triangle;

import java.util.Map;

/**
 * Hilfsklasse, die in einer statischen Map String-Konstanten bereithält.
 */
public class GermanConstants {
    /**
     * String-Konstanten für die verschiedenen Eigenschaften eines Dreiecks
     */
    public static final Map<TriangleType, String> TRIANGLE = Map.of(TriangleType.SCALENE, "ungleichseitig",
            TriangleType.ISOSCELES, "gleichschenklig", TriangleType.EQUILATERAL, "gleichseitig");
}
