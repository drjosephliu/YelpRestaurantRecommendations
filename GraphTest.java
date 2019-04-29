import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	
	private Graph graph;
	private final String user1 = "Rongrong";
	private final String user2 = "Keenan";
	private final String user3 = "Topher";
	private final String user4 = "Dr Joe";
	private final String rest1 = "Pret A Manger";
	private final String rest2 = "Sweetgreens";
	private final String rest3 = "Honeygrow";
	private final String rest4 = "Shakeshack";
	private final String rest5 = "McDonald's";
	private final String rest6 = "Blaze Pizza";
	private final String rest7 = "Terakawa";
	private final String rest8 = "Pho Street";
	private final String rest9 = "Baby Blues BBQ";
	private final String rest10 = "White Dog";
	
	@Before
	public void setup() {
		graph = new Graph();
		graph.addEdge(user1, rest1, 1.1);
		graph.addEdge(user1, rest2, 1.2);
		graph.addEdge(user1, rest3, 1.3);
		graph.addEdge(user1, rest4, 1.4);
		
		graph.addEdge(user2, rest2, 2.2);		
		graph.addEdge(user3, rest3, 3.3);
		graph.addEdge(user4, rest4, 4.4);
	}
	
	@Test
	public void testAddEdge() {

		UserNode user1Node = graph.getUser(user1);	
		assertEquals(1.1, user1Node.getRating(rest1), 0.001);
		
		RestaurantNode rest1Node = graph.getRestaurant(rest1);
		assertEquals(1.1, rest1Node.getRating(user1), 0.001);
	}
	
	@Test
	public void testGetUsers() {
		assertEquals(user1, graph.getUsers().get(user1).getID());
	}
	
	@Test
	public void testGetUser() {
		assertEquals(user1, graph.getUser(user1).getID());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetUserThrowsException() {
		graph.getUser("user does not exist");
	}
	
	@Test
	public void testGetRestaurants() {
		assertEquals(rest1, graph.getRestaurants().get(rest1).getID());
	}
	
	@Test
	public void testGetRestaurant() {
		assertEquals(rest1, graph.getRestaurant(rest1).getID());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetRestaurantThrowsException() {
		graph.getRestaurant("restaurant does not exist");
	}
	
	@Test
	public void testGetAdjList() {
		assertEquals(8, graph.getAdjList().size());
	}
	
	@Test
	public void testGetRecommendationsWithMinRating() {
		final String user5 = "5th user";
		graph.addEdge(user5, rest5, 4.0);
		assertEquals(0, graph.getRecommendationsWithMinRating(user5, 3.0).size());
		graph.addEdge(user2, rest5, 2.5);
		graph.addEdge(user3, rest6, 3.6);
		
		assertEquals(1, graph.getRecommendationsWithMinRating(user1, 3.0).size());
		assertEquals(2, graph.getRecommendationsWithMinRating(user1, 2.0).size());
		assertEquals(2, graph.getRecommendationsWithMinRating(user1, 2.0).size());
	}
	
	@Test
	public void testGetRecommendationsWithMinCoReviewers() {
		graph.addEdge(user2, rest5, 2.5);
		graph.addEdge(user2, rest6, 4.8);
		graph.addEdge(user2, rest7, 3.9);
		graph.addEdge(user2, rest8, 4.7);
		graph.addEdge(user2, rest9, 5.0);
		graph.addEdge(user2, rest10, 3.3);
		
		graph.addEdge(user3, rest6, 3.6);
		graph.addEdge(user3, rest7, 3.3);
		graph.addEdge(user3, rest8, 3.9);
		graph.addEdge(user3, rest9, 4.1);
		graph.addEdge(user3, rest10, 4.4);
		
		graph.addEdge(user4, rest5, 2.1);
		graph.addEdge(user4, rest6, 3.5);
		graph.addEdge(user4, rest7, 2.9);
		graph.addEdge(user4, rest8, 3.9);
		graph.addEdge(user4, rest9, 4.4);
		graph.addEdge(user4, rest10, 4.6);
		
		assertEquals(5, graph.getRecommendationsWithMinCoReviewers(user1, 3).size());
		assertEquals(5, graph.getRecommendationsWithMinCoReviewers(user1, 3).size());
		
		
	}
}
