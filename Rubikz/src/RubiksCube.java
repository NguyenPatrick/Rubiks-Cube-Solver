import java.util.ArrayList;
import java.util.Arrays;

public class RubiksCube {

	// stores all the corner pieces which in turn makes a cube
	private CornerPiece[] _allCornerPieces =  new CornerPiece[8]; 
	private Boolean[] _allFacesSolveState =  new Boolean[6]; // solve state of faces
	private String[][] _originalColors = new String[8][6]; // initial colors of the cube
	ArrayList<Integer> _allMoves =  new ArrayList<Integer>(); // stores all moves to solve
	
	// logical constants for more organized code
	public static final int TOTAL_CORNERS = 8;
	public static final int NUMBER_OF_FACES = 6;
	public static final int NUMBER_OF_MOVES = 3;
	// absolute worse case scenario = 11 moves, which is 11 x 3 for this class
	public static final int WORSE_CASE_SCENARIO = 33; 

	// constants for reference corners to make coding easier
	private static final int ref1Num = 0;
	private static final int ref2Num = 1;
	private static final int ref3Num = 2;
	private static final int ref4Num = 3;
	private static final int ref5Num = 4;
	private static final int ref6Num = 5;
	private static final int ref7Num = 6;
	private static final int ref8Num = 7;
	
	// constants to make it easier to declare sides
	private static final int bottom = 0;
	private static final int front = 1;
	private static final int right = 2;
	private static final int back = 3;
	private static final int left = 4;
	private static final int top = 5;
			
	// constructor for the cube
	public RubiksCube()
	{
		// creates new corner pieces & stores their information for future use
		for (int pieces = 0; pieces < TOTAL_CORNERS; pieces++)
		{		
			this._allCornerPieces[pieces] = new CornerPiece(pieces); // creates all corner pieces
			this._allCornerPieces[pieces].addColour(pieces); // gives corner pieces their color
			this._originalColors[pieces] = _allCornerPieces[pieces].getAllColors(); // stores colors
		}
		
		for (int faces = 0; faces < NUMBER_OF_FACES; faces++)
		{
			// nothing is solved yet, has to run through the check function
			this._allFacesSolveState[faces] = false; 
		}	
	}
		
	// checks to see if cube is valid using the faces of the cube
	public Boolean checkForSolution()
	{
		// bottom face (1)
		if ((this._originalColors[ref1Num][bottom].equals(this._originalColors[ref2Num][bottom]) && 
				this._originalColors[ref2Num][bottom].equals(this._originalColors[ref3Num][bottom]) &&
				this._originalColors[ref3Num][bottom].equals(this._originalColors[ref4Num][bottom]) &&
				this._originalColors[ref4Num][bottom].equals(this._originalColors[ref1Num][bottom])))
		{
			this._allFacesSolveState[ref1Num] = true;
		}	
		else
		{
			this._allFacesSolveState[ref1Num] = false;
		}
		
		// top face (2)
		if ((this._originalColors[ref5Num][top].equals(this._originalColors[ref6Num][top]) && 
				this._originalColors[ref6Num][top].equals(this._originalColors[ref7Num][top]) &&
				this._originalColors[ref7Num][top].equals(this._originalColors[ref8Num][top]) &&
				this._originalColors[ref8Num][top].equals(this._originalColors[ref5Num][top])))
		{
			this._allFacesSolveState[ref2Num] = true;
		}	
		else
		{
			this._allFacesSolveState[ref2Num] = false;
		}
		
		// front face (3)
		if ((this._originalColors[ref1Num][front].equals(this._originalColors[ref2Num][front]) && 
				this._originalColors[ref2Num][front].equals(this._originalColors[ref5Num][front]) &&
				this._originalColors[ref5Num][front].equals(this._originalColors[ref6Num][front]) &&
				this._originalColors[ref6Num][front].equals(this._originalColors[ref1Num][front])))
		{
			this._allFacesSolveState[ref3Num] = true;
		}	
		else
		{
			this._allFacesSolveState[ref3Num] = false;
		}
		
		// back face (4)
		if ((this._originalColors[ref3Num][back].equals(this._originalColors[ref4Num][back]) && 
				this._originalColors[ref4Num][back].equals(this._originalColors[ref7Num][back]) &&
				this._originalColors[ref7Num][back].equals(this._originalColors[ref8Num][back]) &&
				this._originalColors[ref8Num][back].equals(this._originalColors[ref3Num][back])))
		{
			this._allFacesSolveState[ref4Num] = true;
		}
		else
		{
			this._allFacesSolveState[ref4Num] = false;
		}
		
		// right face (5)
		if ((this._originalColors[ref2Num][right].equals(this._originalColors[ref3Num][right]) && 
				this._originalColors[ref3Num][right].equals(this._originalColors[ref6Num][right]) &&
				this._originalColors[ref6Num][right].equals(this._originalColors[ref7Num][right]) &&
				this._originalColors[ref7Num][right].equals(this._originalColors[ref2Num][right])))
		{
			this._allFacesSolveState[ref5Num] = true;
		}	
		else
		{
			this._allFacesSolveState[ref5Num] = false;
		}
		
		// left face (6)
		if ((this._originalColors[ref1Num][left].equals(this._originalColors[ref4Num][left]) && 
				this._originalColors[ref4Num][left].equals(this._originalColors[ref5Num][left]) &&
				this._originalColors[ref5Num][left].equals(this._originalColors[ref8Num][left]) &&
				this._originalColors[ref8Num][left].equals(this._originalColors[ref1Num][left])))
		{
			this._allFacesSolveState[ref6Num] = true;
		}		
		else
		{
			this._allFacesSolveState[ref6Num] = false;
		}
		
		// checks to see if all faces are solved
		for (int pieces = 0; pieces < this._allFacesSolveState.length; pieces++)
		{
			if (this._allFacesSolveState[pieces] == false)
			{
				return false; // not all faces are not solved
			}
		}
		
	// System.out.println("Works");
	return true; // all faces are solved
	}
	
