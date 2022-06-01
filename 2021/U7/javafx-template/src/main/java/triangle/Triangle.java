package triangle;

public class Triangle {
    private int one;
    private int two;
    private int three;

    public Triangle(int one, int two, int three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    private boolean gleichschenklig() {
        if (this.one == this.two) {
            return true;
        } else if (this.two == this.three) {
            return true;
        } else if (this.three == this.one) {
            return true;
        } else {
            return false;
        }
    }

    private boolean gleichseitig() {
        if (this.one == this.two && this.two == this.three) {
            return true;
        } else {
            return false;
        }
    }

    public String calculate() {
       if (gleichseitig()) {
           return "Dieses Dreieck ist gleichseitig.";
       } else if (gleichschenklig()) {
           return "Dieses Dreieck ist gleichschenklig.";
       } else {
           return "Dieses Dreieck ist ungleichseitig.";
       }
    }
}
