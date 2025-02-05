
public class BubbleSort implements SortStrategy{
	long startTime,endTime=0;
	long totalTime=0;
	@Override
	public void sort(long[] ar) {
		startTime = System.currentTimeMillis();
		// TODO Auto-generated method stub
		for (int i = (ar.length - 1); i >= 0; i--)
		{
			for (int j = 1; j < i; j++)
			{
				if (ar[j-1] > ar[j])
				{
					long temp = ar[j-1];
					ar[j-1] = ar[j];
					ar[j] = temp;
				}
			}
		}
	}
	@Override
	public long getSortTime() {
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Time taken for Bubble Sort: " + totalTime);
		return totalTime;
	}
	
}
 