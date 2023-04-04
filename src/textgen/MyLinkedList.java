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
		head = new LLNode<E>(null, null, null);
		tail = new LLNode<E>(null, null, head);
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) throws NullPointerException
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("Null value");
		}
		
		
		add(size, element);
		return true;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		LLNode<E> currentNode = getNode(index);
		return currentNode.getData();
	}

	

	
	private LLNode<E> getNode(int index) {
		LLNode<E> node;
		if(index < size / 2) {
			node = head.next;
			for(int i = 0; i < index; i++) {
				node = node.next;
			}	
		} else {
			node = tail;
			for(int i = size; i > index; i--) {
				node = node.prev;
			}
		}
		
		return node;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) throws IndexOutOfBoundsException, NullPointerException
	{
		// TODO: Implement this method
        LLNode<E> pred, succ;
        if (index < 0 || index > size) {
        	throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } 
        if (element == null) {
        	throw new NullPointerException();
        }
        else if (index == size) {
            pred = tail.prev;
            succ = tail;
        } else {
            succ = getNode(index);
            pred = succ.prev;
        }

        LLNode<E> newNode = new LLNode<E>(element, succ, pred);
        succ.prev = newNode;
        pred.next = newNode;
        size++;
        modCount++;
		
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
	public E remove(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		
        LLNode<E> node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        modCount++;
        return node.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) throws IndexOutOfBoundsException, NullPointerException
	{
		// TODO: Implement this method
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		if(element == null) {
			throw new NullPointerException("Null Value");
		}
	    LLNode<E> node = getNode(index);
	    E oldVal = node.data;
	    node.data = element;
	    return oldVal;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E data) 
	{
		this.data = data;
		this.prev = null;
		this.next = null;
	}
	
	
	public LLNode(E data, LLNode<E> next, LLNode<E> prev) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
	public E getData() {
		return data;
	}

}
