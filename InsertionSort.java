public class InsertionSort 
{

	public static void sort(ArrayBasedList<Product> plist)
	{
        //TODO: Implement stable in-place insertion sort
        //i and j are indexes of the products
        int i;
        int j; 
        //keys to get the product, then find average of ratings of the product

        for (i = 1; i< plist.size(); i++)
        {
	        	//compare product1 and product2 using comparable function
            //if product1 > product2, don't swap because it returns -1 (if they are the same, returns 0, this is stable/in place so we don't swap)
            //if product2 > product1, you want the higher product in front, so this returns 1, and you swap
	        	for (j = i - 1; j>=0; j--)
	        	{
                Product product1 = plist.get(j);
                Product product2 = plist.get(j+1);

                int difference = product1.compareTo(product2);
                if (difference>0)
                {
                    //swap using temp product
                    Product temp = product1;
                    plist.set(j, product2);
                    plist.set(j+1, temp);
                } 
                else 
                {
                    break;
                }
	        		
	        	}
        }
    }
}