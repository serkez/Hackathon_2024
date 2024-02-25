import java.util.Queue;

public class Grid {
    private int[][] space;
    public Grid(int length, int width){
        boolean[][] space = new boolean[length][width];
    }
    public boolean placeShape(Queue<TetShape> shape){

        return true;
    }


}
/*
public class Grid {
    private int[][] space;

    public Grid(int length, int width) {
        space = new int[length][width];
    }

    public boolean placeShape(TetShape shape, int x, int y) {
        boolean[][] boolArrShape = shape.toBooleanArray();
        if (canPlaceShape(boolArrShape, x, y)) {
            for (int i = 0; i < boolArrShape.length; i++) {
                for (int j = 0; j < boolArrShape[0].length; j++) {
                    if (boolArrShape[i][j]) {
                        space[x + i][y + j] = 1; // Assuming 1 represents the shape on the grid
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean canPlaceShape(boolean[][] boolArrShape, int x, int y) {
        // Check if the shape can be placed without overlapping existing shapes or going out of bounds
        if (x < 0 || x + boolArrShape.length > space.length || y < 0 || y + boolArrShape[0].length > space[0].length) {
            return false;
        }
        for (int i = 0; i < boolArrShape.length; i++) {
            for (int j = 0; j < boolArrShape[0].length; j++) {
                if (boolArrShape[i][j] && space[x + i][y + j] != 0) { // Assuming 0 represents empty space on the grid
                    return false;
                }
            }
        }
        return true;
    }
}
*/
