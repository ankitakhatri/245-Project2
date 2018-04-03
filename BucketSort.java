public class BucketSort 
{
	//for bucketsort, I will create an arraybasedlist of arraybasedlists and make each "bucket" an arraybasedlist of products, then sort each "bucket"
	//using insertion sort. The buckets will go from 0-9, so I will have 10 buckets.
	
	public static void sort(ArrayBasedList<Product> plist) 
	{
        //TODO: Implement bucket sort. 

        //buckets will be an array based list of array based lists
        ArrayBasedList<ArrayBasedList> buckets = new ArrayBasedList<ArrayBasedList>(6);
        //bucket is an array based list of products
        //ArrayBasedList<Product> bucket = new ArrayBasedList<Product>();

        //set each arraybasedlist in buckets to bucket, which is an arraybased list of products
        //we have 6 buckets for the averages-- 0, 1, 2, 3, 4 , 5 -- 0 would mean empty product list
        for (int x = 0; x < 6; x++)
        {
        	ArrayBasedList<Product> bucket = new ArrayBasedList<Product>();
        	//set each arraybasedlist in buckets to an arraybasedlist of products
        	buckets.add(bucket);
        }

        //put products into buckets
        for (int i = 0; i < plist.size(); i++)
        {
        	Product product = plist.get(i);
        	double average = product.getAverage();

        	int bucketnumber = (int)average;

        	ArrayBasedList chosenbucket = buckets.get(bucketnumber);
        	chosenbucket.add(product);
        }

        //sort within buckets using insertion sort
        InsertionSort insertionsort = new InsertionSort();
        for (int n = 0; n < buckets.size(); n++)
        {
        	insertionsort.sort(buckets.get(n));
        	System.out.println(buckets.get(n));
        }

        //write sorted buckets back into plist
        int index = 0;
        Product currentproduct;
        for (int j = 0; j < buckets.size(); j++)
        {
        	ArrayBasedList<Product> currentbucket = buckets.get(j);
        	for (int k = 0; k < currentbucket.size(); k++)
        	{
        		currentproduct = currentbucket.get(k);
        		plist.set(index, currentproduct);
        		index++;
        	}
        }

    }

	
}