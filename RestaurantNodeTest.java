import static org.junit.Assert.*;

import org.junit.Test;

public class RestaurantNodeTest {

	@Test
	public void testIsUser() {
		RestaurantNode r1 = new RestaurantNode("111", "user11", 3.7);
		assertFalse(r1.isUser());
	}

	@Test
	public void testGetID() {
		RestaurantNode r1 = new RestaurantNode("111", "user11", 3.7);
		assertEquals("111", r1.getID());
	}

	@Test
	public void testGetSize() {
		RestaurantNode r1 = new RestaurantNode("111", "user11", 3.7);
		assertEquals(r1.getSize(),1);
	}
	
	@Test
	public void testAddRating() {
		RestaurantNode r1 = new RestaurantNode("111", "user11", 3.7);
		r1.addRating("user12", 4.5);
		assertEquals(r1.getSize(), 2);
	}

	@Test
	public void testGetAvgRating() {
		RestaurantNode r1 = new RestaurantNode("rest1");
		assertEquals(0.0, r1.getAvgRating(), 0.001);
		
		r1.addRating("user1", 1.0);
		r1.addRating("user2", 2.0);
		r1.addRating("user3", 3.0);
		r1.addRating("user4", 4.0);
		r1.addRating("user5", 5.0);
		assertEquals(3.0, r1.getAvgRating(), 0.001);
	}
	
	@Test
	public void testGetRating() {
		RestaurantNode r1 = new RestaurantNode("111", "user11", 3.7);
		assertEquals(3.7, r1.getRating("user11"), 0.001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetRatingThrowsException() {
		RestaurantNode r1 = new RestaurantNode("111", "user11", 3.7);
		r1.getRating("user doesn't exist");
	}

}
