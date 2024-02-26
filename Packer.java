//
//import java.util.*;
//
//public class Packer {
//
//    Queue<TetShape> shapeQueue = new ArrayDeque<>();
//    Grid grid;
//
//
//    public Packer(int length, int width){
//        grid = new Grid(length, width);
//    }
//
//    public void addShapeToPack(TetShape shape){
//        shapeQueue.add(shape);
//    }
//
//    public void pack(){
//        TetShape shape = shapeQueue.remove();
//        while (shape != null){
//            boolean placed = grid.placeShape(shape);
//
//            if(!placed){
//                shapeQueue.add(shape);
//            }
//            if(!shapeQueue.isEmpty())
//                shape = shapeQueue.remove();
//            else
//                shape = null;
//        }
//        System.out.println("All shapes finished!");
//    }
//
//
//}
