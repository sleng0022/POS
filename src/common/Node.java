package common;

public class Node<T>
{
	private Node<T> next;
	private Node<T> previous;
	private T item;
	
	public Node()
	{
		next = null;
		previous = null;
		item = null;
	}
	
	public Node<T> getNext()
	{
		return next;
	}
	
	public Node<T> getPrevious()
	{
		return previous;
	}
	
	public T getElement()
	{
		return item;
	}
	
	public void setNext(Node<T> nxt)
	{
		this.next = nxt;
	}
	
	public void setPrevious(Node<T> prev)
	{
		this.previous = prev;
	}
	
	public void setElement(T element)
	{
		this.item = element;
	}
}
