package triangle;

import triangle.threads.CliThread;
import triangle.threads.ControllerThread;
import triangle.threads.WindowThread;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TriangleModel model = new TriangleModel(0,0,0);
        TriangleController ctrler = new TriangleController(model);
        ControllerThread controller = new ControllerThread(ctrler);
        WindowThread gui = new WindowThread(args);
        CliThread cli = new CliThread();
        controller.start();
        cli.start();
        gui.start();

        while (true) {
            try {
                // TODO scan the input in the commandLine here.
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                System.out.println(message);

                // TODO give message to the gui.

            } catch (Exception exception) {
                System.out.println("Exception occoured!");
            }

            // TODO try to get past our gui run or let something run parallel to it.
        }

    }
}
