import javax.swing.*;
import java.awt.*;

public class TetShapes extends JFrame {
    private int[][] grid;

    public TetShapes(int[][] grid) {
        this.grid = grid;
        setTitle("Grid Coloring");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int rows = grid.length;
        int cols = grid[0].length;

        int cellWidth = getWidth() / cols;
        int cellHeight = getHeight() / rows;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = grid[i][j];
                Color color = getColorForValue(value);
                g.setColor(color);
                g.fillRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
            }
        }
    }

    private Color getColorForValue(int value) {
        // Define your own color mapping logic here
        // This is a simple example, you can expand it based on your requirements
        switch (value) {
            case 0:
                return Color.WHITE;
            case 1:
                return Color.RED;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.BLUE;
            default:
                return Color.BLACK;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[5][5];


        SwingUtilities.invokeLater(() -> new TetShapes(grid));
    }
}
