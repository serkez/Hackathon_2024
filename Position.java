import java.util.Arrays;
import java.util.Objects;

public abstract class Position {

	private int row;
	private int col;

	public Position(char row, char col){
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public String toString() {
		return "" + row + col;
	}




	
}