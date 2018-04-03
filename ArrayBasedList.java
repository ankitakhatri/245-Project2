import java.util.AbstractList;
import java.util.*;

/**
 * TODO: Implement your own array based list. For full credit,
 *       do not import ArrayList.
 *
 */
public class ArrayBasedList<E> extends AbstractList<E> {
	
	//TODO: Create instance members
	private static final int SIZE = 100;
	private E arr[];
	private int size;
	
	//TODO: Create constructor(s)
	
	public ArrayBasedList() 
	{
		// TODO: Complete
		this.arr = (E[]) new Object [SIZE];
		this.size = 0;
	}

	public ArrayBasedList(int size)
	{
		this.arr = (E[]) new Object [size];
		this.size = 0;
	}
	
	//TODO: Create and complete instance methods

	@Override
	public E get(int index) 
	{
		//TODO: Complete
		//if index is < 0, doesn't exist, if it's greater than the pointer for size, it can't be accessed
		if (index < 0 || index >= size)
		{
			throw new IllegalArgumentException ("Index: " + index + " is not valid");
		}
		return this.arr[index];
	}

	@Override
	public int size() 
	{
		E newArr[];
		// TODO: Complete
		//if size is at the maximum, then add SIZE to dynamically make it bigger
		if (this.size == this.arr.length)
		{
			newArr = (E[]) new Object [this.arr.length + SIZE];
			for (int i = 0; i < this.arr.length; i++)
			{
				newArr[i] = arr[i];
			}
			this.arr = newArr;
		}
		return this.size;
	}
	
	@Override
	public boolean add(E e) 
	{
		// TODO: Complete
		//any multiple of 100 means the array based list is full, so call size function to add SIZE elements
		if (size % 100 == 0)
		{
			size();
		}
		//add to the end and increase the pointer for size
		this.arr[size] = e;
		this.size ++;
		return true;
	}
	
	@Override
	//add at given index, and move everything else down one index, and increase pointer for size
	public void add(int index, E element) 
	{
		// TODO: Complete
		for (int i = index-1; i >= 0; i--)
		{
			arr [i+1] = arr [i];
		}
		arr[index] = element;
		this.size++;
	}
	
	@Override
	//replace element and given index
	public E set(int index, E element) 
	{
		// TODO: Complete
		this.arr[index] = element;
		return element;
	}
	
	@Override
	//remove element at given index, move everything down one index, and decrease pointer for sizeip
	public E remove(int index) 
	{
		//TODO: Complete
		for(int i = index; i < this.arr.length -1; i++)
		{
        	arr[i] = arr[i + 1];
      	}
      	this.size--;
		return null;
	}
}