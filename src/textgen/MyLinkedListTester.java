/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove() {
	    // check lower bound
	    try {
	        list1.remove(-1);
	        fail("Expected IndexOutOfBoundsException to be thrown");
	    } catch (IndexOutOfBoundsException e) {
	        // success
	    }

	    // check upper bound
	    try {
	        list1.remove(list1.size());
	        fail("Expected IndexOutOfBoundsException to be thrown");
	    } catch (IndexOutOfBoundsException e) {
	        // success
	    }

	    int a = list1.remove(0);
	    assertEquals("Remove: check a is correct ", 65, a);
	    assertEquals("Remove: check element 0 is correct ", (Integer) 21, list1.get(0));
	    assertEquals("Remove: check size is correct ", 2, list1.size());
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd() {
	    // Test null parameter exception
	    try {
	        list1.add(null);
	        fail("Expected NullPointerException");
	    } catch (NullPointerException e) {
	        // Test passed
	    }

	    MyLinkedList<String> list = new MyLinkedList<>();
	    list.add("Element 1");
	    list.add("Element 2");
	    assertEquals("Element 2", list.get(1));
	    list.add("Element 40");
	    assertEquals("Element 40", list.get(2));
	}

	
	/** Test the size of the list */
	@Test
	public void testSize() {
	    MyLinkedList<Integer> list = new MyLinkedList<>();
	    assertEquals(0, list.size());

	    list.add(10);
	    list.add(20);

	    assertEquals(2, list.size());

	    list.remove(0);

	    assertEquals(1, list.size());

	    assertFalse(list.isEmpty());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex() {
	    // check null parameter
	    try {
	        list1.add(0, null);
	        fail("Expected NullPointerException to be thrown");
	    } catch (NullPointerException e) {
	        // success
	    }

	    // check lower bound
	    try {
	        list1.add(-1, 10);
	        fail("Expected IndexOutOfBoundsException to be thrown");
	    } catch (IndexOutOfBoundsException e) {
	        // success
	    }

	    // check upper bound
	    try {
	        list1.add(list1.size() + 1, 10);
	        fail("Expected IndexOutOfBoundsException to be thrown");
	    } catch (IndexOutOfBoundsException e) {
	        // success
	    }

	    list1.add(1, 30);
	    assertEquals("AddAtIndex: check element is correct ", (Integer) 30, list1.get(1));
	    assertEquals("AddAtIndex: check size is correct ", 4, list1.size());
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet() {
	    // check null parameter
	    try {
	        list1.set(0, null);
	        fail("Expected NullPointerException to be thrown");
	    } catch (NullPointerException e) {
	        // success
	    }

	    // check lower bound
	    try {
	        list1.set(-1, 10);
	        fail("Expected IndexOutOfBoundsException to be thrown");
	    } catch (IndexOutOfBoundsException e) {
	        // success
	    }

	    // check upper bound
	    try {
	        list1.set(list1.size(), 10);
	        fail("Expected IndexOutOfBoundsException to be thrown");
	    } catch (IndexOutOfBoundsException e) {
	        // success
	    }

	    Integer oldValue = list1.set(1, 30);
	    assertEquals("Set: check old value is correct ", (Integer) 21, oldValue);
	    assertEquals("Set: check new value is correct ", (Integer) 30, list1.get(1));
	}
	
	
	// TODO: Optionally add more test methods.
	
	public void testAdd() {
	    // check null parameter
	    try {
	        list1.add(null);
	        fail("Expected NullPointerException to be thrown");
	    } catch (NullPointerException e) {
	        // success
	    }

	    // check upper bound
	    try {
	        list1.add(4, 10);
	        fail("Expected IndexOutOfBoundsException to be thrown");
	    } catch (IndexOutOfBoundsException e) {
	        // success
	    }

	    list1.add(2, 55);
	    assertEquals("Add: check element is correct ", (Integer) 55, list1.get(2));
	    assertEquals("Add: check size is correct ", 4, list1.size());
	}
	
	
}
