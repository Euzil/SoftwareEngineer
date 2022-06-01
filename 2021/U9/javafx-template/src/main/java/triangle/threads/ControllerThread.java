package triangle.threads;

import triangle.TriangleController;

public class ControllerThread extends Thread{
    TriangleController controller;

    public ControllerThread(TriangleController controller) {
        this.controller = controller;
    }

    public void run() {
        try {
            this.controller.reader();
            String message = this.controller.solve();
            // post the message in the commandline
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("Exception in Controller.");
        }
    }
}
