import java.util.Timer;
import java.util.TimerTask;

public class Selectionsort {
	public static Timer timer;
	public Selectionsort()
	{
		
	}
	long startTime = System.currentTimeMillis();
	public void Ssort(int[] ar)
	{
		int length1 = ar.length-1;
		for(int i=0;i<length1;i++)
		{
			 int min = i;
		      for (int j = i+1; j<length1;j++)
		      {
		            if (ar[j] < ar[min])
		            {
		            	min = j;
		            }
		      }  
		      int temp = ar[i];
		      ar[i] = ar[min];
			
		}
		
	}
   long endTime = System.currentTimeMillis();
   public long getSortTime()
   {   
	   long totalTime;
	   return totalTime= endTime-startTime;
   }
   
   public String strategyName()
   {
  	 
  	return "Bubble Sort";
  	 
   }
   
   public void resetTimer() {
		 TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		
		 };
		 timer = new Timer();
		 timer.schedule(timerTask, 1000);
	}
}
