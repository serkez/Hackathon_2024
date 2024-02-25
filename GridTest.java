import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {


    @Test
    void CoordinatesWork(){
        Packer packer = new Packer(10,10);
        TetShape shape = new TetShape("jump");
        packer.addShapeToPack(shape);
        packer.pack();
        int x = shape.getCoordinates()[0];
        int y = shape.getCoordinates()[1];

        for (boolean[] row: shape.getArray()) {
            for(boolean cell: row){
                if(cell){
                    System.out.println(x + " , " + y);
                }
                x++;
                y++;
            }
        }
        assertNotNull(shape.getCoordinates());
    }
}