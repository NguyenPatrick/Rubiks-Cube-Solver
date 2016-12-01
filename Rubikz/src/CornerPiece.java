// case 1 case 2 case 3
public class CornerPiece {
	
	// private properties
	private int _refNumber;
	// six sides for each cube (even though some colors are empty)
	private String[] _allColours = new String[6];
	

	// changes refNum
	protected void changeRefNumber(int newRefNum)
	{
		this._refNumber = newRefNum;
	}
	
	
	// cube constructor --> constructs original cube pieces
	// everything is with reference to the cube having the top color as "yellow", the bottom color
	// as "white" and the front color as "red"
	public CornerPiece(int refNum)
	// public CornerPiece(int refNum, String firstColour, String secondColour, String thirdColour)
	{
		// declares reference number of the cube
		this._refNumber = refNum;	
		
		// _allColours[0] = bottom, 
		// _allColours[1] = front,
		// _allColours[2] = right
	    // _allColours[3] = back
		// _allColours[4] = left
		// _allColours[5] = top
		
		// bottom half 
		if (refNum == 1)
		{
			// [0], [1], [4] should be the only values filled
			this._allColours[0] = "White"; // bottom
			this._allColours[1] = "Red"; // front
			this._allColours[4] = "Blue"; // left
		}
		else if (refNum == 2)
		{
			// [0], [1], [2] should be the only values filled
			this._allColours[0] = "White"; // bottom
			this._allColours[1] = "Red"; // front
			this._allColours[2] = "Green"; // right
		}
		else if (refNum == 3)
		{
			// [0], [3], [2] should be the only values filled
			this._allColours[0] = "White"; // bottom
			this._allColours[3] = "Orange"; // back
			this._allColours[2] = "Green"; // right
		}
		else if (refNum == 4)
		{
			// [0], [3], [4] should be the only values filled
			this._allColours[0] = "White"; // bottom
			this._allColours[3] = "Orange"; // back
			this._allColours[4] = "Blue"; // left
		}
		
		// _allColours[0] = bottom, 
		// _allColours[1] = front,
		// _allColours[2] = right
	    // _allColours[3] = back
		// _allColours[4] = left
		// _allColours[5] = top
		
		// top half 
		if (refNum == 5)
		{
			// [5], [1], [4] should be the only values filled
			this._allColours[5] = "Yellow"; // top
			this._allColours[1] = "Red"; // front
			this._allColours[4] = "Blue"; // left
		}
		else if (refNum == 6)
		{
			// [5], [1], [2] should be the only values filled
			this._allColours[5] = "Yellow"; // top
			this._allColours[1] = "Red"; // front
			this._allColours[2] = "Green"; // right
		}
		else if (refNum == 7)
		{
			// [5], [3], [2] should be the only values filled
			this._allColours[5] = "Yellow"; // top
			this._allColours[3] = "Orange"; // back
			this._allColours[2] = "Green"; // right
		}
		else if (refNum == 8)
		{
			// [5], [3], [4] should be the only values filled
			this._allColours[5] = "Yellow"; // top
			this._allColours[3] = "Orange"; // back
			this._allColours[4] = "Blue"; // left
		}
	}
}

