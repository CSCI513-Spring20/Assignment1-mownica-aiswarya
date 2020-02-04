package ass1;

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
		System.out.println("Strategy: Strategic Search");
		int count = 1;
		int rCells = 1;
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				if(grid[i][j] != null) {
					count = searcharound(i,j,grid,count);
				//	System.out.println(count);
					count++;
					//System.out.println("cells"+i+","+j+"count is "+count);
					//System.out.println(count);
				}
				if(count==8) break;
				rCells++;
			}
		}
		
		return rCells;
	}
	private static int searcharound(int i,int j,String[][] grid,int count) {
		//System.out.println("cells"+i+","+(j)+"count is "+count);
		if( i>=2 && j>=2 && i<24 && j<24) {
	if(grid[i-1][j-1] != null) {
		count++;
		grid[i-1][j-1] = null;
	}
	if(grid[i-1][j] != null) {
		count++;
		grid[i-1][j] = null;
	}
	if(grid[i-1][j+1] != null) {
		count++;
		grid[i-1][j+1] = null;
	}
	if(grid[i][j-1] != null) {
		count++;
		grid[i][j-1] = null;
	}
	if(grid[i][j+1] != null) {
		count++;
		grid[i][j+1] = null;
	}
	if(grid[i+1][j-1] != null) {
		count++;
		grid[i+1][j-1] = null;
	}
	if(grid[i+1][j] != null) {
		count++;
		grid[i+1][j] = null;
	}
	if(grid[i+1][j+1] != null) {
		count++; 
		grid[i+1][j+1] = null;
	}
		
	}
		else if (i<2 && j<2) {
			if(grid[i][j+1] != null) {
				count++;
				//System.out.println("cells"+i+","+(j+1)+"count is "+count);
				//System.out.println(count);
				
				//System.out.println(count);
				//System.out.println("entered");
				grid[i][j+1] = null;
			}
			if(grid[i+1][j] != null) {
				count++;
				grid[i+1][j] = null;
			}
			if(grid[i+1][j+1] != null) {
				count++; 
				grid[i+1][j+1] = null;
			}
			
		}
		
		return count;
	}
	
}
