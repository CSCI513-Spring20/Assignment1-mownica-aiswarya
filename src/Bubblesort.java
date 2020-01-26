
import java.util.Timer;
import java.util.TimerTask;


public class Bubblesort {
	public static Timer timer;
long startTime = System.currentTimeMillis();
public void bubbleSort(int ar[])
{
 for(int i=(ar.length-1);i>=0;i--)
 {
	 for(int j=1;j<=i;j++)
	 {
		 if(ar[j-1]>ar[j])
		 {
			 int temp=ar[j-1];
			 ar[j-1]=ar[j];
			 ar[j]=temp;
		 }
	 }
 }
}
 long endTime = System.currentTimeMillis();
 public long getSortTime()
 {   
	   long totalTime;
	   return totalTime= endTime-startTime;
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
 

 
 
 public String strategyName()
 {
	 
	return "Bubble Sort";
	 
 }
}
