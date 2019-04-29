import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RestaurantWrapperTest {
	
	private final String rest1 = "Shake Shack";
	private final String rest2 = "Honeygrow";
	private final String user1 = "Rongrong";
	private final String user2 = "Topher";
	private final String user3 = "Keenan";
	private final String user4 = "Dr Joe";
	private RestaurantWrapper rw1;
	private RestaurantWrapper rw2;
	
	@Before
	public void setup() {
		rw1 = new RestaurantWrapper(new RestaurantNode(rest1));
		rw2 = new RestaurantWrapper(new RestaurantNode(rest2));
	}
	
	@Test
	public void testGetID() {
		assertEquals(rest1, rw1.getID());
	}
	
	@Test
	public void getRestaurant() {
		RestaurantNode rest1Node = new RestaurantNode(rest1);
		assertEquals(rest1Node.getID(), rw1.getRestaurant().getID());
	}
	
	@Test
	public void getRatingsByCoReviewers() {
		assertTrue(rw1.getRatingsByCoReviewers().isEmpty());
	}
	
	@Test
	public void testAddRating() {
		rw1.addRating(user1, 2.4);
		assertEquals(1, rw1.getRatingsByCoReviewers().size());
	}
	
	@Test
	public void testGetAvgRating() {
		assertEquals(0.0, rw1.getAvgRating(), 0.001);
		
		rw1.addRating(user1, 3.0);
		rw1.addRating(user2, 2.5);
		rw1.addRating(user3, 4.5);
		rw1.addRating(user4, 2.0);
		
		assertEquals(3.0, rw1.getAvgRating(), 0.001);
	}
	
	@Test
	public void testCompareTo() {
		rw1.addRating(user1, 3.0);
		rw1.addRating(user2, 2.5);
		rw1.addRating(user3, 4.5);
		rw1.addRating(user4, 2.0);
		
		assertEquals(1, rw1.compareTo(rw2));
		assertEquals(-1, rw2.compareTo(rw1));
		
		rw2.addRating(user1, 3.0);
		rw2.addRating(user2, 2.5);
		rw2.addRating(user3, 4.5);
		rw2.addRating(user4, 2.0);
		
		assertEquals(0, rw1.compareTo(rw2));
	}
	
	@Test
	public void testEquals() {
		assertTrue(rw1.equals(rw1));
		assertFalse(rw1.equals("random string"));
		
		RestaurantWrapper rw3 = new RestaurantWrapper(new RestaurantNode(rest1));
		assertTrue(rw1.equals(rw3));
	}
}
