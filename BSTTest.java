import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

/**
 * This class contains unit tests for the BST class
 * 
 * @author Keenan Park
 *
 */

public class BSTTest {

	@Test
	public void testInsert() {
		BST test = new BST();
		RestaurantNode r1 = new RestaurantNode("111", "user11", 3.7);
		RestaurantWrapper key = new RestaurantWrapper(r1);
		test.insert(key);
		assertEquals(test.find(key), key);
	}

	@Test
	public void sizeTest() {
		BST test = new BST();
		assertEquals(0, test.size());
	}

	@Test
	public void testRemove() {
		RestaurantWrapper key1 = new RestaurantWrapper(new RestaurantNode("111", "user11", 3.7));
		BST test = new BST();
		test.insert(key1);
		assertEquals(test.find(key1), key1);

		RestaurantWrapper key2 = new RestaurantWrapper(new RestaurantNode("1192", "user11", 5.0));
		test.insert(key2);
		test.remove(key2);

		assertEquals(null, test.find(key2));
		test.remove(key1);
		assertTrue(test.find(key1) == null);

	}

	@Test
	public void testRemove2() {
		BST test = new BST();
		RestaurantWrapper[] keys = new RestaurantWrapper[10];
		Random rand = new Random();
		for (int i = 0; i < keys.length; i++) {
			keys[i] = new RestaurantWrapper(new RestaurantNode("1" + i, "user1", 4.0));
			keys[i].addRating("" + i, rand.nextDouble() * 5);
			test.insert(keys[i]);
		}

		for (int i = 0; i < keys.length; i++) {
			assertEquals(keys[i], test.remove(keys[i]));
		}
	}

	@Test
	public void testFind() {
		BST test = new BST();
		RestaurantWrapper key1 = new RestaurantWrapper(new RestaurantNode("111", "user11", 3.7));
		test.insert(key1);
		assertEquals(test.find(key1), key1);
		RestaurantWrapper keyNotExist = new RestaurantWrapper(new RestaurantNode("110", "user1", 4.7));
		assertTrue(test.find(keyNotExist) == null);
	}

	@Test
	public void testThreshold() {
		BST test = new BST();
		RestaurantWrapper key1 = new RestaurantWrapper(new RestaurantNode("111", "user11", 3.7));
		RestaurantWrapper key2 = new RestaurantWrapper(new RestaurantNode("112", "user11", 3.7));
		RestaurantWrapper key3 = new RestaurantWrapper(new RestaurantNode("113", "user11", 3.7));
		key1.addRating("1", 3.5);
		key2.addRating("2", 4.0);
		key3.addRating("3", 5.0);
		test.insert(key1);
		test.insert(key2);
		test.insert(key3);

		List<RestaurantWrapper> expected = new ArrayList<>();
		expected.add(key3);
		expected.add(key2);
		assertEquals(expected, test.findThreshold(4.0));
	}

}
