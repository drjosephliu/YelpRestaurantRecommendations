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
		assertEquals(r1.getSize(),2);
	}
//
//	@Test
//	public void testGetAvgRating() {
//		Graph a = new Graph();
//		a.addEdge("user11", "rest11", 5);
//		a.addEdge("user12", "rest11", 4);
//		a.addEdge("user12", "rest12", 3);
//		a.addEdge("user13", "rest11", 4);
//		a.addEdge("user13", "rest12", 5);
//		
//		RestaurantNode r = a.getRestaurant("rest12");
//		assertTrue(r.getAvgRating("user11")==4.0);
//	}

}
