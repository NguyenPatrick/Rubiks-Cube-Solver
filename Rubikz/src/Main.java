import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[])
	{	
	Scanner scan = new Scanner(System.in);
	RubiksCube newCube = new RubiksCube();

	newCube.startingMove();
	System.out.println("Done");

	
	

	/* BIGGEST TEST CASE
	// bottom row right, right row up, top row right, left row up,
	// front row right, right row up, back row right
	// solve: 2,0,0,0,2,2,2,0,2,1,1,1,0,0,0
	
	newCube.move(2);//
	newCube.move(0);
	newCube.move(0);
	newCube.move(0);//
	newCube.move(2);
	newCube.move(2);
	newCube.move(2);//
	newCube.move(0);//
	newCube.move(2);//
	newCube.move(1);
	newCube.move(1);
	newCube.move(1);//
	newCube.move(0);
	newCube.move(0);
	newCube.move(0);//
	
	/ *
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
	}
	*/


	
	
	/*  TEST CASE 1
	// bottom row right x2, right up	
	newCube.move(1);
	newCube.move(1);
	newCube.move(1);
	newCube.move(0);
	newCube.move(0); 
	*/
	
	/* if (refNum == ref1Num)
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

	
	
	
	
	
	
	
	
	
	

	/*
	 * 
	 * 	String legendOfCube = 
	    "=============================== \n"
	+    " Legend For 2x2x2 Rubiks Cube \n" 
	+   "=============================== \n"
	+    "| # |    Colors On Corner   | " + "\n"
	+   "===============================" + "\n"
	+    "| 1 | White, Blue, Red      | " + "\n"
	+    "| 2 | White, Red, Green     | " + "\n"
	+    "| 3 | White, Green, Orange  | " + "\n"
	+    "| 4 | White, Orange, Blue   | " + "\n"
	+    "| 5 | Yellow, Blue, Red     | " + "\n"
	+    "| 6 | Yellow, Red, Green    | " + "\n"
	+    "| 7 | Yellow, Green, Orange | " + "\n"
	+    "| 8 | Yellow, Orange, Blue  | " ;
	
	String colorCode = "| W = White | Y = Yellow | R = Red | O = Orange | G = Green | B = Blue |";
	
	System.out.println(legendOfCube);
	System.out.println();
	System.out.println(colorCode);
	System.out.println();
	
	Boolean finishedCube = false;
	Boolean finishedColor = false;
	String[][][] allColours = new String[2][2][2];
	int cubeNumberType;
	String colorType;
	
	for (int totalCorners = 1; totalCorners <= TOTAL_CORNERS; totalCorners ++)
	{
	while(finishedCube == false)
	{
	try 
	{	
	if (totalCorners == 1) // ref1
	{
	System.out.println("Enter Number Of The Corner In Lower Left Front Of The Cube");
	}
	else if (totalCorners == 2) // ref2
	{
	System.out.println("Enter Number Of The Corner In Lower Right Front Of The Cube");
	}
	else if (totalCorners == 3) // ref3
	{
	System.out.println("Enter Number Of The Corner In Lower Right Back Of The Cube");
	}
	else if (totalCorners == 4) // ref4
	{
	System.out.println("Enter Number Of The Corner In Lower Left Back Of The Cube");
	}
	else if (totalCorners == 5) // ref5
	{
	System.out.println("Enter Number Of The Corner In Upper Left Front Of The Cube");
	}
	else if (totalCorners == 6) // ref6
	{
	System.out.println("Enter Number Of The Corner In Upper Right Front Of The Cube");
	}
	else if (totalCorners == 7) // ref7
	{
	System.out.println("Enter Number Of The Corner In Upper Right Back Of The Cube");
	}
	else if (totalCorners == 8) // ref8
	{
	System.out.println("Enter Number Of The Corner In Upper Left Back Of The Cube");
	}
	
	cubeNumberType = Integer.parseInt(scan.nextLine());
	
	if(cubeNumberType > 0 && cubeNumberType <= 8 )
	{	
	while(finishedCube == false)
	{
	try 
	{	
	if (totalCorners > 0 && totalCorners <= 4)
	{
	System.out.println("Which Color Is At The Bottom?");
	}
	else
	{
	System.out.println("Which Color Is At The Top?");
	}
	
	colorType = scan.nextLine();
	
	if (colorType.equals("ANY OF THE ENUM") && colorType.equals("COLOR IN REF"))
	{
	
	}
	else
	{
	System.err.println("Invalid Color!");
	}	
	}
	catch (NumberFormatException error) 
	{	
	System.err.println("Invalid Input!");	    
	}
	}
	}	
	else
	{
	if (cornerState[totalCorners - 1] == false)
	{
	System.err.println("Piece Has Already Been Chosen");	
	}
	else
	{
	System.err.println("Not A Valid Piece!");	
	}	
	}
	} 	
	catch (NumberFormatException error) 
	{	
	System.err.println("Invalid Input!");	    
	}
	}
	}

	System.out.println("Enter In The Colours For The Piece In Bottom Of The Cube");
	System.out.println("Enter In The Colours For The Top Of The Cube");
	System.out.println("Enter In The Colours For The Front Of The Cube");
	System.out.println("Enter In The Colours For The Back Of The Cube");
	System.out.println("Enter In The Colours For The Left Of The Cube");
	System.out.println("Enter In The Colours For The Right Of The Cube");
	
	String [][][] rubiksCube = 
	{ 
                { 
                	// ref5, ref6, ref7, ref8
                   {"YellowBlueRedCube", "YellowRedGreenCube"}, {"YellowGreenOrangeCube", "YellowOrangeBlueCube"}
                },
                
                {  
                	// ref1, ref2, ref3, ref4
                   {"WhiteBlueRedCube", "WhiteRedGreenCube"}, {"WhiteGreenOrangeCube", "WhiteOrangeBlueCube"}
                } 
             };
	
	for (int i = 0; i < 2; i ++)
	{
	for (int i2 = 0; i2 < 2; i2 ++)
	{
	for (int i3 = 0; i3 < 2; i3 ++)
	{
	//	System.out.println((i + 1) + " " + (i2 + 1) + " " + (i3 + 1) + "=====" + rubiksCube[i][i2][i3]);
	}
	}
	}
	*/	
	}
}