	public void move(int turnNum)
	{
		int refTemp; // temp for reference number of the cube
		String[][] colorTemp = new String[8][6]; // temp for new colors of the cube after each move
		
		// bottom move right (0) --> tested 
		// ref1 --> ref2 = bottom[0] --> bottom[0], front[1] --> right[2], left[4] --> front[1]
		// ref2 --> ref3 = bottom[0] --> bottom[0], front[1] --> right[2], right[2] --> back[3]
		// ref3 --> ref4 = bottom[0] --> bottom[0], back[3] --> left[4], right[2] --> back[3]
		// ref4 --> ref1 = bottom[0] --> bottom[0], back[3] --> left[4], left[4] --> front[1]
		if(turnNum == 0)
		{
			refTemp = this._allCornerPieces[ref1Num].getRefNumber();
			this._allCornerPieces[ref1Num].changeRefNumber(this._allCornerPieces[ref2Num].getRefNumber());
			this._allCornerPieces[ref2Num].changeRefNumber(this._allCornerPieces[ref3Num].getRefNumber());
			this._allCornerPieces[ref3Num].changeRefNumber(this._allCornerPieces[ref4Num].getRefNumber());
			this._allCornerPieces[ref4Num].changeRefNumber(refTemp);				
			
			// ref1 --> ref2
			colorTemp[ref1Num][bottom] = _originalColors[ref1Num][bottom];
			colorTemp[ref1Num][right] = _originalColors[ref1Num][front];
			colorTemp[ref1Num][front] = _originalColors[ref1Num][left];
			// ref2 --> ref3
			colorTemp[ref2Num][bottom] = _originalColors[ref2Num][bottom];
			colorTemp[ref2Num][right] = _originalColors[ref2Num][front];
			colorTemp[ref2Num][back] = _originalColors[ref2Num][right];
			// ref2 --> ref3
			colorTemp[ref3Num][bottom] = _originalColors[ref3Num][bottom];
			colorTemp[ref3Num][left] = _originalColors[ref3Num][back];
			colorTemp[ref3Num][back] = _originalColors[ref3Num][right];
			// ref4 --> ref1
			colorTemp[ref4Num][bottom] = _originalColors[ref4Num][bottom];
			colorTemp[ref4Num][left] = _originalColors[ref4Num][back];
			colorTemp[ref4Num][front] = _originalColors[ref4Num][left];	
					
			this._allCornerPieces[ref2Num].changeAllColors(colorTemp[ref1Num]);
			this._allCornerPieces[ref3Num].changeAllColors(colorTemp[ref2Num]);
			this._allCornerPieces[ref4Num].changeAllColors(colorTemp[ref3Num]);
			this._allCornerPieces[ref1Num].changeAllColors(colorTemp[ref4Num]);
		
			// System.out.println("Bottom Move Right");
		    /* System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[ref1Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[ref2Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[ref3Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[ref4Num])); 
			System.out.println(); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[ref1Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[ref2Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[ref3Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[ref4Num])); */
		}	
		// right move up (1) --> tested
		// ref6 --> ref7 = top[5] --> back[3], front[1] --> top[5], right[2] --> right[2]
		// ref7 --> ref3 = top[5] --> back[3] , back[3] --> bottom[0], right[2] --> right[2]
		// ref3 --> ref2 = bottom[0] --> front[1], back[3] --> bottom[0], right[2] --> right[2]
		// ref2 --> ref6 = bottom[0] --> front[1], front[1] --> top[5], right[2] --> right[2]
		else if(turnNum == 1)
		{
			refTemp = this._allCornerPieces[ref6Num].getRefNumber();
			this._allCornerPieces[ref6Num].changeRefNumber(this._allCornerPieces[ref7Num].getRefNumber());
			this._allCornerPieces[ref7Num].changeRefNumber(this._allCornerPieces[ref3Num].getRefNumber());
			this._allCornerPieces[ref3Num].changeRefNumber(this._allCornerPieces[ref2Num].getRefNumber());
			this._allCornerPieces[ref2Num].changeRefNumber(refTemp);	
					
			// ref6 --> ref7
			colorTemp[ref6Num][back] = _originalColors[ref6Num][top];
			colorTemp[ref6Num][top] = _originalColors[ref6Num][front];
			colorTemp[ref6Num][right] = _originalColors[ref6Num][right];
			// ref7 --> ref3
			colorTemp[ref7Num][back] = _originalColors[ref7Num][top];
			colorTemp[ref7Num][bottom] = _originalColors[ref7Num][back];
			colorTemp[ref7Num][right] = _originalColors[ref7Num][right];
			// ref3 --> ref2
			colorTemp[ref3Num][front] = _originalColors[ref3Num][bottom];
			colorTemp[ref3Num][bottom] = _originalColors[ref3Num][back];
			colorTemp[ref3Num][right] = _originalColors[ref3Num][right];
			// ref2 --> ref6 
			colorTemp[ref2Num][front] = _originalColors[ref2Num][bottom];
			colorTemp[ref2Num][top] = _originalColors[ref2Num][front];
			colorTemp[ref2Num][right] = _originalColors[ref2Num][right];	
			
			this._allCornerPieces[ref7Num].changeAllColors(colorTemp[ref6Num]);
			this._allCornerPieces[ref3Num].changeAllColors(colorTemp[ref7Num]);
			this._allCornerPieces[ref2Num].changeAllColors(colorTemp[ref3Num]);
			this._allCornerPieces[ref6Num].changeAllColors(colorTemp[ref2Num]);
			
			// System.out.println("Right Move Up");
			/* System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[ref6Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[ref7Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[ref3Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[ref2Num])); 
			System.out.println(); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[ref6Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[ref7Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[ref3Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[ref2Num])); */
		}
		// front spin right (2) --> tested
		// ref5 --> ref6 = top[5] --> right[2], front[1] --> front[1],  left[4] --> top[5]
		// ref6 --> ref2 = top[5] --> right[2], front[1] --> front[1], right[2] --> bottom[0]
		// ref2 --> ref1 = bottom[0] --> left[4], front[1] --> front[1], right[2] --> bottom[0]
		// ref1 --> ref5 = bottom[0] --> left[4], front[1] --> front[1], left[4] --> top[5]
		else if(turnNum == 2)
		{
			refTemp = this._allCornerPieces[ref5Num].getRefNumber();
			this._allCornerPieces[ref5Num].changeRefNumber(this._allCornerPieces[ref6Num].getRefNumber());
			this._allCornerPieces[ref6Num].changeRefNumber(this._allCornerPieces[ref2Num].getRefNumber());
			this._allCornerPieces[ref2Num].changeRefNumber(this._allCornerPieces[ref1Num].getRefNumber());
			this._allCornerPieces[ref1Num].changeRefNumber(refTemp);	
			
			// ref5 --> ref6
			colorTemp[ref5Num][right] = _originalColors[ref5Num][top];
			colorTemp[ref5Num][front] = _originalColors[ref5Num][front];
			colorTemp[ref5Num][top] = _originalColors[ref5Num][left];
			// ref6 --> ref2
			colorTemp[ref6Num][right] = _originalColors[ref6Num][top];
			colorTemp[ref6Num][front] = _originalColors[ref6Num][front];
			colorTemp[ref6Num][bottom] = _originalColors[ref6Num][right];
			// ref2 --> ref1
			colorTemp[ref2Num][left] = _originalColors[ref2Num][bottom];
			colorTemp[ref2Num][front] = _originalColors[ref2Num][front];
			colorTemp[ref2Num][bottom] = _originalColors[ref2Num][right];
			// ref1 --> ref5
			colorTemp[ref1Num][left] = _originalColors[ref1Num][bottom];
			colorTemp[ref1Num][front] = _originalColors[ref1Num][front];
			colorTemp[ref1Num][top] = _originalColors[ref1Num][left];
			
			this._allCornerPieces[ref6Num].changeAllColors(colorTemp[ref5Num]);
			this._allCornerPieces[ref2Num].changeAllColors(colorTemp[ref6Num]);
			this._allCornerPieces[ref1Num].changeAllColors(colorTemp[ref2Num]);
			this._allCornerPieces[ref5Num].changeAllColors(colorTemp[ref1Num]);
			
			// System.out.println("Front Spin Right");
			/* System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[ref5Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[ref6Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[ref2Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[ref1Num])); 
			System.out.println(); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[ref5Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[ref6Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[ref2Num])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[ref1Num])); */ 			
		}
		
		// makes the real colors of the cube the temp colors
		for (int pieces = 0; pieces < TOTAL_CORNERS; pieces ++)
		{
			this._originalColors[pieces] = _allCornerPieces[pieces].getAllColors();
		}

		// checkForSolution();
	}
	
	
	public void printMoves()
	{
		for (int i = 0; i < this._allMoves.size(); i ++)
		{
		     if (this._allMoves.get(i) == 0)
		     {
		    	 System.out.println("Move The Bottom Row Right");
		     }
		     else if(this._allMoves.get(i) == 1)
		     {
		    	 System.out.println("Move The Right Column Up");
		     }
		     else if(this._allMoves.get(i) == 2)
		     {
		    	 System.out.println("Move The Front Face Clockwise");
		     }
		}
	}
	
