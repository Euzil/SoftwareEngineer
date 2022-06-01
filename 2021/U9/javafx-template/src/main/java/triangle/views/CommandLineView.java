package triangle.views;

import java.util.Scanner;

public class CommandLineView {
    private int a;
    private int b;
    private int c;

    // TODO implement function which takes certain commands and prints them afterwards. first only the arguments, the solution will follow shortly after.
    public void reads() {
        String line = System.console().readLine();
        this.updateSelf(line);
        this.printStatus();
    }

    /**
     * is used to update its own instance.
     * @param line
     */
    private void updateSelf(String line) {
        if (line.length() < 5) {
            // simply change that one value.
            if (line.substring(0,3).contentEquals("a = ")) {
                this.a = Integer.parseInt(line.substring(4));
            } else if (line.substring(0,3).contentEquals("b = ")) {
                this.b = Integer.parseInt(line.substring(4));
            } else if (line.substring(0,3).contentEquals("c = ")) {
                this.c = Integer.parseInt(line.substring(4));
            }
        } else {
            // getting the data which we got from our views and test if it is a variable.
            String test = line.substring(0, 3);
            if (test.contentEquals("a = ")) {
                // retrieve the value which was reported back and update our own fields.
                this.a = Integer.parseInt(line.substring(4));

            }

            // updating the test to get the next results.
            test = line.substring(6, 9);
            if (test.contentEquals("b = ")) {
                // retrieve the value which was reported back and update our own fields.
                this.b = Integer.parseInt(line.substring(10));

            }

            // updating the test to get the next results.
            test = line.substring(12, 15);
            if (test.contentEquals("c = ")) {
                // retrieve the value which was reported back and update our own fields.
                this.c = Integer.parseInt(line.substring(16));
            }
        }
    }

    /**
     * prints the current status into the commandline if something has changed.
     */
    private void printStatus() {
        StringBuilder sb = new StringBuilder();

        // check every variable and append it.
        String part;
        if (this.a != 0) {
            part = "a = " + this.a + ",";
        } else {
            part = "a = 0,";
        }
        sb.append(part);

        if (this.b != 0) {
            part = "b = " + this.b + ",";
        } else {
            part = "b = 0,";
        }
        sb.append(part);

        if (this.c != 0) {
            part = "c = " + this.c;
        } else {
            part = "c = 0";
        }
        sb.append(part);

        // print it
        String status = sb.toString();
        System.out.println(status);
    }
}
