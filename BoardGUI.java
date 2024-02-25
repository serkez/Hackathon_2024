import javax.swing.*;
import java.awt.*;

class BoardGUI extends JPanel {
    private int width;
    private int height;
    private int cellSize;

    BoardGUI(int width, int height, int cellSize) {
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;
        setPreferredSize(new Dimension(width * cellSize, height * cellSize));
    }

    void drawShape(Graphics g, int[][] shape, Color color) {
        g.setColor(color);
        for (int[] coord : shape) {
            int x = coord[0] * cellSize;
            int y = coord[1] * cellSize;
            g.fillRect(x, y, cellSize, cellSize);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, cellSize, cellSize);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Example polyominoe
        TetShape polyomino1 = new TetShape(new boolean[][]{{true,false}, {0, 1}, {1, 0}}, id);

        TetShape polyomino2 = new TetShape(new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 1}});

        // Example polycubes
        Polycube polycube1 = new Polycube(new int[][]{{0, 0, 0}, {0, 0, 1}, {0, 0, 2}, {0, 1, 1}});
        Polycube polycube2 = new Polycube(new int[][]{{0, 0, 0}, {1, 0, 0}, {1, 1, 0}, {0, 1, 0}});

        // Draw polyominoes
        drawShape(g, polyomino1.shape, Color.BLUE);
        drawShape(g, polyomino2.shape, Color.BLUE);

        // Draw polycubes
        drawShape(g, polycube1.shape, Color.RED);
        drawShape(g, polycube2.shape, Color.RED);
    }
}

