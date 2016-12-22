/****************************************************************************
*
* Created by: Patrick Nguyen
* Created on: December 2016
* Corner Piece Class For The Rubiks Cube
*
****************************************************************************/

public class CornerPiece {
	
	// values for  all sides of a corner piece
	private static final int BOTTOM = 0;
	private static final int FRONT = 1;
	private static final int RIGHT = 2;
	private static final int BACK = 3;
	private static final int LEFT = 4;
	private static final int TOP = 5;
	
	private static final int REFNUM_1 = 0;
	private static final int REFNUM_2 = 1;
	private static final int REFNUM_3 = 2;
	private static final int REFNUM_4 = 3;
	private static final int REFNUM_5 = 4;
	private static final int REFNUM_6 = 5;
	private static final int REFNUM_7 = 6;
	private static final int REFNUM_8 = 7;
	
	// reference number for making moves
	private int _refNumber;	
	
	// six sides for each corner piece (even though some colors are empty) 
	// 3 colors are displayed each time & the sides of the colors will vary based on the move
	private String[] _allColours = new String[6];

	// gets all the colors of the corner piece
	protected String[] getAllColors()
	{
	    return this._allColours;
	}
	
	// changes color when a move is made
	protected void changeAllColors(String[] newColors)
	{
	    this._allColours = newColors;
	}
	
	// changes refNum when move is made
	protected void changeRefNumber(int newRefNum)
	{
		this._refNumber = newRefNum;
	}
	
	// gets refNum for usage
	public int getRefNumber()
	{
		return this._refNumber;
	}
	
	// initial colors of the corner pieces (input by user)
	public void addColour(int refNum, String[] cubeColors) //String[] threeColors, 
	{	
		if (refNum == REFNUM_1)
		{
			// [0], [1], [4] should be the only values filled
			this._allColours[BOTTOM] = cubeColors[0]; // BOTTOM
			this._allColours[FRONT] = cubeColors[1]; // FRONT
			this._allColours[LEFT] = cubeColors[2]; // LEFT
		}
		else if (refNum == REFNUM_2)
		{
			// [0], [1], [2] should be the only values filled
			this._allColours[BOTTOM] = cubeColors[3]; // BOTTOM
			this._allColours[FRONT] = cubeColors[4]; // FRONT
			this._allColours[RIGHT] = cubeColors[5]; // RIGHT
		}
		else if (refNum == REFNUM_3)
		{
			// [0], [3], [2] should be the only values filled
			this._allColours[BOTTOM] = cubeColors[6]; // BOTTOM
			this._allColours[BACK] = cubeColors[7]; // BACK
			this._allColours[RIGHT] = cubeColors[8]; // RIGHT
		}
		else if (refNum == REFNUM_4)
		{
			// [0], [3], [4] should be the only values filled
			this._allColours[BOTTOM] = cubeColors[9]; // BOTTOM
			this._allColours[BACK] = cubeColors[10]; // BACK
			this._allColours[LEFT] = cubeColors[11]; // LEFT
		} 
		else if (refNum == REFNUM_5)
		{
			// [5], [1], [4] should be the only values filled
			this._allColours[TOP] = cubeColors[12]; // TOP
			this._allColours[FRONT] = cubeColors[13]; // FRONT
			this._allColours[LEFT] = cubeColors[14]; // LEFT
		}
		else if (refNum == REFNUM_6)
		{
			// [5], [1], [2] should be the only values filled
			this._allColours[TOP] = cubeColors[15]; // TOP
			this._allColours[FRONT] = cubeColors[16]; // FRONT
			this._allColours[RIGHT] = cubeColors[17]; // RIGHT
		}
		else if (refNum == REFNUM_7)
		{
			// [5], [3], [2] should be the only values filled
			this._allColours[TOP] = cubeColors[18]; // TOP
			this._allColours[BACK] = cubeColors[19]; // BACK
			this._allColours[RIGHT] = cubeColors[20]; // RIGHT
		}
		else if (refNum == REFNUM_8)
		{
			// [5], [3], [4] should be the only values filled
			this._allColours[TOP] = cubeColors[21]; // TOP
			this._allColours[BACK] = cubeColors[22]; // BACK
			this._allColours[LEFT] = cubeColors[23]; // LEFT
		}
	}
	
	// cube constructor --> constructs original cube pieces
	// everything is with reference to the cube having the TOP color as "yellow", the BOTTOM color
	// as "white" and the FRONT color as "red"
	public CornerPiece(int refNum)
	{
		this._refNumber = refNum; // declares reference number of the cube	
	}
}