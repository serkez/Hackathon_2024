public class TetShape {
    String id;
    boolean[][] array;
    int priority;

    public TetShape(boolean[][] shape, String id) {
        this.array = shape;
        this.id = id;
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

    public static boolean[][] rotateCW(boolean[][] arr) {
        final int M = arr.length;
        final int N = arr[0].length;
        boolean[][] rotated = new boolean[N][M];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                rotated[c][M-1-r] = arr[r][c];
            }
        }
        return rotated;
    }
//
//   @Override
//   public String toString(){
//
//   }

    public static void main(String[] args) {
        boolean[][] array = {{false, true, false}, {false, false, true}, {true, false, true}, {true, true, false}};

        for (boolean[] row : array) {
            for (boolean val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        System.out.println();
        boolean[][] newArray = rotateCW(array);
        System.out.println();

        for (boolean[] row : newArray) {
            for (boolean val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}
