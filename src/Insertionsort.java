import java.util.Timer;
import java.util.TimerTask;

public class Insertionsort {
	public static Timer timer;
	long startTime = System.currentTimeMillis();
 public void insertionSort(int[] ar)
 {
	for(int i=1;i<ar.length;i++) 
	{
		int index=ar[i];int j=i;
		while(j>0 && ar[j-1]>index)
		{
			ar[j]=ar[j-1];
			j--;
			
		}
		ar[j]=index;
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
