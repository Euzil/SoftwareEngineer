package triangle.views;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class WindowView extends Application {
    private int a;
    private int b;
    private int c;
    private String solution = "";


    public void run(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculate your triangle!");

        // creating first TextField.
        Label label1 = new Label("a:");
        NumberField side1 = new NumberField();
        // creating second TextField.
        Label label2 = new Label("b:");
        NumberField side2 = new NumberField();
        // creating third TextField.
        Label label3 = new Label("c:");
        NumberField side3 = new NumberField();

        // handling the events for every field
        side1.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // update the variables.
                checkNumberFields(side1, side2, side3);
                /*
                 * print out status informations in the commandline to
                 * tell the controller that something has changed.
                 */
                printStatus();
            }
        });

        side2.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // update the variables.
                checkNumberFields(side1, side2, side3);
                /*
                 * print out status informations in the commandline to
                 * tell the controller that something has changed.
                 */
                printStatus();
            }
        });

        side3.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // update the variables.
                checkNumberFields(side1, side2, side3);
                /*
                 * print out status informations in the commandline to
                 * tell the controller that something has changed.
                 */
                printStatus();
            }
        });

        // creating the output-field.
        Label labelS1 = new Label("Lösung:");
        Label labelS2 = new Label(this.solution);
        // TODO watch if the solution is displayed.

        TilePane root = new TilePane();
        root.getChildren().add(label1);
        root.getChildren().add(side1);
        root.getChildren().add(label2);
        root.getChildren().add(side2);
        root.getChildren().add(label3);
        root.getChildren().add(side3);
        root.getChildren().add(labelS1);
        root.getChildren().add(labelS2);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
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
     * sets the value for our attribute solution
     * @param solution the message which will be displayed.
     */
    public void setSolution(String solution) {
        this.solution = solution;
    }

    /**
     * prints the current status into the commandline if something has changed.
     */
    private void printStatus() {
        System.out.println("");
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

    /**
     * checks every value in each field and updates our view according to it's results.
     * @param side1 our first NumberField.
     * @param side2 our second NumberField.
     * @param side3 our third NumberField.
     */
    private void checkNumberFields(NumberField side1, NumberField side2, NumberField side3) {
        // updating the a-variable.
        if (side1.getText().equals("")) {
            setA(0);
        } else {
            int a = Integer.parseInt(side1.getText());
            setA(a);
        }

        // update the b-variable.
        if (side2.getText().equals("")) {
            setB(0);
        } else {
            int b = Integer.parseInt(side2.getText());
            setB(b);
        }

        // update the c-variable.
        if (side3.getText().equals("")) {
            setC(0);
        } else {
            int c = Integer.parseInt(side3.getText());
            setC(c);
        }
    }

    /**
     * reads the input of the terminal and
     * executes the commands on the model-attributes.
     * @throws IOException
     */
    public void reader() throws IOException {
        // TODO print all in one line.
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

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

        // this is strict for debugging.
        System.out.println("Input read successfully.");
    }
}
