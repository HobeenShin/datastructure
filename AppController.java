
public class AppController {

	private AppView		_appView;
	private Board		_board;
	private MagicSquare	_magicSquare;
	
	public AppController()
	{
		this._appView = new AppView();
		this._board = null;
		this._magicSquare = new MagicSquare();
		
	}
	
	public void run()
	{
		this.showMessage(MessageID.Notice_BeginMagicSquare);
		OrderValidity currentOrderValidity;
		
		int order = this._appView.inputOrder();
		while(order > 0)
		{
			currentOrderValidity = this._magicSquare.checkOrderValidity(order);
			if(currentOrderValidity == OrderValidity.Valid)
			{
				this._appView.outputTitleWithOrder(order);
				this._board = this._magicSquare.solve(order);
				this.showBoard(this._board);
			}
			else {
				this.showOrderValidityErrorMessage(currentOrderValidity);
			}
			order = this._appView.inputOrder();
		}
		this.showMessage(MessageID.Notice_EndMagicSquare);
	}
	private void showMessage(MessageID aMessageID)
	{
		switch(aMessageID)
		{
		case Notice_BeginMagicSquare:
			this._appView.outputLine("<<<Start MagicSquare!>>>");
			break;
		case Notice_EndMagicSquare:
			this._appView.outputLine("<End of MagicSquare!>");
			break;
		case Error_OrderIsTooSmall:
			this._appView.outputLine("Error: Order is TooSmall. Order is larger than 2");
			break;
		case Error_OrderIsTooLarge:
			this._appView.outputLine("Error: Order is TooLarge. Order is smaller than 100");
			break;
		case Error_OrderIsNotOddNumber:
			this._appView.outputLine("Error: Order is even number. Order must be odd number");
		default:
			break;
		}
	}
	private void showOrderValidityErrorMessage(OrderValidity anOrderValidity)
	{
		switch(anOrderValidity)
		{
		case TooSmall:
			this.showMessage(MessageID.Error_OrderIsTooSmall);
			break;
		case TooLarge:
			this.showMessage(MessageID.Error_OrderIsTooLarge);
			break;
		case NotOddNumber:
			this.showMessage(MessageID.Error_OrderIsNotOddNumber);
			break;
		default:
			break;
		}
	}
	private void showBoard(Board aBoard)
	{
		CellLocation currentLoc = new CellLocation();
		this.showTitleForColumnNumbers(aBoard.order());
		for(int i=0;i<aBoard.order();i++)
		{
			this._appView.outputRowNumber(i);
			for(int j=0;j<aBoard.order();j++)
			{
				currentLoc.setRow(i);
				currentLoc.setCol(j);
				this._appView.outputCell(aBoard.cell(currentLoc));
			}
			this._appView.outputLine("");
		}
	}
	private void showTitleForColumnNumbers(int anOrder)
	{
		this._appView.outputLine("  ");
		for(int col = 0; col < anOrder;col++)
		{
			this._appView.output(String.format("[%2d]", col));
		}
		this._appView.outputLine("");
	}
	
}
