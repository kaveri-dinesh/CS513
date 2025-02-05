
public class InsertionSort implements SortStrategy{
	long startTime,endTime=0;
	long totalTime=0;
	@Override
	public void sort(long[] ar) {
		// TODO Auto-generated method stub
		startTime = System.currentTimeMillis();
		for (int i=1; i < ar.length; i++)
		{
			long index = ar[i]; int j = i;
			while (j > 0 && ar[j-1] > index)
			{
				ar[j] = ar[j-1];
				j--;
			}
			ar[j] = index;
		}
	}

	@Override
	public long getSortTime() {
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Time taken for Insertion Sort: " + totalTime);
		return totalTime;
	}	
}
