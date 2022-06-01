import java.util.*;

public class Main {

    public static boolean gleichschenklig(int one, int two, int three) {
        if (one == two) {
            return true;
        } else if (two == three) {
            return true;
        } else if (three == one) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean gleichseitig(int one, int two, int three) {
        if (one == two && two == three) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
      // Nimmt 3 integers, welche die Seitenlänge eines
      // eines Dreiecks beschreiben.
      // Es soll ausgeben ob das Dreieck gleichseitig,
      // gleichschenklig oder ungleichseitig ist.
      int sideOne, sideTwo, sideThree;
      Scanner scanner = new Scanner(System.in);
      System.out.println("Bitte geben sie drei ganzzahlige Werte an.");
      sideOne = Integer.parseInt(scanner.nextLine());
      sideTwo = Integer.parseInt(scanner.nextLine());
      sideThree = Integer.parseInt(scanner.nextLine());

       if (gleichseitig(sideOne, sideTwo, sideThree)) {
           System.out.println("Dieses Dreieck ist gleichseitig.");
       } else if (gleichschenklig(sideOne, sideTwo, sideThree)) {
           System.out.println("Dieses Dreieck ist gleichschenklig.");
       } else {
           System.out.println("Dieses Dreieck ist ungleichseitig.");
       }
    }
}
