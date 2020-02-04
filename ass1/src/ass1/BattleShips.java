package ass1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BattleShips {
	static String[][] grid = new String[25][25]; // Creating 25 * 25 grid 
	
	public static void main(String args[]) {
		FileReader inputFile = null;
		   try {
			inputFile = new FileReader("src/input.txt"); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		readFile(inputFile);   	//Read File
	}
	
	public static void readFile(Reader file) {
		BufferedReader reader = new BufferedReader(file); //Reads the coordinates from input file from source
		String line;
		 try {
			while((line = reader.readLine()) != null) {
				//System.out.println(line);
				startGame(line);                         //calls the startGame for each game
				
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//For every Line in the File
	}
	
	public static void startGame(String line) {
		int count = 1;
		String value;
		String[] firstcarr = new String[2] ;
		String[] lastcarr = new String[2];
		String[] firstsub =new String[2];
		String[]  lastsub = new String[2];
		//System.out.println(line);
		int game=1;
		StringTokenizer st = new StringTokenizer(line, ")");  //tokenizing the coordinates 
		
		while(st.hasMoreTokens())
		{
			String xy = new String();
			xy = st.nextToken().replace("(","");
			String[] coords = xy.split(",");
			
			if(count>5) {
				if(count ==6)// prints the first coordinates for submarine
				    {
					firstsub[0] = coords[0];
					firstsub[1] = coords[1];
					//System.out.println("Carrier found: ("+firstsub[0]+","+firstsub[1]+")");
					}
					else if(count == 8) //prints the last coordinates for submarine
					{
					lastsub[0] = coords[0];
					lastsub[1] = coords[1];
					}
					value = "s"; //s =  submarine
					}
					else
					{
					if(count ==1)
					//printing  last coordinate carrier				
					{
					firstcarr[0] = coords[0];
					firstcarr[1] = coords[1];
					//System.out.println("Carrier found: ("+firstsub[0]+","+firstsub[1]+")");
					}
					else if(count == 5) //printing last  coordinates of carrier
					{
					lastcarr[0] = coords[0];
					lastcarr[1] = coords[1];
					}
					value = "c"; //c= carrier
					}
			storeInGrid(coords,value); // store c and s in grid
			
			count++;							
		}
		
		search(grid,firstcarr,lastcarr,firstsub,lastsub);							// Searching the grid
		clear(grid);                                                                //calling a method to clear the grid
	}
	
	public static void clear(String[][] grid)            // clearing the grid
	{
		
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				grid[i][j] = null;
			}
		}
	}
	
	public static void storeInGrid(String[] coords, String value) //storing the coordinates in grid
	{	
		int f = Integer.parseInt(coords[0]);		
		int g = Integer.parseInt(coords[1]);
		grid[f][g] = value;
	}
	
	public static void search(String[][] grid,String[] firstcarr,String[] lastcarr,String[] firstsub,String[] lastsub) {
		int hCells = BattleShipSearch.horizontalSearch(grid);  //calling horizontal search method
		System.out.println("Cells Searched Horizontally - "+hCells);	
		System.out.println("Carrier found: ("+firstcarr[0]+","+firstcarr[1]+") to ("+lastcarr[0]+","+lastcarr[1]+")  Submarine found: (" +firstsub[0]+","+firstsub[1]+") to ("+lastsub[0]+","+lastsub[1]+")");
		//System.out.println("Carrier found: ("+firstcarr[0]+","+firstcarr[1]+") to ("+lastcarr[0]+","+lastcarr[1]+"");
		int rCells = BattleShipSearch.randomSearch(grid);      //calling random search method
		System.out.println("Cells Searched Randomly - " + rCells);	
		System.out.println("Carrier found: ("+firstcarr[0]+","+firstcarr[1]+") to ("+lastcarr[0]+","+lastcarr[1]+")  Submarine found: (" +firstsub[0]+","+firstsub[1]+") to ("+lastsub[0]+","+lastsub[1]+")");
		int sCells = BattleShipSearch.Strategysearch(grid);    //calling strategy search method
		System.out.println("Cells Searched Strategically - " + sCells);	
		System.out.println("Carrier found: ("+firstcarr[0]+","+firstcarr[1]+") to ("+lastcarr[0]+","+lastcarr[1]+")  Submarine found: (" +firstsub[0]+","+firstsub[1]+") to ("+lastsub[0]+","+lastsub[1]+")");
	}

	
	
}
