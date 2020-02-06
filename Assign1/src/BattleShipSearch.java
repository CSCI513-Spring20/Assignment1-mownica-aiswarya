import java.util.Random;

public class BattleShipSearch

{
public static int horizontalSearch(String[][] grid)
{
System.out.println("Strategy: Horizontal Sweep");
int cells  = 1;   //stores the number of cells searched
int count = 1;    //counts the number cells found to contain a submarine and carrier
for(int i=0;i<25;i++) {
for(int j=0;j<25;j++) {
if(grid[i][j] != null)

count++;
if(count==8) break;  //if grid found carrier and submarine
cells++;
}
}
return cells;  //return number of cells searched
}


/**
* @param grid
* @return
*/
static int randomSearch(String[][] grid)
{
System.out.println("Strategy: Random Search");
int count = 1;  //counts the number of cells found to contain a submarine and carrier
int rCells = 1;
while(count<=8) {
int[] randomXY = createRandomNumbers(); //calls  random numbers generation function
if(grid[randomXY[0]][randomXY[1]] != null) {

count++;
}
rCells++;
}

return rCells;     //returning number of cells searched
}
/**
* @return
*/
/**
* @return
*/
public static int[] createRandomNumbers() {
// TODO Auto-generated method stub
Random ran = new Random();
int x = 0+ran.nextInt((25-0)+0);  //generates random x coordinates
int y = 0+ran.nextInt((25-0)+0);  //generates random y coordinates
return new int[] {x ,y};          //returns x,y coordinates

}
	
	public static int Strategysearch(String[][] grid) {
	
		int rcells = 0;
		int count =0;
		int carr= 0;
		int sub =0;
		int[] carrier = new int[2];
		int[] submarine = new int[2];
		int[][] grid1 = new int[25][25];
		
		
		
	while(count!=2) {
			int[] randomXY = createRandomNumbers();
			if(grid1[randomXY[0]][randomXY[1]]!=1) {
				
				grid1[randomXY[0]][randomXY[1]] =1;
				rcells++;
			if(grid[randomXY[0]][randomXY[1]] == "c" & carr == 0) {
				carr = 1;
				count++;
				carrier[0] =randomXY[0];
				carrier[1] =randomXY[1];
				
			}
			else if(grid[randomXY[0]][randomXY[1]] == "s" & sub == 0) {
				sub = 1;
				count++;
				submarine[0] =randomXY[0];
				submarine[1] =randomXY[1];
			}
			}
		}
		return rcells;
	}
	
}


		
	