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

public class Main {
	
	public static void main (String[] args)
	{
		  // top half
		  // string YellowBlueRedCube[3]; reference piece 5 --> top left front
		  // string YellowRedGreenCube[3]; reference piece 6 --> top right front
		  // string YellowGreenOrangeCube[3]; reference piece 7 --> top right back
		  // string YellowOrangeBlueCube[3]; reference piece 8 -- > top left back
		
		   // bottom half  
		   //string WhiteBlueRedCube[3]; reference piece 1 --> bottom left front
		   //string WhiteRedGreenCube[3]; reference piece 2 --> bottom right front
		   //string WhiteGreenOrangeCube[3]; reference piece 3 --> bottom right back
		   //string WhiteOrangeBlueCube[3]; reference piece 4 --> bottom left back
		
		
		
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
					System.out.println((i + 1) + " " + (i2 + 1) + " " + (i3 + 1) + "=====" + rubiksCube[i][i2][i3]);
				}
			}
		}
			
	}

}
