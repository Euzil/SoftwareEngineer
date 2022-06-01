package triangle;

public class TriangleModel {
    private int a;
    private int b;
    private int c;

    public TriangleModel(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * sets the value for a.
     * @param a lenght-value for a.
     */
    public void setA(int a) {
        this.a = a;
    }

    /**
     * sets the value for b.
     * @param b lenght-value for b.
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * sets the value for c.
     * @param c lenght-value for c.
     */
    public void setC(int c) {
        this.c = c;
    }

    /**
     * gets the value of a.
     * @return length of our side a.
     */
    public int getA() {
        return this.a;
    }

    /**
     * gets the value of b.
     * @return length of our side b.
     */
    public int getB() {
        return this.b;
    }

    /**
     * gets the value of c.
     * @return length of our side c.
     */
    public int getC() {
        return this.c;
    }


}
