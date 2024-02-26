

class Grid {
    private int[][] board;

    public Grid(int width, int height) {
        board = new int[height][width];
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean canPut(TetShape shape, int x, int y) {
        boolean[][] array = shape.getArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] && (x + j < 0 || x + j >= board[0].length || y + i < 0 || y + i >= board.length || board[y + i][x + j] != 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void putShape(TetShape shape, int x, int y) {
        boolean[][] array = shape.getArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j]) {
                    board[y + i][x + j] = shape.getId();
                }
            }
        }
    }
}

class TetShape {
    private boolean[][] shapeArray;
    private int id;

    public TetShape(boolean[][] shapeArray, int id) {
        this.shapeArray = shapeArray;
        this.id = id;
    }

    public boolean[][] getArray() {
        return shapeArray;
    }

    public int getWidth() {
        return shapeArray[0].length;
    }

    public int getHeight() {
        return shapeArray.length;
    }

    public int getId() {
        return id;
    }
}

class TetShapeFactory {
    public static TetShape createShape(int id) {
        boolean[][] shapeArray;
        switch (id) {
            case 1:
                // Square shape
                shapeArray = new boolean[][]{{true, true}, {true, true}};
                break;
            case 2:
                // L shape
                shapeArray = new boolean[][]{{true, false}, {true, false}, {true, true}};
                break;
            // Add more shapes as needed
            default:
                shapeArray = new boolean[][]{{true}};
        }
        return new TetShape(shapeArray, id);
    }
}
