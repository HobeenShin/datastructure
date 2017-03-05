
public class MagicSquare {


	private static int DEFAULT_MAX_ORDER = 99;
	
	private int			_maxOrder;
	private int 		_order;
	private Board		_board;
	
	public int maxOrder()
	{
		return this._maxOrder;
	}
	
	public int order()
	{
		return this._order;
	}
	
	public MagicSquare()
	{
		this._maxOrder = MagicSquare.DEFAULT_MAX_ORDER;
		this._order = 3;
		this._board = null;
	}
	
	public MagicSquare(int givenMaxOrder)
	{
		this._maxOrder = givenMaxOrder;
		this._order = 3;
		this._board = null;
	}
	
	public Board solve(int anOrder)
	{
		this._order = anOrder;
		if (this.checkOrderValidity(anOrder) != OrderValidity.Valid)
		{
			return null;
		}
		else {
			this._board = new Board(this._order);
			CellLocation currentLoc = new CellLocation(0,this._order/2);
			CellLocation nextLoc = new CellLocation();
			
			this._board.setCell (currentLoc, 1);
			int lastNumber = this._order*this._order;
			for ( int number = 2; number < lastNumber; number++){
								
				if (!this._board.cellIsEmpty(nextLoc))
				{
					currentLoc.setRow(nextLoc.row()+1);
					currentLoc.setCol(nextLoc.col());
				}
				currentLoc.setRow(nextLoc.row());
				currentLoc.setCol(nextLoc.col());
				this._board.setCell(currentLoc, number);
			} // I need to change this code.
			return this._board;
		}
	} 
	

	public OrderValidity checkOrderValidity(int order) {
		// TODO Auto-generated method stub
		if (order < 3) {
			
			return OrderValidity.TooSmall;
		}
		else if (order > 99) {
			
			return OrderValidity.TooLarge;
		}
		else {
			if (order%2 ==1 )
			{ 
				return OrderValidity.Valid; 
			}
			else
			{
				return OrderValidity.NotOddNumber;
			}
		}
	}

}
