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
	public static void quickSort (ArrayBasedList<Product> plist, int low, int high)
	{
		if (low > high+1)
		{
			int p = partition(plist, low, high);
			quickSort (plist, low, p-1);
			quickSort (plist, p+1, high);
		}
	}

	//a swap function to make swapping easier
	public static void swap (ArrayBasedList<Product> plist, int ind1, int ind2)
	{
		Product temp = plist.get(ind1);
		plist.set(ind1, plist.get(ind2));
		plist.set(ind2, temp);
	}

	//choosing a random pivot gives more accurate running time
	public static int getPivot(int low, int high)
	{
		Random rand = new Random();
		return rand.nextInt((high-low) + 1) + low;
	}

	//partition puts pivot in the low index position, so at 0, and moves everything else before or after it, so the list is in order
	public static int partition(ArrayBasedList<Product> plist, int low, int high)
	{
		swap(plist, low, getPivot(low, high));
		int pointer = low + 1;
		for (int i = pointer; i <= high; i++)
		{
			Product product1 = plist.get(i);
            Product product2 = plist.get(low);

            int difference = product1.compareTo(product2);
            if (difference>0)
            {
            	swap(plist, i, pointer++);
			}
		}
		swap (plist, low, pointer+1);
		return pointer-1;
	}
}