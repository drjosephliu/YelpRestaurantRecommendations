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
	
	@Before
	public void setup() {
		graph = new Graph();
	}
	
	@Test
	public void testAddEdge() {
		graph.addEdge(user1, rest1, 3.1);
		graph.addEdge(user2, rest1, 3.7);
		graph.addEdge(user3, rest1, 4.1);
		graph.addEdge(user1, rest2, 1.5);
		graph.addEdge(user4, rest2, 1.5);
	}
	
	@Test
	public void testBfs() {
		
	}
}
