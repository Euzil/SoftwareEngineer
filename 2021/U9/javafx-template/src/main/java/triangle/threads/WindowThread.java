package triangle.threads;

import triangle.views.WindowView;

public class WindowThread extends Thread {
    private WindowView gui;
    private String[] args;

    public WindowThread(String[] args) {
        this.gui = new WindowView();
        this.args = args;
    }

    public void run() {
        try {
            // running the gui.
            this.gui.run(this.args);
        } catch (Exception e) {
            System.out.println("Exception in GUI.");
        }
    }
}
