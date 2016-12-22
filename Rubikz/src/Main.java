/****************************************************************************
*
* Created by: Patrick Nguyen
* Created on: December 2016
* This Program Uses Recursion To Solve A 2x2x2 Rubiks Cube
*
****************************************************************************/
import java.util.Scanner;

public class Main {
	
	public static void main(String args[])
	{	
		Scanner scan = new Scanner(System.in);
		String [] cubeColors = new String[24];
			
		System.out.println("Welcome to Cub Solver! Follow These Following Steps To Set Up Your Cube!");
		System.out.println("| W = White | Y = Yellow | R = Red | O = Orange | G = Green | B = Blue |");
		System.out.println("First Hold One Face Towards You, Remember This! This Face is ALWAYS Your Front Face!");
		System.out.println();
		
		// gets the user input
		for (int allColors = 0; allColors < 24; allColors ++)
		{
			Boolean isValid = false;
			String direction;
			String topOrBottom;
			String frontOrBack;
			String leftOrRight;
						
			// direction of the face of the colors
			if (allColors == 0 || allColors == 3 || allColors == 6 || allColors == 9)
			{
				direction = "Bottom";
			}			
			else if (allColors == 12 || allColors == 15 || allColors == 18 || allColors == 21)
			{
				direction = "Top";
			}
			else if (allColors == 1 || allColors == 4 || allColors == 13 || allColors == 16)
			{
				direction = "Front";
			}
			else if (allColors == 7 || allColors == 10 || allColors == 19 || allColors == 22)
			{
				direction = "Back";
			}
			else if (allColors == 5 || allColors == 8 || allColors == 17 || allColors == 20)
			{
				direction = "Right";
			}
			else 
			{
				direction = "Left";
			}
			
			// top and bottom corner piece
			if (allColors < 12)
			{
				topOrBottom = "Lower";
			}
			else
			{
				topOrBottom = "Upper";
			}
			
			// left and right corner piece
			if (allColors > 2 && allColors < 9 || allColors > 14 && allColors < 21)
			{
				leftOrRight = "Right";
			}
			else
			{
				leftOrRight = "Left";
			}
			
			// front and back corner piece
			if (allColors < 6 || allColors > 11 && allColors < 18)
			{
				frontOrBack = "Front";
			}
			else
			{
				frontOrBack = "Back";
			}
			
			System.out.println("Enter The " + direction + " Color Of The Corner In The " + 
			topOrBottom + " " + leftOrRight + " " + frontOrBack + " Of The Cube");	


			// checks for invalid user input that is not one of the colors
			while (!isValid) 
			{
				String input = scan.nextLine();
							
				for(int possibleColors = 0; possibleColors < 6; possibleColors ++)
				{
					if (input.equals(RubiksCube.Color.values()[possibleColors].getColor()))
					{
						cubeColors[allColors] = input;	
						isValid = true;
					}
				}
				
				if (isValid == false)
				{
					System.err.println("Invalid Input! Please Enter A Valid Color!");	
				}
			}
		}
		
		// constructs the cube
		RubiksCube newCube = new RubiksCube(cubeColors);
		System.out.println();
		System.out.println("Currently Brute Forcing The Cube... Don't Rage Quit...");
		System.out.println("REMINDER: When Following The Steps, Be Sure To Keep The FRONT Face ALWAYS Facing Towards You");
		System.out.println();
		newCube.solve();
		System.out.println();
		System.out.println("Done. Follow These Steps To Solve Your Cube");
	
	
	/* BIGGEST TEST CASE
	// bottom row right, right row up, top row right, left row up,
	// front row right, right row up, back row right
	
	newCube.move(2);
	newCube.move(0);
	newCube.move(0);
	newCube.move(0);
	newCube.move(2);
	newCube.move(2);
	newCube.move(2);
	newCube.move(0);
	newCube.move(2);
	newCube.move(1);
	newCube.move(1);
	newCube.move(1);
	newCube.move(0);
	newCube.move(0);
	newCube.move(0);

	if (refNum == ref1Num)
	{
		// [0], [1], [4] should be the only values filled
		this._allColours[bottom] = "R"; // bottom
		this._allColours[front] = "W"; // front
		this._allColours[left] = "G"; // left
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
		this._allColours[bottom] = "B"; // bottom
		this._allColours[back] = "O"; // back
		this._allColours[right] = "W"; // right
	}
	else if (refNum == ref4Num)
	{
		// [0], [3], [4] should be the only values filled
		this._allColours[bottom] = "W"; // bottom
		this._allColours[back] = "B"; // back
		this._allColours[left] = "R"; // left
	} 
	else if (refNum == ref5Num)
	{
		// [5], [1], [4] should be the only values filled
		this._allColours[top] = "O"; // top
		this._allColours[front] = "W"; // front
		this._allColours[left] = "G"; // left
	}
	else if (refNum == ref6Num)
	{
		// [5], [1], [2] should be the only values filled
		this._allColours[top] = "B"; // top
		this._allColours[front] = "R"; // front
		this._allColours[right] = "Y"; // right
	}
	else if (refNum == ref7Num)
	{
		// [5], [3], [2] should be the only values filled
		this._allColours[top] = "O"; // top
		this._allColours[back] = "Y"; // back
		this._allColours[right] = "B"; // right
	}
	else if (refNum == ref8Num)
	{
		// [5], [3], [4] should be the only values filled
		this._allColours[top] = "Y"; // top
		this._allColours[back] = "R"; // back
		this._allColours[left] = "G"; // left
	} */


	/* TEST CASE #1
	// bottom row right x2, right up	
	newCube.move(1);
	newCube.move(1);
	newCube.move(1);
	newCube.move(0);
	newCube.move(0); 
	
	if (refNum == ref1Num)
	{
		// [0], [1], [4] should be the only values filled
		this._allColours[bottom] = "W"; // bottom
		this._allColours[front] = "O"; // front
		this._allColours[left] = "G"; // left
	}
	else if (refNum == ref2Num)
	{
		// [0], [1], [2] should be the only values filled
		this._allColours[bottom] = "R"; // bottom
		this._allColours[front] = "W"; // front
		this._allColours[right] = "B"; // right
	}
	else if (refNum == ref3Num)
	{
		// [0], [3], [2] should be the only values filled
		this._allColours[bottom] = "O"; // bottom
		this._allColours[back] = "Y"; // back
		this._allColours[right] = "G"; // right
	}
	else if (refNum == ref4Num)
	{
		// [0], [3], [4] should be the only values filled
		this._allColours[bottom] = "W"; // bottom
		this._allColours[back] = "R"; // back
		this._allColours[left] = "G"; // left
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
		this._allColours[top] = "O"; // top
		this._allColours[front] = "W"; // front
		this._allColours[right] = "B"; // right
	}
	else if (refNum == ref7Num)
	{
		// [5], [3], [2] should be the only values filled
		this._allColours[top] = "R"; // top
		this._allColours[back] = "Y"; // back
		this._allColours[right] = "G"; // right
	}
	else if (refNum == ref8Num)
	{
		// [5], [3], [4] should be the only values filled
		this._allColours[top] = "Y"; // top
		this._allColours[back] = "O"; // back
		this._allColours[left] = "B"; // left
	} */
	}
}




