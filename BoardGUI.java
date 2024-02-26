import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;


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


        Queue<TetShape> shapeList = new ArrayDeque<>();
        for (int i = 0; i < 12; i++) {
            shapeList.add(new TetShape("" + i));
        }
        Grid grid = new Grid(height, width);
        pack(g, shapeList, grid);





//
//        Packer packer = new Packer(height,width);
//
//        for (int i = 0; i < 3; i++) {
//            packer.addShapeToPack(shapeList.get(i));
//        }
//
//        Random rand = new Random();
//
//        packer.pack();
//
//        // Draw polyominoes
//        for (int i = 0; i < 3; i++) {
//            drawShape(g, shapeList.get(i), Color.getHSBColor(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
//
//        }


    }

    public void pack(Graphics g, Queue<TetShape> shapeQueue, Grid grid){
        long startTime = System.currentTimeMillis();
        int totalShapes = shapeQueue.size();
        int counter = 0;
        Random rand = new Random();
        TetShape shape = shapeQueue.remove();
        while (shape != null){
            boolean placed = grid.placeShape(shape);
            counter ++;
            if(placed){
                drawShape(g, shape, Color.getHSBColor(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
            }
            else {
                shapeQueue.add(shape);
            }
            if(!shapeQueue.isEmpty())
                shape = shapeQueue.remove();
            else
                shape = null;

            if(counter / 5 == 1){
                counter = 0;
                grid.switchPreferedIncrementer();
            }

            if(!shapeQueue.isEmpty() && System.currentTimeMillis() - startTime > 2 * 1000){
                System.out.println("Why can't you pack for me :( ");
                ClientCode.main(null);
                break;
            }
        }
        System.out.println("Goodbye!");
    }
}


