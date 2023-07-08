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

	private static final int LONG_LIST_LENGTH = 10; 

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
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		
		//try to remove from an empty list
		try { 
			emptyList.remove(0);
			fail("Check removing from empty list");
		} catch (IndexOutOfBoundsException e) {
			
		}
		
		//try to remove with invalid index
		try {
			shortList.remove(10);
			fail("Check removing invalid index");
		} catch(IndexOutOfBoundsException e) {
			
		}
		try {
			shortList.remove(-10);
			fail("Check removing invalid index");
		} catch(IndexOutOfBoundsException e) {
			
		}
		//test multiple removes from long list
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.remove(0));
		}
		
		//test removes from short list until empty
		assertEquals("Check shortlist A", "A", shortList.remove(0));
		assertEquals("Check shortlist B", "B", shortList.remove(0));
		
		try {
			shortList.remove(0);
			fail("Check removing from shortlist after empty");
		} catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		//test adding null element, add should throw null pointer
		try {
			emptyList.add(null);
			fail("Check adding null to empty");
			
		} catch (NullPointerException e) {
			
		}
		//test adding single element to empty list
			emptyList.add(10);
		
		//retrieve previously added value from empty list
		assertEquals("Retrieve val from empty is correct", 
				(Integer)10, emptyList.get(0));
		
		//try adding null to small list
		try {
			shortList.add(null);
			fail("Check adding null to small");
		} catch (NullPointerException e) {
			
		}
		//try adding C to small list
			shortList.add("C");
		//Retrieve previously added value
		assertEquals("Retrieve val from small is correct", 
				(String)"C", shortList.get(2));
		//try adding null to large list
		try {
			longerList.add(null);
			fail("Check adding null to long");
			
		} catch (NullPointerException e) {
			
		}
		
			longerList.add(22);
		
		//test getting index from long
		assertEquals("Index of long is correct", (Integer)22, longerList.get(10));
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		
		//test sizes of lists based on initial values
		assertEquals("Check getting size of empty list", 0, emptyList.size());
		assertEquals("Check getting size of short list", 2, shortList.size());
		assertEquals("Check getting size of longer list", 10, longerList.size());
		assertEquals("Check getting size of list1", 3, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		
		//test adding null element
		try {
			emptyList.add(0, null);
			fail("Check adding null to emptyList");
		} catch(NullPointerException n) {
			
		}
		//test adding at invalid index
		try {
			emptyList.add(10, 10);
			fail("Check adding invalid index to empty");
		} catch(IndexOutOfBoundsException e) {
			
		}
		try {
			emptyList.add(-10, 10);
			fail("Check adding invalid index to empty");
		} catch(IndexOutOfBoundsException e) {
			
		}
		
		//test adding to empty list
		emptyList.add(0, 15);
		assertEquals("Check adding to empty list", (Integer)15, emptyList.get(0));
		//test adding to front, middle of shortList
		shortList.add(0, "X");
		shortList.add(2, "Y");
		shortList.add(3, "Z");
		assertEquals("Check adding to front of shortList", "X", shortList.get(0));
		assertEquals("Check adding to front of shortList", "A", shortList.get(1));
		assertEquals("Check adding to middle of shortList", "Y", shortList.get(2));
		assertEquals("Check adding to middle of shortList", "Z", shortList.get(3));
		assertEquals("Check adding to middle of shortList", "B", shortList.get(4));
		assertEquals("Check shortList size", 5, shortList.size());
		
		//test adding to last position in longer list
		longerList.add(9, 10);
		assertEquals("Check adding to longerList", (Integer)9, longerList.get(10));
		assertEquals("Check longer list size", 11, longerList.size());
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		
		//test adding null element
		try {
			shortList.set(1, null);
			fail("Check setting shortList element to null");
		} catch (NullPointerException n) {
			
		}
		//test with invalid index
		try {
			shortList.set(10, "X");
			fail("Check set with invalid index");
		} catch (IndexOutOfBoundsException i) {
			
		}
		//test with emptyList
		try {
			emptyList.set(0, 300);
			fail("Check set with invalid index");
		} catch (IndexOutOfBoundsException i) {
			
		}
		//test adding to index 1 and 0 on shortList
		shortList.set(1, "X");
		assertEquals("Check setting in shortList", "X", shortList.get(1));
		shortList.set(0, "Z");
		assertEquals("Check setting to 0 index in shortList", "Z", shortList.get(0));
		
		//test setting at last index on longerList
		longerList.set(9, 0);
		assertEquals("Check setting last element in longerList", (Integer)0, longerList.get(9));
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
