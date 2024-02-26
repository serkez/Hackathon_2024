import javax.swing.*;

public class ClientCode {
    public static void main(String[] args) {


        SwingUtilities.invokeLater(ClientCode::createAndShowGUI);

    }


    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Packing Polyominoes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new BoardGUI(8, 8, 30));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
