
public class SelectionSort implements SortStrategy{
	long startTime,endTime=0;
	long totalTime=0;
	@Override
	public void sort(long[] ar) {
		
		// TODO Auto-generated method stub
		startTime = System.currentTimeMillis();
		for (int i = 0; i < ar.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < ar.length; j++)
				if (ar[j] < ar[min])
					min = j;
			long temp = ar[i];
			ar[i] = ar[min];
			ar[min] = temp;
		}
	}

	@Override
	public long getSortTime() {
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Time taken for Selection Sort: " + totalTime);
		return totalTime;
	}

}
