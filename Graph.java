import java.util.*;

/**
 * This class represents a graph of user and restaurant nodes.
 * @author Keenan Park
 * 
 */

public class Graph {
	
	private HashMap<INode, ArrayList<INode>> adjList;
	private HashMap<String, UserNode> users;
	private HashMap<String, RestaurantNode> restaurants; 
	
	public Graph() {
		adjList = new HashMap<>();
		users = new HashMap<>();
		restaurants = new HashMap<>();
	}
	
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
		
		UserNode userNode;
		
		if (!users.containsKey(userId)) {
			userNode = new UserNode(userId, restaurantId, rating);
		}
		else {
			userNode = users.get(userId);
		}
		
		RestaurantNode restaurantNode;
		
		if (!restaurants.containsKey(restaurantId)) {
			restaurantNode = new RestaurantNode(restaurantId, userId, rating);
		}
		else {
			restaurantNode = restaurants.get(restaurantId);
		}
		
		userNode.addRating(restaurantId, rating);
		restaurantNode.addRating(userId, rating);
		
		users.put(userNode.getID(), userNode);
		restaurants.put(restaurantNode.getID(), restaurantNode);
		
		addNodeToAdjList((INode) userNode, (INode) restaurantNode);
		addNodeToAdjList((INode) restaurantNode, (INode) userNode);
	}
	
	private void addNodeToAdjList(INode node1, INode node2) {
		ArrayList<INode> node1Neighbours;
		if (!adjList.containsKey(node1)) {
			node1Neighbours = new ArrayList<>();
		}
		else {
			node1Neighbours = adjList.get(node1);
		}
		node1Neighbours.add(node2);
		adjList.put(node1, node1Neighbours);
	}
	
	/**
	 * Find recommendations for a user that meet a minimum rating threshold
	 * @param userID 
	 * @param rating
	 * @return list of restaurants that are greater than or equal to rating
	 */
	public List<RestaurantWrapper> getRecommendationsWithMinRating(String userID, double rating) {
		UserNode user = getUser(userID); 
		BST recommendations;
		
		if (user.getRecommendationsBST() == null) { 
			recommendations = bfs(userID);
		}
		else {
			recommendations = user.getRecommendationsBST();
		}
		
		return recommendations.findThreshold(rating);
	}
	
	public List<RestaurantWrapper> getRecommendationsWithMinCoReviewers(String userID, int numCoReviewers) {
		UserNode user = getUser(userID);
		BST recommendations;
		
		if (user.getRecommendationsBST() == null) {
			recommendations = bfs(userID);
		}
		else {
			recommendations = user.getRecommendationsBST();
		}
		
		List<RestaurantWrapper> recommendationsList = findRecommendationsMinCoReviewerHelper(recommendations.root, numCoReviewers);
		return recommendationsList;
	}
	
	private List<RestaurantWrapper> findRecommendationsMinCoReviewerHelper(BSTNode root, int numCoReviewers) {
		if (root == null) {
			return new ArrayList<RestaurantWrapper>();
		}
		List<RestaurantWrapper> recommendations = new ArrayList<>();
		
		if (root.getRestaurantWrapper().getRatingsByCoReviewers().size() >= numCoReviewers) {
			recommendations.add(root.getRestaurantWrapper());
		}
		recommendations.addAll(findRecommendationsMinCoReviewerHelper(root.getLeft(), numCoReviewers));
		recommendations.addAll(findRecommendationsMinCoReviewerHelper(root.getRight(), numCoReviewers));
		
		return recommendations;
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
	private BST bfs(String userId) {
		
		UserNode userNode = getUser(userId);
		
		Queue<INode> queue = new LinkedList<>();
		Set<INode> visitedNodes = new HashSet<>();
		HashMap<String, RestaurantWrapper> recommendations = new HashMap<>();
		
		queue.add(userNode);
		
		int hops = 0;
		
		// 1 hop = restaurants you've reviewed; 
		// 2 hops = co-reviewers
		// 3 hops = recommended restaurants
		while (hops < 3) {
			Queue<INode> queue2 = new LinkedList<>();
			
			while (!queue.isEmpty()) {
				INode nextNode = queue.poll();
				visitedNodes.add(nextNode);
			
				ArrayList<INode> neighbours = adjList.get(nextNode);
				
				// Hops == 2 are the co-reviewers
				if (hops == 2 && nextNode.isUser()) {
					
					UserNode coReviewer = (UserNode) nextNode;
					
					// These are the recommendations
					for (INode node : neighbours) {
						if (!visitedNodes.contains(node)) {
							RestaurantNode restaurant = (RestaurantNode) node;	
							
							
							RestaurantWrapper rw;
							if (!recommendations.containsKey(restaurant.getID())) {
								rw = new RestaurantWrapper(restaurant);
							}
							else {
								rw = recommendations.get(restaurant.getID());
							}
							
							// Store each co-reviewers rating of the recommendeded restaurant
							rw.addRating(coReviewer.getID(), coReviewer.getRating(restaurant.getID()));
							recommendations.put(restaurant.getID(), rw);
						}
					}
				}
				
				for (INode neighbour : neighbours) {
					if (!visitedNodes.contains(neighbour)) {
						queue2.add(neighbour);
					}
				}
			}
			
			queue.addAll(queue2);
			hops++;
		}
		
		if (recommendations.isEmpty()) {
			System.out.println("Sorry no recommendations found");
		}
		
		// Create BST
		BST recommendationsBST = new BST();
		for (RestaurantWrapper recommendation : recommendations.values()) {
			recommendationsBST.insert(recommendation);
		}
		// Store recommendations in user's node
		userNode.addRecommendationsBST(recommendationsBST);
		
		return recommendationsBST;
	} 

	/**
	 * Returns user node with corresponding id
	 * @param userId
	 * @return UserNode with userId
	 */
	public UserNode getUser(String userId) {
		if (!users.containsKey(userId)) {
			throw new IllegalArgumentException("User not found");
		}
		return users.get(userId);
	}
	
	public HashMap<String, UserNode> getUsers() {
		return users; 
	}
	
	public RestaurantNode getRestaurant(String restaurantId) {
		if(!restaurants.containsKey(restaurantId)) {
			throw new IllegalArgumentException("Restaurant not found");
		}
		return restaurants.get(restaurantId);
	}
	
	public HashMap<String, RestaurantNode> getRestaurants() {
		return restaurants;
	}
	
	public HashMap<INode, ArrayList<INode>> getAdjList() {
		return adjList;
	}
}
