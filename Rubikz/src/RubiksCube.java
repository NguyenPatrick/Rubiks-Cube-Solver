/*
bottom move right(ref1 --> ref2, ref2-->ref3, ref3 --> ref4, ref4--> ref1)
bottom move left(ref1--> ref4, ref4--> ref3, ref3 --> ref2, ref2 --> ref1)
top move right(ref 5 --> ref6, ref6 --> ref7, ref7--> ref8, ref8 --> ref5)
top move left(ref5 --> ref8, ref8 --> ref7, ref7 --> ref6,  ref6 --> ref5)
right move up(ref6 --> ref7, ref7--> ref3,  ref3 --> ref2, ref2 --> ref6)
right move down(ref6--> ref2, ref2 -- > ref3, ref3 --> ref7, ref7 -- > ref6)
left move up(ref5--> ref8, ref8 --> ref4,  ref4 --> ref1, ref1--> ref5)
left move down(ref5 --> ref1,  ref1 --> ref4 , ref4--> ref8, ref8--> ref5)
front spin right(ref5-->ref6, ref6-->ref2, ref2-->ref1, ref1--> ref5)
front spin left(ref5-->ref1, ref1-->ref2, ref2-->ref6, ref6-->ref5)
back spin right(ref8-->ref7, ref7-->ref3, ref3-->ref4, ref4-->ref8)
back spin left(ref8-->ref4, ref4-->ref3, ref3-->ref7, ref7-->ref8)
 */


public class RubiksCube {

	public RubiksCube(int refNum)
	{
		
	
	}
	
	// _allColours[0] = bottom, 
	// _allColours[1] = front,
	// _allColours[2] = right
	// _allColours[3] = back
    // _allColours[4] = left
	// _allColours[5] = top
	
	// ref1 [0] bottom, [1] front, [4] left 
	// ref2 [0] bottom, [1] front, [2] right
	// ref3 [0] bottom, [3] back, [2] right
	// ref4 [0] bottom, [3] back, [4] left
	// ref5 [5] top, [1] front, [4] left
	// ref6 [5] top, [1] front, [2] right
	// ref7 [5] top, [3] back, [2] right
	// ref8 [5] top, [3] back, [4] left
	
	//bottom move right --> 
	// ref1 --> ref2 = [0] bottom --> [0] bottom, [1] front --> [2] right, [4] left --> [1] front
	// ref2 --> ref3 = [0] bottom --> [0] bottom, [1] front --> [2] right, [2] right --> [3] back
	// ref3 --> ref4 = [0] bottom --> [0] bottom, [3] back --> [4] left, [2] right --> [3] back
	// ref4 --> ref1 = [0] bottom --> [0] bottom, [3] back --> [4] left, [4] left --> [1] front
	
	//bottom move left --> 
	
	public void turn(int moveNumber)
	{
		String[] temp;
		// bottom move right
		if (moveNumber == 1)
		{
			// this._allColours[1] & this._allColours[2] swap
		}
		// bottom move left
		else if (moveNumber == 2)
		{
			
		}
		// top move right
		else if (moveNumber == 3)
		{
			
		}
		// top move left
		else if (moveNumber == 4)
		{
			
		}
		// right move up
		else if (moveNumber == 5)
		{
			
		}
		// right move down
		else if (moveNumber == 6)
		{
			
		}
		// left move up
		else if (moveNumber == 7)
		{
			
		}
		// left move down
		else if (moveNumber == 8)
		{
			
		}
		// front spin right
		else if (moveNumber == 9)
		{
			
		}
		// front spin left
		else if (moveNumber == 10)
		{
			
		}		
		// back spin right
		else if (moveNumber == 11)
		{
			
		}
		// back spin left
		else if (moveNumber == 12)
		{
			
		}
		
	}
}
