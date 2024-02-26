import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GridProgram extends JFrame {
    private final int GRID_WIDTH = 10;
    private final int GRID_HEIGHT = 10;
    private final int CELL_SIZE = 30;
    private final Color[] SHAPE_COLORS = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};

    private JPanel gridPanel;
    private JPanel controlPanel;
    private JButton placeShapeButton;
    private Grid grid;

    public GridProgram() {
        setTitle("Grid Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        grid = new Grid(GRID_WIDTH, GRID_HEIGHT);

        gridPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGrid(g);
            }
        };
        gridPanel.setPreferredSize(new Dimension(GRID_WIDTH * CELL_SIZE, GRID_HEIGHT * CELL_SIZE));

        controlPanel = new JPanel();
        placeShapeButton = new JButton("Place Shape");
        placeShapeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeRandomShape();
                gridPanel.repaint();
            }
        });
        controlPanel.add(placeShapeButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(gridPanel, BorderLayout.CENTER);
        getContentPane().add(controlPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void drawGrid(Graphics g) {
        int[][] board = grid.getBoard();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                int cellValue = board[y][x];
                Color color = getColorForCellValue(cellValue);
                g.setColor(color);
                g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        // Draw outlines around shapes
        g.setColor(Color.BLACK);
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                int cellValue = board[y][x];
                if (cellValue != 0) { // Found a shape
                    // Draw outline around the shape
                    g.drawRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE - 1, CELL_SIZE - 1);
                }
            }
        }
    }




    private Color getColorForCellValue(int cellValue) {
        if (cellValue == 0) {
            return Color.WHITE;
        } else {
            return SHAPE_COLORS[cellValue - 1];
        }
    }

    private void placeRandomShape() {
        Random random = new Random();
        int shapeId = random.nextInt(SHAPE_COLORS.length) + 1; // Shape ID starts from 1
        TetShape shape = TetShapeFactory.createShape(shapeId);

        int bestX = 0;
        int bestY = GRID_HEIGHT - shape.getHeight();

        int minEmptyCells = Integer.MAX_VALUE;

        for (int x = 0; x <= GRID_WIDTH - shape.getWidth(); x++) {
            for (int y = GRID_HEIGHT - shape.getHeight(); y >= 0; y--) {
                if (grid.canPut(shape, x, y)) {
                    int emptyCells = countEmptyCells(shape, x, y);
                    if (emptyCells < minEmptyCells) {
                        minEmptyCells = emptyCells;
                        bestX = x;
                        bestY = y;
                    }
                }
            }
        }

        grid.putShape(shape, bestX, bestY);
    }

    private int countEmptyCells(TetShape shape, int x, int y) {
        int emptyCells = 0;
        boolean[][] array = shape.getArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (!array[i][j] && grid.getBoard()[y + i][x + j] == 0) {
                    emptyCells++;
                }
            }
        }
        return emptyCells;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GridProgram();
            }
        });
    }
}
