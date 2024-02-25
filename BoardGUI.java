import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


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

        int x = shape.getxCoord() * cellSize;
        int y = shape.getyCoord() * cellSize;

        for (boolean[] row : shape.getArray()) {
            for (boolean cell : row) {
                if (cell) {
                    g.fillRect(x, y, cellSize, cellSize);
                }
                x += cellSize; // Move to the next column
            }
            x = shape.getxCoord() * cellSize; // Reset x-coordinate to the starting column
            y += cellSize; // Move to the next row
        }
    }




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        // Example polyominoe
//        TetShape Line_SHAPE = new TetShape(new boolean[][]{
//                {true, false},
//                {true, false},
//                {true, false}
//        }, "Line");
//
//        TetShape up_L_SHAPE = new TetShape(new boolean[][]{
//                {true, true},
//                {true, false},
//                {true, false}
//        }, "up-L");


        ArrayList<TetShape> shapeList = new ArrayList<>();
        shapeList.add(new TetShape("1"));
        shapeList.add(new TetShape("2"));

        Packer packer = new Packer(height,width);
        packer.addShapeToPack(shapeList.get(0));
        packer.addShapeToPack(shapeList.get(1));

        packer.pack();

        // Draw polyominoes
        drawShape(g, shapeList.get(0), Color.BLUE);
        drawShape(g, shapeList.get(1), Color.PINK);

    }
}


