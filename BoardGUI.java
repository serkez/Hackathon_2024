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

    void drawShape(Graphics g, TetShape shape, Color color) {
        g.setColor(color);

        int x = shape.getCoordinates()[0];
        int y = shape.getCoordinates()[1];

        for (boolean[] row: shape.getArray()) {
            for(boolean cell: row){
                if(cell){
                    g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                }
                y++;
            }
            x++;
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Example polyominoe
        TetShape Line_SHAPE = new TetShape(new boolean[][]{
                {true, false},
                {true, false},
                {true, false}
        }, "Line");

        TetShape up_L_SHAPE = new TetShape(new boolean[][]{
                {true, true},
                {true, false},
                {true, false}
        }, "up-L");


        Packer packer = new Packer(height,width);
        packer.addShapeToPack(Line_SHAPE);
        packer.addShapeToPack(up_L_SHAPE);

        packer.pack();

        // Draw polyominoes
       // drawShape(g, Line_SHAPE, Color.BLUE);
        drawShape(g, up_L_SHAPE, Color.PINK);

    }
}

