package common;

public class DoublyLinkList<T>
{
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public DoublyLinkList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return (size == 0);
	}
	
	public void insertFirst(T item)
	{
		Node<T> tmp_nd = new Node<T>();
		tmp_nd.setElement(item);
		tmp_nd.setNext(head);
		if(head != null)
		{
			head.setPrevious(tmp_nd);
		}
		if(tail == null)
		{
			tail = tmp_nd;
		}
		head = tmp_nd;
		size++;
	}
	
	public void insertLast(T item)
	{
		Node<T> tmp_nd = new Node<T>();
		tmp_nd.setElement(item);
		tmp_nd.setPrevious(tail);
		if(tail != null)
		{
			tail.setNext(tmp_nd);
		}
		if(head == null)
		{
			head = tmp_nd;
		}
		tail = tmp_nd;
		size++;
	}
	
	public void removeFirst() throws EmptyExceptions
	{
		if(size == 0)
		{
			throw new EmptyExceptions("Size is empty");
		}
		
		Node<T> tmp_node = head;
		head = head.getNext();
		head.setPrevious(null);
		size--;
	}
	
	public void removeLast() throws EmptyExceptions
	{
		if(size == 0)
		{
			throw new EmptyExceptions("Size is empty");
		}
		
		Node<T> tmp_node = tail;
		tail = tail.getPrevious();
		tail.setNext(null);
		size--;
	}

	/*
	 * @return 1 if the item is found and 0 if the item is not found.
	 * */
	public int searItemForward(T item)
	{
		Node<T> tmp_node = head;
		int result = 0;
		T element = null;
		while(tmp_node != null)
		{
			element = tmp_node.getElement();
			if(element == item)
			{
				result = 1;
				return result;
			}
			tmp_node = tmp_node.getNext();
		}
		return result;
	}
	
	public int searItemBackward(T item)
	{
		Node<T> tmp_node = tail;
		T element = null;
		int result = 0;
		while(tmp_node != null)
		{
			element = tmp_node.getElement();
			if(element == item)
			{
				result = 1;
				return result;
			}
			tmp_node = tmp_node.getPrevious();
		}
		return result;
	}
	
	public String PrintiteratorForward()
	{
		Node<T> tmp_node = head;
		String result = "";
		while(tmp_node != null)
		{
			result += tmp_node.getElement() + "";
			tmp_node = tmp_node.getNext();
		}
		return result;
	}
	
	public String PrintiteratorBackward()
	{
		Node<T> tmp_node = tail;
		String result = "";
		while(tmp_node != null)
		{
			result += tmp_node.getElement() + "";
			tmp_node = tmp_node.getPrevious();
		}
		return result;
	}
	
	public void removeAllFirst() throws EmptyExceptions
	{
		while(size != 1)
		{
			this.removeFirst();
		}
	}
	
	public void removeAllLast() throws EmptyExceptions
	{
		while(size != 1)
		{
			this.removeLast();
		}
	}
	
	
	public T getHead()
	{
		Node<T> tmp_head = head;
		T item = tmp_head.getElement();
		return item;
	}
	
	public T getTail()
	{
		T tmp_tail = tail.getElement();
		return tmp_tail;
	}
}
