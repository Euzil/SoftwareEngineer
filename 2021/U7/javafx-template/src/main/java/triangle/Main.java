package triangle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculate your triangle!");

        // creating first TextField.
        Label label1 = new Label("Länge der ersten Seite:");
        NumberField side1 = new NumberField();

        // creating second TextField.
        Label label2 = new Label("Länge der zweiten Seite:");
        NumberField side2 = new NumberField();

        // creating third TextField.
        Label label3 = new Label("Länge der dritten Seite:");
        NumberField side3 = new NumberField();

        // creating the output-field.
        Label labelS1 = new Label("Lösung:");
        Label labelS2 = new Label();

        // creating the button.
        Button btn = new Button();
        btn.setText("Absenden");
        btn.setAlignment(Pos.BOTTOM_CENTER);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // Get the integers we receive from the user.
                int int1 = Integer.parseInt(side1.getText());
                int int2 = Integer.parseInt(side2.getText());
                int int3 = Integer.parseInt(side3.getText());

                // calculate the triangle here and return the Output.
                Triangle triangle = new Triangle(int1, int2, int3);
                String solution = triangle.calculate();
                labelS2.setText(solution);
            }
        });

        TilePane root = new TilePane();
        root.getChildren().add(label1);
        root.getChildren().add(side1);
        root.getChildren().add(label2);
        root.getChildren().add(side2);
        root.getChildren().add(label3);
        root.getChildren().add(side3);
        root.getChildren().add(labelS1);
        root.getChildren().add(labelS2);
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
