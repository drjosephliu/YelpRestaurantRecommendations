import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class UserNodeTest {

	@Test
	public void testIsUser() {
		UserNode u1 = new UserNode("user11","rest11",3.7);
		assertTrue(u1.isUser());
	}

	@Test
	public void testGetID() {
		UserNode u1 = new UserNode("user11","rest11",3.7);
		assertEquals(u1.getID(), "user11");
	}

	@Test
	public void testAddRating() {
		UserNode u1 = new UserNode("user11","rest11",3.7);
		u1.addRating("rest12", 4.5);
		assertEquals(u1.getSize(), 2);
	}


	@Test
	public void testGetSize() {
		UserNode u1 = new UserNode("user11","rest11",3.7);
		assertEquals(u1.getSize(), 1);
	}
	
	@Test
	public void testGetRating() {
		UserNode u1 = new UserNode("user1", "rest1", 3.4);
		assertEquals(3.4, u1.getRating("rest1"), 0.001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetRatingThrowsException() {
		UserNode u1 = new UserNode("user1", "rest1", 3.4);
		u1.getRating("rest unknown");
	}
	
	@Test
	public void testGetRatings() {
		HashMap<String, Double> testRatings = new HashMap<>();
		testRatings.put("rest1", 3.4);
		UserNode u1 = new UserNode("user1", "rest1", 3.4);
		assertEquals(testRatings, u1.getRatings());
	}
	
	@Test
	public void testAddRecommendationsBST() {
		fail("Test not implemented");
	}
	
	@Test
	public void testGetRecommendationsBST() {
		fail("Test not implemented");
	}

}
