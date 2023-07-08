package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>();
		tail = new LLNode<E>();
		head.data = null;
		tail.data = null;
		head.next = tail;
		head.prev = null;
		tail.next = null;
		tail.prev = head;
		
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Element is null.");
		}
		LLNode<E> newNode = new LLNode<E>(element);
		tail.prev.next = newNode;
		newNode.prev = tail.prev;
		newNode.next = tail;
		tail.prev = newNode;
		size++;
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index > size - 1 || size == 0) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		LLNode<E> curr;
		if (index < ((size )/2)) {
		 curr = head;
		
		for (int i = 0; i <= index; i++) {
			curr = curr.next;
			if (i == index) {
				break;
			}
		}
		} else {
			curr = tail;
			
			for (int i = size - 1; i >= 0; i--) {
				curr = curr.prev;
				if (i == index) {
					break;
				}
			}
		}
		return curr.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Cannot add a null element");
		}
		if (index < 0 || index > size - 1 && index != 0 || ((size == 0) && (index != 0))) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		 LLNode<E> curr;
		 LLNode<E> newNode = new LLNode<E>(element);
		 
		 if (index < (size)/2) {
			 curr = head;
			 
			 for (int i = 0; i <= index; i++) {
					curr = curr.next;
					if (i == index) {
						curr.prev.next = newNode;
						newNode.prev = curr.prev;
						newNode.next = curr;
						curr.prev = newNode;
						size++;
						return;
					}
			 }
		 } else {
			 curr = tail;
			 
			 if (size == 0) {
				 curr.prev.next = newNode;
					newNode.prev = curr.prev;
					newNode.next = curr;
					curr.prev = newNode;
					size++;
					return;
			 }
			 
			 for (int i = size - 1; i >= 0; i--) {
					curr = curr.prev;
					if (i == index) {
						curr.prev.next = newNode;
						newNode.prev = curr.prev;
						newNode.next = curr;
						curr.prev = newNode;
						size++;
						return;
					}
				}
		 }
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index > size - 1 || size == 0) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		
		LLNode<E> curr;
		E data = null;
		if (index < (size)/2) {
			curr = head;
			
			 for (int i = 0; i <= index; i++) {
				 curr = curr.next;
				 
				 if (i == index) {
					 curr.prev.next = curr.next;
					 curr.next.prev = curr.prev;
					 curr.next = null;
					 curr.prev = null;
					 data = curr.data;
					 size--;
					 break;
				 }
			 }
		} else {
			curr = tail;
			
			 for (int i = size - 1; i >= 0; i--) {
				 curr = curr.prev;
				 
				 if (i == index) {
					 curr.prev.next = curr.next;
					 curr.next.prev = curr.prev;
					 curr.next = null;
					 curr.prev = null;
					 data = curr.data;
					 size--;
					 break;
				 }
			 }
		}
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		
		if (element == null) {
			throw new NullPointerException("Element is null.");
		}
		if (index < 0 || index > size - 1 || size == 0) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		E data = null;
		LLNode<E> curr;
		
		if (index < ((size )/2)) {
		 curr = head;
		
		for (int i = 0; i <= index; i++) {
			
			curr = curr.next;
			
			if (i == index) {
				data = curr.data;
				curr.data = element;
				break;
			}
		}
		} else {
			curr = tail;
			
			for (int i = size - 1; i >= 0; i--) {
				
				curr = curr.prev;
				
				if (i == index) {
					data = curr.data;
					curr.data = element;
					break;
				}
			}
		}
		
		return data;
	}   


public String toString() {
	
	LLNode<E> curr = head;
	String output = "";
	for (int i = 0; i < size; i++) {
		curr = curr.next;
		System.out.println("Node " + i + " :" + curr.data);
		output += (i + ": " + curr.data);
	}
	System.out.println("----");
	return output;
}
}
class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E d) 
	{
		this.data = d;
		this.prev = null;
		this.next = null;
	}
	public LLNode() {
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	

}

