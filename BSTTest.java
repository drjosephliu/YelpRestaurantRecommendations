import static org.junit.Assert.*;

import org.junit.Test;

public class BSTTest {

	@Test
	public void testInsert() {
		BSTNode root = new BSTNode();
		BST test = new BST(root);
		
		RestaurantWrapper key = new RestaurantWrapper();
		test.insert(key);
		assertEquals(test.find(key), key);
	}

	@Test
	public void testRemove() {
		BSTNode root = new BSTNode();
		BST test = new BST(root);
		assertEquals(test.find(root.getRestaurantWrapper()), root.getRestaurantWrapper());
		RestaurantWrapper key = new RestaurantWrapper();
		test.insert(key);
		test.remove(key);
		assertTrue(test.find(key)==null);
		test.remove(root.getRestaurantWrapper());
		assertTrue(test.find(root.getRestaurantWrapper())==null);
		
	}

	@Test
	public void testFind() {
		BSTNode root = new BSTNode();
		BST test = new BST(root);
		assertEquals(test.find(root.getRestaurantWrapper()), root.getRestaurantWrapper());
		RestaurantWrapper key = new RestaurantWrapper();
		test.insert(key);
		assertEquals(test.find(key), key);
		RestaurantWrapper keyNotExist = new RestaurantWrapper();
		assertTrue(test.find(keyNotExist)==null);
	}

}
