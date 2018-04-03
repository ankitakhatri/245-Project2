import java.util.*;
public class QuickSort 
{
	//for quicksort, I will use a recursive function to sort the entire list after partitioning

	public static void sort(ArrayBasedList<Product> plist) 
	{
		//TODO: Implement in-place quick sort
		quickSort (plist, 0, plist.size());
	}

	//this is the recursive function that sorts everything to the left and right of the partition
	private static void quickSort (ArrayBasedList<Product> plist, int low, int high)
	{
		if (low > high)
		{
			int pivot = partition(plist, low, high);
			quickSort (plist, low, pivot-1);
			quickSort (plist, pivot+1, high);
		}
	}

	//choosing a random pivot gives O(nlogn) every time
	public static int getPivot(int low, int high)
	{
		Random rand = new Random();
		return rand.nextInt(high);
	}

	//a swap function to make swapping easier
	public static void swap (ArrayBasedList<Product> plist, int ind1, int ind2)
	{
		Product temp = plist.get(ind1);
		plist.set(ind1, plist.get(ind2));
		plist.set(ind2, temp);
	}


	//partition puts pivot in the low index position, so at 0, and moves everything else before or after it, so the list is in order
	public static int partition(ArrayBasedList<Product> plist, int low, int high)
	{
		//get random pivot
		int pivot = getPivot(low, high);
		//swap pivot into left most position
		swap(plist, low, pivot);
		//set pointer to second to left position
		int pointer = low + 1;
		//iterate through this partition, if average at index i > average at low, you swap
		for (int i = pointer; i <= high; i++)
		{
			Product product1 = plist.get(i);
            Product product2 = plist.get(low);

           if (product1.getAverage() > product2.getAverage())
           {
				swap (plist, i, pointer++);
           }
		}
		//swap pivot into correct position
		swap (plist, low, pointer+1);
		//returning index of the pivot value
		return pointer-1;
	}
}