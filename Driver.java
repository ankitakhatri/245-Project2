import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.io.*;

public class Driver {

	public static void main(String[] args) {
		ArrayBasedList<Product> plist = new ArrayBasedList<Product>();
		String delimiter = ",\"";
		String line = "";
		//TODO: Read .csv file from command line and parse into ArrayBasedList<Product>
		// You should not need to declare another ArrayBasedList<Product> in main

		//get file name from command line argument
		File input = null;
        if (0 < args.length) 
        {
            input = new File(args[0]);
        }
        //buffered reader to read input from file and parse into ArrayBasedList

        try
        {
// Note that if there are no command line arguments input will be null. This will cause a NullPointerException.
	        	BufferedReader br = new BufferedReader(new FileReader (input));System.out.println(input == null);
	        	while ((line = br.readLine()) != null) 
	            {
	            	String stringratings = "";
// Note that 10000 is hard coding, so this program will not work for any products with over 10,000 
// ratings. Even though this is a slim chance, it is not the best practice.
	            	int [] ratings = new int[10000];
                String[] elements = line.split(delimiter);
                String asin= "";
                Product product = new Product (asin, ratings);
                int m = 0;

                if (elements.length > 0)
                {
	                	//elements[0] is the asin and elements [1] is the array in string form starting from [ and ending with ]"
	                	asin = elements[0];
	                	product.setAsin(asin);
	                	stringratings = elements[1];
	                	//clean up the string and parse each element into the array ratings, then set as ratings for product
	                	//run for loop through the string indexes, remove brackets and quotes and add to int [] ratings accordingly
	                	for (int k = 0; k < stringratings.length()-1; k++)
	                	{	
	                		if (!stringratings.substring(k, k+1).equals("[") && !stringratings.substring(k, k+1).equals("]") && !stringratings.substring(k, k+1).equals(",") && !stringratings.substring(k, k+1).equals(" "))
	                		{
	                			ratings[m] = Integer.parseInt(stringratings.substring(k, k+1).trim());
	                			m++;
	                		}
	                	}
                }
                // product.setRatings(ratings);

                //don't add product to plist if it doesn't have ratings
                if (product.getRatings().length==0)
                {
                		break;
                }
                else
                {
                		plist.add(product);
                }
            }
// Remember to close resources	        	
	        	br.close();
        }
        catch (IOException f) 
        {
            System.out.println(f.getLocalizedMessage());
            System.exit(0);
        } 
		
		try {
			// This will test the certain edge case and accuracy of your sorts.
			// This is NOT comprehensive and your own tests need to done in 
			// addition to this test.
			//
			// TODO: To look the timing of your sorts, uncomment printTiming in the 
			// Test.java file. Large samples will take a long time to complete though.
			Test.test(plist, args);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | 
				IllegalArgumentException | InvocationTargetException | IOException e) {
			System.out.println("Test could not run/finish.");
		}
		
		//TODO: Sort based on averageRating from highest to lowest.

		//creat instance of insertion sort class, and call it on the plist
		
		InsertionSort insertionsort = new InsertionSort();
		insertionsort.sort(plist);
// Since sort is static, you do not need to create a new Object to call the function.
// ie. InsertionSort.sort(plist);

		//QuickSort quicksort = new QuickSort();
		//quicksort.sort(plist);

		//BucketSort bucketsort = new BucketSort();
		//bucketsort.sort(plist);
		
		//TODO: Write to a new .csv file named whatever the file being read is with "_sorted"
		//      added to it. So if the file being read is called ratings_Stuff.csv, your file
		//      will be called ratings_Stuff_sorted.csv. For this part, use any of your sorts.
		//      The file will have one ASIN per line.

		try{
		
			//make the original input name a string, get rid of the extra .csv by using substring, and add _sorted.csv to the end of the new filename
			String inputfile = input.toString();
// [X] Write the _sorted file. Not the _result file.
			String filename = inputfile.substring(0, inputfile.length()-4) + "_sorted.csv";
	        	FileWriter fw = new FileWriter(filename);
	        	PrintWriter pw = new PrintWriter(fw);
	        	//print the asins from each product in the arraybased list
	        	for (int x = 0; x < plist.size(); x++)
	        	{
	        		pw.println(plist.get(x).toString());
	        	}
	        	pw.close();
	    	}
        catch (IOException f) 
        {
            System.out.println("File not found.");
        } 
		
		try {
			// Requires both result and sorted files to be in current directory
			Test.testFile(args);
		} catch (IOException e1) {
			System.out.println("----------------------------------------");
			System.out.println("!! File Test: Could not read file. Check file naming.");
		} catch (IndexOutOfBoundsException e2) {
			System.out.println("----------------------------------------");
			System.out.println("!! File Test: Missing command line argument");
		}
	}

}