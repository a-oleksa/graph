// Credits:Robert Sedgewick, Algorithms in C++, Parts 1-4:
//Fundamentals, Data Structure, Sorting, Searching 3rd Edition 

public class intStack
{
	private Node head;
	private int size;
	private class Node
	{
		int item; Node next;
		Node( int e, Node t )
		  { item = e; next = t; }
	}

	public intStack( )
	{
		head = null;
		size = 0;
	}

	public boolean empty()
	{
		return (head == null );
	}

	public void push( int e )
	{
		head = new Node( e, head );
		size++;
	}

	public int pop()
	{
		int v = head.item; Node t  = head.next;
		head = t;
		return v;
	}

	public int top()
	{
		return empty()==true ? -1 : head.item;
	}

	public int getSize()
	{
		return size;
	}

	
}
