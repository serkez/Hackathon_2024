import javax.swing.*;
import java.awt.*;

public class GUI {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(GUI::createAndShowGUI);
        }

        private static void createAndShowGUI() {
            JFrame frame = new JFrame("Polyomino and Polycube Shapes");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new BoardGUI(10, 10, 30));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }

