import java.util.Queue;
public class Grid {
    private boolean[][] board;
    int xCounter;
    int yCounter;

    public Grid(int length, int width) {
        board = new boolean[length][width];
        xCounter = 0;
        yCounter = 0;
    }

    public boolean placeShape(TetShape shape) {
        int xCoord = xCounter;
        int yCoord = yCounter;
        if (canPut(shape, xCoord, yCoord)) {
            putShape(shape, xCoord, yCoord);
            return true;
        }
        return false;
    }

    public boolean placeShape2(TetShape shape) {
        int xCoord = xCounter;
        int yCoord = yCounter;
        while (!canPut(shape, xCoord, yCoord)) {
            if (xCoord < board[0].length)
                xCoord++;
            else if (yCoord < board.length) {
                yCoord++;
            } else {
                return false;
            }
        }
        return true;
    }
/*
    public boolean canPut(TetShape shape, int x, int y){
             boolean[][] array = shape.getArray();
             for (int i = 0; i < (array.length); i++){
                 for (int j = 0; j < ( array[0].length); j++) {
                     if(array[i][j] && board[y+i][x+j]) //if our shape has this box and there is already something there return false
                         return false;
                 }
             }
             return true;
         }
         */
/*
    public boolean canPut(TetShape shape, int x, int y) {
        boolean[][] array = shape.getArray();
        int shapeWidth = array[0].length;
        int shapeHeight = array.length;

        // Check if the shape exceeds the grid boundaries
        if (x < 0 || y < 0 || x + shapeWidth > board[0].length || y + shapeHeight > board.length) {
            return false;
        }

        // Check if the shape overlaps with any other shape on the grid
        for (int i = 0; i < shapeHeight; i++) {
            for (int j = 0; j < shapeWidth; j++) {
                if (array[i][j] && board[y + i][x + j]) {
                    return false;
                }
            }
        }

        return true;
    }

 */
public boolean canPut(TetShape shape, int x, int y) {
    boolean[][] array = shape.getArray();
    int shapeWidth = array[0].length;
    int shapeHeight = array.length;

    // Check if the shape exceeds the grid boundaries
    if (x < 0 || y < 0 || x + shapeWidth > board[0].length || y + shapeHeight > board.length) {
        return false;
    }

    // Check if the shape overlaps with any other shape on the grid
    for (int i = 0; i < shapeHeight; i++) {
        for (int j = 0; j < shapeWidth; j++) {
            if (array[i][j] && board[y + i][x + j]) {
                return false;
            }
        }
    }

    return true;
}



    public void putShape(TetShape shape, int x, int y) {
        shape.setCoordinates(x, y);
        boolean[][] array = shape.getArray();
        for (int i = 0; i < (array.length); i++) {

            for (int j = 0; j < (array[0].length); j++) {
                if(array[i][j]) {
                    board[y + i][x + j] = true;
                    yCounter = y + i;
                    xCounter = x + j;
                }
            }
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (boolean[] row : board) {
            for (boolean b : row) {
                sb.append(b ? "1" : "0").append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
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
