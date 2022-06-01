package triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    private final Triangle triangle = new Triangle();

    @Test
    void testEquilateral() {
        // setting the length
        triangle.setLength(Side.A, 1);
        triangle.setLength(Side.B, 1);
        triangle.setLength(Side.C, 1);

        // getting the results.
        assertEquals(TriangleType.EQUILATERAL, triangle.getType());
    }

    @Test
    void testIsosceles() {
        // setting the length
        triangle.setLength(Side.A, 1);
        triangle.setLength(Side.B, 2);
        triangle.setLength(Side.C, 1);

        // getting the results.
        assertEquals(TriangleType.ISOSCELES, triangle.getType());
    }

    @Test
    void testScalene() {
        // setting the length
        triangle.setLength(Side.A, 1);
        triangle.setLength(Side.B, 2);
        triangle.setLength(Side.C, 3);

        // getting the results.
        assertEquals(TriangleType.SCALENE, triangle.getType());
    }

    @Test
    void testInvalid() {
        // setting the length
        triangle.setLength(Side.A, 1);
        triangle.setLength(Side.B, 2);
        triangle.setLength(Side.C, -1);

        // getting the results.
        assertEquals(TriangleType.INVALID, triangle.getType());
    }
}
