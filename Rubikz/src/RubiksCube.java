/****************************************************************************
*
* Created by: Patrick Nguyen
* Created on: December 2016
* Rubiks Cube Object Class
*
****************************************************************************/

import java.util.ArrayList;

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
	// absolute worse case scenario = 11 moves, which is 11 x 3 since there are 3 moves
	public static final int WORSE_CASE_SCENARIO = 33; 

	// constants for reference corners to make coding easier
	private static final int REFNUM_1 = 0;
	private static final int REFNUM_2 = 1;
	private static final int REFNUM_3 = 2;
	private static final int REFNUM_4 = 3;
	private static final int REFNUM_5 = 4;
	private static final int REFNUM_6 = 5;
	private static final int REFNUM_7 = 6;
	private static final int REFNUM_8 = 7;
	
	// constants to make it easier to declare sides
	private static final int BOTTOM = 0;
	private static final int FRONT = 1;
	private static final int RIGHT = 2;
	private static final int BACK = 3;
	private static final int LEFT = 4;
	private static final int TOP = 5;
		
	// enum for the colors of the cube
	public enum Color {
		
		RED("R"),
		BLUE("B"),
		WHITE("W"),
		ORANGE("O"),
		YELLOW("Y"),
		GREEN("G");
		
		private final String color;
		
		Color(String color) {
	        this.color = color;
	    }
	    
	    public String getColor() {
	        return this.color;
	    }
	}

	// constructor for the cube
	public RubiksCube(String[] cubeColors)
	{
		// creates new corner pieces & stores their information for future use
		for (int pieces = 0; pieces < TOTAL_CORNERS; pieces++)
		{		
			this._allCornerPieces[pieces] = new CornerPiece(pieces); // creates all corner pieces
			// 6 FOR LOOP HERE
			this._allCornerPieces[pieces].addColour(pieces, cubeColors); // gives corner pieces their color
			this._originalColors[pieces] = this._allCornerPieces[pieces].getAllColors(); // stores colors
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
		// BOTTOM face (1)
		if ((this._originalColors[REFNUM_1][BOTTOM].equals(this._originalColors[REFNUM_2][BOTTOM]) && 
				this._originalColors[REFNUM_2][BOTTOM].equals(this._originalColors[REFNUM_3][BOTTOM]) &&
				this._originalColors[REFNUM_3][BOTTOM].equals(this._originalColors[REFNUM_4][BOTTOM]) &&
				this._originalColors[REFNUM_4][BOTTOM].equals(this._originalColors[REFNUM_1][BOTTOM])))
		{
			this._allFacesSolveState[REFNUM_1] = true;
		}	
		else
		{
			this._allFacesSolveState[REFNUM_1] = false;
		}
		
		// TOP face (2)
		if ((this._originalColors[REFNUM_5][TOP].equals(this._originalColors[REFNUM_6][TOP]) && 
				this._originalColors[REFNUM_6][TOP].equals(this._originalColors[REFNUM_7][TOP]) &&
				this._originalColors[REFNUM_7][TOP].equals(this._originalColors[REFNUM_8][TOP]) &&
				this._originalColors[REFNUM_8][TOP].equals(this._originalColors[REFNUM_5][TOP])))
		{
			this._allFacesSolveState[REFNUM_2] = true;
		}	
		else
		{
			this._allFacesSolveState[REFNUM_2] = false;
		}
		
		// FRONT face (3)
		if ((this._originalColors[REFNUM_1][FRONT].equals(this._originalColors[REFNUM_2][FRONT]) && 
				this._originalColors[REFNUM_2][FRONT].equals(this._originalColors[REFNUM_5][FRONT]) &&
				this._originalColors[REFNUM_5][FRONT].equals(this._originalColors[REFNUM_6][FRONT]) &&
				this._originalColors[REFNUM_6][FRONT].equals(this._originalColors[REFNUM_1][FRONT])))
		{
			this._allFacesSolveState[REFNUM_3] = true;
		}	
		else
		{
			this._allFacesSolveState[REFNUM_3] = false;
		}
		
		// BACK face (4)
		if ((this._originalColors[REFNUM_3][BACK].equals(this._originalColors[REFNUM_4][BACK]) && 
				this._originalColors[REFNUM_4][BACK].equals(this._originalColors[REFNUM_7][BACK]) &&
				this._originalColors[REFNUM_7][BACK].equals(this._originalColors[REFNUM_8][BACK]) &&
				this._originalColors[REFNUM_8][BACK].equals(this._originalColors[REFNUM_3][BACK])))
		{
			this._allFacesSolveState[REFNUM_4] = true;
		}
		else
		{
			this._allFacesSolveState[REFNUM_4] = false;
		}
		
		// RIGHT face (5)
		if ((this._originalColors[REFNUM_2][RIGHT].equals(this._originalColors[REFNUM_3][RIGHT]) && 
				this._originalColors[REFNUM_3][RIGHT].equals(this._originalColors[REFNUM_6][RIGHT]) &&
				this._originalColors[REFNUM_6][RIGHT].equals(this._originalColors[REFNUM_7][RIGHT]) &&
				this._originalColors[REFNUM_7][RIGHT].equals(this._originalColors[REFNUM_2][RIGHT])))
		{
			this._allFacesSolveState[REFNUM_5] = true;
		}	
		else
		{
			this._allFacesSolveState[REFNUM_5] = false;
		}
		
		// LEFT face (6)
		if ((this._originalColors[REFNUM_1][LEFT].equals(this._originalColors[REFNUM_4][LEFT]) && 
				this._originalColors[REFNUM_4][LEFT].equals(this._originalColors[REFNUM_5][LEFT]) &&
				this._originalColors[REFNUM_5][LEFT].equals(this._originalColors[REFNUM_8][LEFT]) &&
				this._originalColors[REFNUM_8][LEFT].equals(this._originalColors[REFNUM_1][LEFT])))
		{
			this._allFacesSolveState[REFNUM_6] = true;
		}		
		else
		{
			this._allFacesSolveState[REFNUM_6] = false;
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
		
		// BOTTOM move RIGHT (0) --> tested 
		// ref1 --> ref2 = BOTTOM[0] --> BOTTOM[0], FRONT[1] --> RIGHT[2], LEFT[4] --> FRONT[1]
		// ref2 --> ref3 = BOTTOM[0] --> BOTTOM[0], FRONT[1] --> RIGHT[2], RIGHT[2] --> BACK[3]
		// ref3 --> ref4 = BOTTOM[0] --> BOTTOM[0], BACK[3] --> LEFT[4], RIGHT[2] --> BACK[3]
		// ref4 --> ref1 = BOTTOM[0] --> BOTTOM[0], BACK[3] --> LEFT[4], LEFT[4] --> FRONT[1]
		if(turnNum == 0)
		{
			refTemp = this._allCornerPieces[REFNUM_1].getRefNumber();
			this._allCornerPieces[REFNUM_1].changeRefNumber(this._allCornerPieces[REFNUM_2].getRefNumber());
			this._allCornerPieces[REFNUM_2].changeRefNumber(this._allCornerPieces[REFNUM_3].getRefNumber());
			this._allCornerPieces[REFNUM_3].changeRefNumber(this._allCornerPieces[REFNUM_4].getRefNumber());
			this._allCornerPieces[REFNUM_4].changeRefNumber(refTemp);				
			
			// ref1 --> ref2
			colorTemp[REFNUM_1][BOTTOM] = _originalColors[REFNUM_1][BOTTOM];
			colorTemp[REFNUM_1][RIGHT] = _originalColors[REFNUM_1][FRONT];
			colorTemp[REFNUM_1][FRONT] = _originalColors[REFNUM_1][LEFT];
			// ref2 --> ref3
			colorTemp[REFNUM_2][BOTTOM] = _originalColors[REFNUM_2][BOTTOM];
			colorTemp[REFNUM_2][RIGHT] = _originalColors[REFNUM_2][FRONT];
			colorTemp[REFNUM_2][BACK] = _originalColors[REFNUM_2][RIGHT];
			// ref2 --> ref3
			colorTemp[REFNUM_3][BOTTOM] = _originalColors[REFNUM_3][BOTTOM];
			colorTemp[REFNUM_3][LEFT] = _originalColors[REFNUM_3][BACK];
			colorTemp[REFNUM_3][BACK] = _originalColors[REFNUM_3][RIGHT];
			// ref4 --> ref1
			colorTemp[REFNUM_4][BOTTOM] = _originalColors[REFNUM_4][BOTTOM];
			colorTemp[REFNUM_4][LEFT] = _originalColors[REFNUM_4][BACK];
			colorTemp[REFNUM_4][FRONT] = _originalColors[REFNUM_4][LEFT];	
					
			this._allCornerPieces[REFNUM_2].changeAllColors(colorTemp[REFNUM_1]);
			this._allCornerPieces[REFNUM_3].changeAllColors(colorTemp[REFNUM_2]);
			this._allCornerPieces[REFNUM_4].changeAllColors(colorTemp[REFNUM_3]);
			this._allCornerPieces[REFNUM_1].changeAllColors(colorTemp[REFNUM_4]);
		
			// System.out.println("BOTTOM Move RIGHT");
		    /* System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[REFNUM_1])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[REFNUM_2])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[REFNUM_3])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[REFNUM_4])); 
			System.out.println(); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[REFNUM_1])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[REFNUM_2])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[REFNUM_3])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[REFNUM_4])); */
		}	
		// RIGHT move up (1) --> tested
		// ref6 --> ref7 = TOP[5] --> BACK[3], FRONT[1] --> TOP[5], RIGHT[2] --> RIGHT[2]
		// ref7 --> ref3 = TOP[5] --> BACK[3] , BACK[3] --> BOTTOM[0], RIGHT[2] --> RIGHT[2]
		// ref3 --> ref2 = BOTTOM[0] --> FRONT[1], BACK[3] --> BOTTOM[0], RIGHT[2] --> RIGHT[2]
		// ref2 --> ref6 = BOTTOM[0] --> FRONT[1], FRONT[1] --> TOP[5], RIGHT[2] --> RIGHT[2]
		else if(turnNum == 1)
		{
			refTemp = this._allCornerPieces[REFNUM_6].getRefNumber();
			this._allCornerPieces[REFNUM_6].changeRefNumber(this._allCornerPieces[REFNUM_7].getRefNumber());
			this._allCornerPieces[REFNUM_7].changeRefNumber(this._allCornerPieces[REFNUM_3].getRefNumber());
			this._allCornerPieces[REFNUM_3].changeRefNumber(this._allCornerPieces[REFNUM_2].getRefNumber());
			this._allCornerPieces[REFNUM_2].changeRefNumber(refTemp);	
					
			// ref6 --> ref7
			colorTemp[REFNUM_6][BACK] = _originalColors[REFNUM_6][TOP];
			colorTemp[REFNUM_6][TOP] = _originalColors[REFNUM_6][FRONT];
			colorTemp[REFNUM_6][RIGHT] = _originalColors[REFNUM_6][RIGHT];
			// ref7 --> ref3
			colorTemp[REFNUM_7][BACK] = _originalColors[REFNUM_7][TOP];
			colorTemp[REFNUM_7][BOTTOM] = _originalColors[REFNUM_7][BACK];
			colorTemp[REFNUM_7][RIGHT] = _originalColors[REFNUM_7][RIGHT];
			// ref3 --> ref2
			colorTemp[REFNUM_3][FRONT] = _originalColors[REFNUM_3][BOTTOM];
			colorTemp[REFNUM_3][BOTTOM] = _originalColors[REFNUM_3][BACK];
			colorTemp[REFNUM_3][RIGHT] = _originalColors[REFNUM_3][RIGHT];
			// ref2 --> ref6 
			colorTemp[REFNUM_2][FRONT] = _originalColors[REFNUM_2][BOTTOM];
			colorTemp[REFNUM_2][TOP] = _originalColors[REFNUM_2][FRONT];
			colorTemp[REFNUM_2][RIGHT] = _originalColors[REFNUM_2][RIGHT];	
			
			this._allCornerPieces[REFNUM_7].changeAllColors(colorTemp[REFNUM_6]);
			this._allCornerPieces[REFNUM_3].changeAllColors(colorTemp[REFNUM_7]);
			this._allCornerPieces[REFNUM_2].changeAllColors(colorTemp[REFNUM_3]);
			this._allCornerPieces[REFNUM_6].changeAllColors(colorTemp[REFNUM_2]);
			
			// System.out.println("RIGHT Move Up");
			/* System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[REFNUM_6])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[REFNUM_7])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[REFNUM_3])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[REFNUM_2])); 
			System.out.println(); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[REFNUM_6])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[REFNUM_7])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[REFNUM_3])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[REFNUM_2])); */
		}
		// FRONT spin RIGHT (2) --> tested
		// ref5 --> ref6 = TOP[5] --> RIGHT[2], FRONT[1] --> FRONT[1],  LEFT[4] --> TOP[5]
		// ref6 --> ref2 = TOP[5] --> RIGHT[2], FRONT[1] --> FRONT[1], RIGHT[2] --> BOTTOM[0]
		// ref2 --> ref1 = BOTTOM[0] --> LEFT[4], FRONT[1] --> FRONT[1], RIGHT[2] --> BOTTOM[0]
		// ref1 --> ref5 = BOTTOM[0] --> LEFT[4], FRONT[1] --> FRONT[1], LEFT[4] --> TOP[5]
		else if(turnNum == 2)
		{
			refTemp = this._allCornerPieces[REFNUM_5].getRefNumber();
			this._allCornerPieces[REFNUM_5].changeRefNumber(this._allCornerPieces[REFNUM_6].getRefNumber());
			this._allCornerPieces[REFNUM_6].changeRefNumber(this._allCornerPieces[REFNUM_2].getRefNumber());
			this._allCornerPieces[REFNUM_2].changeRefNumber(this._allCornerPieces[REFNUM_1].getRefNumber());
			this._allCornerPieces[REFNUM_1].changeRefNumber(refTemp);	
			
			// ref5 --> ref6
			colorTemp[REFNUM_5][RIGHT] = _originalColors[REFNUM_5][TOP];
			colorTemp[REFNUM_5][FRONT] = _originalColors[REFNUM_5][FRONT];
			colorTemp[REFNUM_5][TOP] = _originalColors[REFNUM_5][LEFT];
			// ref6 --> ref2
			colorTemp[REFNUM_6][RIGHT] = _originalColors[REFNUM_6][TOP];
			colorTemp[REFNUM_6][FRONT] = _originalColors[REFNUM_6][FRONT];
			colorTemp[REFNUM_6][BOTTOM] = _originalColors[REFNUM_6][RIGHT];
			// ref2 --> ref1
			colorTemp[REFNUM_2][LEFT] = _originalColors[REFNUM_2][BOTTOM];
			colorTemp[REFNUM_2][FRONT] = _originalColors[REFNUM_2][FRONT];
			colorTemp[REFNUM_2][BOTTOM] = _originalColors[REFNUM_2][RIGHT];
			// ref1 --> ref5
			colorTemp[REFNUM_1][LEFT] = _originalColors[REFNUM_1][BOTTOM];
			colorTemp[REFNUM_1][FRONT] = _originalColors[REFNUM_1][FRONT];
			colorTemp[REFNUM_1][TOP] = _originalColors[REFNUM_1][LEFT];
			
			this._allCornerPieces[REFNUM_6].changeAllColors(colorTemp[REFNUM_5]);
			this._allCornerPieces[REFNUM_2].changeAllColors(colorTemp[REFNUM_6]);
			this._allCornerPieces[REFNUM_1].changeAllColors(colorTemp[REFNUM_2]);
			this._allCornerPieces[REFNUM_5].changeAllColors(colorTemp[REFNUM_1]);
			
			// System.out.println("FRONT Spin RIGHT");
			/* System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[REFNUM_5])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[REFNUM_6])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[REFNUM_2])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(_originalColors[REFNUM_1])); 
			System.out.println(); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[REFNUM_5])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[REFNUM_6])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[REFNUM_2])); 
			System.out.println("Sorted List of Numbers: " + Arrays.toString(colorTemp[REFNUM_1])); */ 			
		}
		
		// makes the real colors of the cube the temp colors
		for (int pieces = 0; pieces < TOTAL_CORNERS; pieces ++)
		{
			this._originalColors[pieces] = _allCornerPieces[pieces].getAllColors();
		}
		// checkForSolution();
	}
		
	// prints out all of the moves of the cube to solve it
	public void printMoves()
	{
		for (int moves = 0; moves < this._allMoves.size(); moves ++)
		{
		     if (this._allMoves.get(moves) == 0)
		     {
		    	 System.out.println("Move The BOTTOM Row RIGHT");
		     }
		     else if(this._allMoves.get(moves) == 1)
		     {
		    	 System.out.println("Move The RIGHT Column UP");
		     }
		     else if(this._allMoves.get(moves) == 2)
		     {
		    	 System.out.println("Move The FRONT Face Clockwise");
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