import java.util.*;
//implement comparable to compare the average ratings for insertion sort
public class Product implements Comparable<Product>
{
	
	//TODO: Declare/initialize instance members
	private String asin;
	private int [] ratings;
	
	//TODO: Create constructor(s)
	public Product(String asin, int[] ratings) 
	{
		//TODO: Complete
		this.asin = asin;
		this.ratings = Arrays.copyOf(ratings, ratings.length);
	}

	//setters and getters
	public String getAsin ()
	{
		return asin;
	}

	public void setAsin (String asin)
	{
		this.asin = asin;
	}

	public int[] getRatings ()
	{
		// if (this.ratings.length==0)
		// {
		// 	return null;
		// }
		return Arrays.copyOf(ratings, ratings.length);
	}

	public void setRatings (int[] ratings)
	{
		this.ratings = Arrays.copyOf(ratings, ratings.length);
	}
	
	//TODO: Create instance methods
	//compareTo to use in insertion sort
	public int compareTo(Product other)
	{
    	int [] ratings1 = this.getRatings();
    	int total1 = 0;
    	int ratingsize1 = 0;
    	while (ratingsize1 < ratings1.length && ratings1[ratingsize1] != 0)
    	{
    		total1+=ratings1[ratingsize1];
    		ratingsize1++;
    	}

    	//find average of the ratings of the key
    	double average1 = (double)total1/ratingsize1;

    	int [] ratings2 = other.getRatings();
    	int total2 = 0;
    	int ratingsize2 = 0;
    	while (ratingsize2 < ratings2.length && ratings2[ratingsize2] != 0)
    	{
    		total2+=ratings2[ratingsize2];
    		ratingsize2++;
    	}

    	//find average of the ratings of the key
    	double average2 = (double)total2/ratingsize2;

    	double difference = average1-average2;

    	//if difference < 0, average1 is less than average2, so needs to be swapped
    	if (difference<0)
    	{
    		return 1;
    	}
    	//average1 > average2, no swap needed
    	else if (difference>0)
    	{
    		return -1;
    	}
    	//return 0 if they are the same
    	return 0;
	}

	public double getAverage()
	{
		int [] ratings = this.getRatings();
    	int total = 0;
    	int ratingsize = 0;

    	while (ratingsize < ratings.length && ratings[ratingsize] != 0)
    	{
    		total+=ratings[ratingsize];
    		ratingsize++;
    	}
    	//find average of the ratings of the key
    	double average = (double)total/ratingsize;

    	if (ratingsize==0)
    	{
    		return 0;
    	}
    	return average;

    	//return average;
	}
	@Override
	public String toString() 
	{
		return asin;
	}
}