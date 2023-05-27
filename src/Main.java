import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Window view = new Window("Restaurant soft");
                Controller controller = new Controller(view);
            }
        });
    }
}