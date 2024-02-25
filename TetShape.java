public class TetShape {
    String id;
    boolean[][] array;
    int priority;
    int[][] coordinates;

    public TetShape(boolean[][] shape, String id) {
        this.array = shape;
        this.id = id;
    }
    public void setCoordinates(int[][] coordinates){
        this.coordinates = coordinates;
    }
    public boolean[][] getArray() {
        return this.array;
    }

    public String getId() {
        return this.id;
    }

    public static final TetShape L_SHAPE = new TetShape(new boolean[][]{
            {true, false},
            {true, false},
            {true, true}
    }, "L");

    public static final TetShape Line_SHAPE = new TetShape(new boolean[][]{
            {true, false},
            {true, false},
            {true, false}
    }, "Line");

    public static final TetShape up_L_SHAPE = new TetShape(new boolean[][]{
            {true, true},
            {true, false},
            {true, false}
    }, "up-L");

    public static final TetShape sideT_SHAPE = new TetShape(new boolean[][]{
            {true, false},
            {true, true},
            {true, false}
    }, "sideT");

    public static final TetShape sideU_SHAPE = new TetShape(new boolean[][]{
            {true, true},
            {true, false},
            {true, true}
    }, "sideU");

    public static final TetShape FourLine_SHAPE = new TetShape(new boolean[][]{
            {true, false},
            {true, false},
            {true, false},
            {true, false}
    }, "4Line");



    public static TetShape rotateCW(TetShape tetShape) {
        boolean[][] arr = tetShape.getArray();
        final int M = arr.length;
        final int N = arr[0].length;
        boolean[][] rotated = new boolean[N][M];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                rotated[c][M-1-r] = arr[r][c];
            }
        }
        tetShape.setArray(rotated);
        return tetShape;
    }
//
//   @Override
//   public String toString(){
//
//   }

    public static void main(String[] args) {
        boolean[][] array = {{false, true, false}, {false, false, true}, {true, false, true}, {true, true, false}};
        TetShape tetShape = new TetShape(array, "1234");
        for (boolean[] row : array) {
            for (boolean val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        System.out.println();
        tetShape = new rotateCW(tetShape);
        System.out.println();

        for (boolean[] row : tetShape.getArray()) {
            for (boolean val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }



}
