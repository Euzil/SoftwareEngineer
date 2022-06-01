package triangle;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class TriangleController {
    private TriangleModel model;

    public TriangleController(TriangleModel model) {
        this.model = model;
    }

    /**
     * checks if two sides of the triangle are equal in length.
     * @return boolean
     */
    private boolean gleichschenklig() {
        if (this.model.getA() == this.model.getB()) {
            return true;
        } else if (this.model.getB() == this.model.getC()) {
            return true;
        } else if (this.model.getC() == this.model.getA()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * checks if all sides of the triangle are equal in length.
     * @return boolean
     */
    private boolean gleichseitig() {
        if (this.model.getA() == this.model.getB() && this.model.getB() == this.model.getC()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * decides which solution-message to send.
     * @return message which states the solution.
     */
    public String solve() {
       if (gleichseitig()) {
           return "Dieses Dreieck ist gleichseitig.";
       } else if (gleichschenklig()) {
           return "Dieses Dreieck ist gleichschenklig.";
       } else {
           return "Dieses Dreieck ist ungleichseitig.";
       }
    }

    /**
     * reads the input of the terminal and
     * executes the commands on the model-attributes.
     * @throws IOException
     */
    public void reader() throws IOException {
        BufferedReader stream = new BufferedReader(new InputStreamReader(System.in));
        String line = stream.readLine();

        if (line.length() < 5) {
            // simply change that one value.
            if (line.substring(0,3).contentEquals("a = ")) {
                this.model.setA(Integer.parseInt(line.substring(4)));
            } else if (line.substring(0,3).contentEquals("b = ")) {
                this.model.setB(Integer.parseInt(line.substring(4)));
            } else if (line.substring(0,3).contentEquals("c = ")) {
                this.model.setC(Integer.parseInt(line.substring(4)));
            }
        } else {
            // getting the data which we got from our views and test if it is a variable.
            String test = line.substring(0, 3);
            if (test.contentEquals("a = ")) {
                // retrieve the value which was reported back.
                int value = Integer.parseInt(line.substring(4));
                // update our model.
                this.model.setA(value);
            }

            // updating the test to get the next results.
            test = line.substring(6, 9);
            if (test.contentEquals("b = ")) {
                // retrieve the value which was reported back.
                int value = Integer.parseInt(line.substring(10));
                // update our model.
                this.model.setA(value);
            }

            // updating the test to get the next results.
            test = line.substring(12, 15);
            if (test.contentEquals("c = ")) {
                // retrieve the value which was reported back.
                int value = Integer.parseInt(line.substring(16));
                // update our model.
                this.model.setA(value);
            }
        }
        stream.close();
    }
}