	// method to initiate the solving of the cube
	public void solve()
	{
		// stores the moves
		ArrayList<Integer> optimaSolution = new ArrayList<Integer>();
		
		// uses loop to calculate the optimal solution
		for (int recursionLevel = 0; recursionLevel < WORSE_CASE_SCENARIO; recursionLevel ++)
		{
			// checks to see if the cube is solved
			if (this.checkForSolution() == false)
			{
				// if not then move up a level of recursion (number of moves)
				optimaSolution = this.calculateMoves(0, recursionLevel);	
			}
			else
			{
				break;
			}
		}

		this.printMoves(); // prints all the moves
		//System.out.println(Arrays.toString(optimaSolution.toArray()));
	}

	// recursion to case through every scenario and choose the optimal one
	public ArrayList<Integer> calculateMoves(int count, int moveLimit)
	{
		// limit checking to induce next recursion level if cube isnt solved
		if(count < moveLimit)
		{
			// if cube is already solved
			if(this.checkForSolution() == true)
			{				
				return this._allMoves;
			}
			else
			{			
				// case through every scenario using 3 moves
				for(int numberOfMoves = 0; numberOfMoves < NUMBER_OF_MOVES; numberOfMoves++)
				{
					this._allMoves.add(numberOfMoves); // adds move to array list
					this.move(numberOfMoves); // moves the cube
					//System.out.println(Arrays.toString(this._allMoves.toArray()));
					this._allMoves = new ArrayList<Integer>(calculateMoves(count + 1, moveLimit)); // recursion
					
					// returns solution if cube is solved
					if(this.checkForSolution() == true)
					{
					    //System.out.println(Arrays.toString(this._allMoves.toArray()));
						return this._allMoves;			
					}

					// undos move for next recursive instance
					for (int moveUndo = 0; moveUndo < NUMBER_OF_MOVES; moveUndo ++)
					{
						this.move(numberOfMoves);				
					}

					this._allMoves.remove(count); // removes last value in list for next recursion
				}			
			}
		}		
		return this._allMoves;
	}
}