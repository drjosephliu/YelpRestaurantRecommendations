import java.util.*;

/**
 * This class represents a graph of user and restaurant nodes.
 * @author Keenan Park
 * 
 */

public class Graph {
	
	private HashMap<INode, ArrayList<INode>> adjList;
	private HashSet<UserNode> userSet;
	private HashSet<RestaurantNode> restaurantSet; 
	
	/**
	 * Add an edge to the graph. An edge between UserNodes
	 * and RestaurantNodes if the user reviewed the restaurant.
	 * The parameter values are used to create the UserNode and
	 * the RestaurantNode. The HashSets are used to ensure that
	 * duplicate nodes are not added to the adjacency list.
	 * 
	 * @param userId
	 * @param restaurantId
	 * @param rating
	 */
	public void addEdge(String userId, String restaurantId, double rating) {
		// TODO
		// this is another change
	}
	
	/**
	 * A breadth first search populates the recommendationsBST
	 * instance variable in a given UserNode (identified by userId).
	 * The BST is populated with restaurants 3 hops away above the 
	 * parameter rating.
	 * If a UserNode with userId does not exist in the graph, then 
	 * return an empty ArrayList.
	 * 
	 * @param userId
	 * @return ArrayList of restaurants
	 */
	public void bfs(String userId, double rating) {
		// TODO
		// these are changes from joseph
	}

	
	public UserNode getUser(String userId) {
		if (userSet.contains(o))
	}
}
