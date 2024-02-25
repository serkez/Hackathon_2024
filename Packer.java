
import java.util.*;

public class Packer {

    Queue<TetShape> shapeQueue = new ArrayDeque<>();
    Grid grid;


    public Packer(int length, int width){
        grid = new Grid(length, width);
    }
    
    public void pack(){
        TetShape shape = shapeQueue.remove();
        
    }


}
