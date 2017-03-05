
public class CellLocation {

	private int _row;
	private int _col;
	
	public CellLocation() 
	{
		this._row = -1;
		this._col = -1;
	}
	
	public CellLocation(int givenRow, int givenCol)
	{
		this._row = givenRow;
		this._col = givenCol;
	}
	public void setRow(int newRow)
	{
		this._row = newRow;
	}
	public int row()
	{
		return this._row;
	}
	public void setCol(int newCol)
	{
		this._col = newCol;
	}
	public int col()
	{
		return this._col;
	}
}

