public class TetShape {
    String id;
    boolean[][] shape;
    public TetShape(boolean[][] shape, String id){
        this.shape = shape;
        this.id = id;
    }

    public static final TetShape L_SHAPE = new TetShape(new boolean[][]{
            {true, false},
            {true, false},
            {true, true}
    }, "L");

    public Shape rotateRigth(TetShape shape) {
        
    }
}
