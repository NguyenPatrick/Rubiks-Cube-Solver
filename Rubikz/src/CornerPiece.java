public class CornerPiece {
	
	// values for  all sides of a corner piece
	private static final int bottom = 0;
	private static final int front = 1;
	private static final int right = 2;
	private static final int back = 3;
	private static final int left = 4;
	private static final int top = 5;
	
	private static final int ref1Num = 0;
	private static final int ref2Num = 1;
	private static final int ref3Num = 2;
	private static final int ref4Num = 3;
	private static final int ref5Num = 4;
	private static final int ref6Num = 5;
	private static final int ref7Num = 6;
	private static final int ref8Num = 7;
	
	// reference number for making moves
	private int _refNumber;	
	// six sides for each cube (even though some colors are empty) at least
	// 3 colors are displayed each time & the color positioning changes
	private String[] _allColours = new String[6];
	
	
	// http://stackoverflow.com/questions/7772068/method-to-limit-potential-values-of-an-enum
	

	protected String[] getAllColors()
	{
	    return this._allColours;
	}
	
	protected void changeAllColors(String[] newColors)
	{
	    this._allColours = newColors;
	}
	
	// changes refNum
	protected void changeRefNumber(int newRefNum)
	{
		this._refNumber = newRefNum;
	}
	public int getRefNumber()
	{
		return this._refNumber;
	}
	
	public void addColour(int refNum) //String[] threeColors, 
	{	
		 
		// right spin up x2
		 if (refNum == ref1Num)
			{
				// [0], [1], [4] should be the only values filled
				this._allColours[bottom] = "W"; // bottom
				this._allColours[front] = "R"; // front
				this._allColours[left] = "B"; // left
			}
			else if (refNum == ref2Num)
			{
				// [0], [1], [2] should be the only values filled
				this._allColours[bottom] = "Y"; // bottom
				this._allColours[front] = "O"; // front
				this._allColours[right] = "G"; // right
			}
			else if (refNum == ref3Num)
			{
				// [0], [3], [2] should be the only values filled
				this._allColours[bottom] = "Y"; // bottom
				this._allColours[back] = "R"; // back
				this._allColours[right] = "G"; // right
			}
			else if (refNum == ref4Num)
			{
				// [0], [3], [4] should be the only values filled
				this._allColours[bottom] = "W"; // bottom
				this._allColours[back] = "O"; // back
				this._allColours[left] = "B"; // left
			}
		   if (refNum == ref5Num)
			{
				// [5], [1], [4] should be the only values filled
				this._allColours[top] = "Y"; // top
				this._allColours[front] = "R"; // front
				this._allColours[left] = "B"; // left
			}
			else if (refNum == ref6Num)
			{
				// [5], [1], [2] should be the only values filled
				this._allColours[top] = "W"; // top
				this._allColours[front] = "O"; // front
				this._allColours[right] = "G"; // right
			}
			else if (refNum == ref7Num)
			{
				// [5], [3], [2] should be the only values filled
				this._allColours[top] = "W"; // top
				this._allColours[back] = "R"; // back
				this._allColours[right] = "G"; // right
			}
			else if (refNum == ref8Num)
			{
				// [5], [3], [4] should be the only values filled
				this._allColours[top] = "Y"; // top
				this._allColours[back] = "O"; // back
				this._allColours[left] = "B"; // left
			} 

	}
	
	// cube constructor --> constructs original cube pieces
	// everything is with reference to the cube having the top color as "yellow", the bottom color
	// as "white" and the front color as "red"
	public CornerPiece(int refNum)
	// public CornerPiece(int refNum, String firstColour, String secondColour, String thirdColour)
	{
		this._refNumber = refNum; // declares reference number of the cube	
	}
}