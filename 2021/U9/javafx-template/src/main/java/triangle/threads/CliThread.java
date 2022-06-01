package triangle.threads;

import triangle.views.CommandLineView;

public class CliThread extends Thread {
    private CommandLineView cli;

    public CliThread() {
        this.cli = new CommandLineView();
    }

    public void run() {
        try {
            while (true) {
                this.cli.reads();
            }
        } catch (Exception e) {
            System.out.println("Exception in CLI.");
        }
    }
}
