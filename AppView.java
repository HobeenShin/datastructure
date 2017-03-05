import java.util.Scanner;

public class AppView {

	private Scanner		_scanner;
	
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	public int inputOrder()
	{
		int _order = _scanner.nextInt();
		return _order;
	}
	
	public void output(String aString)
	{
		System.out.print(aString);
	}
	public void outputLine(String aString)
	{
		System.out.println(aString);
	}
	public void outputTitleWithOrder(int anOrder)
	{
		System.out.println("<<<마방진풀이를 시작합니다.>>>");
		System.out.printf("마방진 차수를 입력하시오(음수를 입력하면 종료합니다):[%3d]",anOrder);
	}
	public void outputRowNumber(int aRowNumber)
	{
		System.out.printf("[%3d] ", aRowNumber);
	}
	public void outputCell(int anElement)
	{
		System.out.printf("[%3d]", anElement);
	}
}
