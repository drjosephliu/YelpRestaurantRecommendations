import java.util.HashMap;

public class UserNode implements INode {
	private String id;
	private HashMap<String, Double> ratings = new HashMap<String, Double>();
	private BST recommendationsBST = null;
	
    /** Constructor
     * @param id
     * @param restaurantID
     * @param rating*/
    public UserNode(String id, String restaurantID, Double rating){
        this.id = id;
        ratings.put(restaurantID, rating);
    }
    
    public UserNode(String id) {
    	this.id = id;
    }
    
	public boolean isUser() {
		return true;
	}
	
    /** @return The restaurant id*/
	public String getID() {
		return id;
	}
	
    /** add a new user review of a restaurant
     * @param restaurantID the user reviewed
     * @param rating */
	public void addRating(String restaurantID, Double rating) {
		ratings.put(restaurantID, rating);
	}
	
	/**@return number of reviews that the user wrote*/
	public int getSize() {
		return ratings.size();
	}
	
	/**
	 * Get user's rating for a restaurant they've reviewed
	 * @param restaurantId
	 * @return user's rating for restaurant
	 */
	public double getRating(String restaurantId) {
		if (!ratings.containsKey(restaurantId)) {
			throw new IllegalArgumentException("No rating for that restaurant"); 
		}
		return ratings.get(restaurantId);
	}
	
	/**
	 * Return all ratings by this user
	 * @return ratings by thisuser
	 */
	public HashMap<String, Double> getRatings() {
		return ratings;
	}
	
	/**
	 * Store recommendations BST in user's node
	 * @param recommendationsBST
	 */
	public void addRecommendationsBST(BST recommendationsBST) {
		this.recommendationsBST = recommendationsBST;
	}
	
	/**
	 * Get BST of all recommended restaurants for this user
	 * @return BST of all recommended restaurants
	 */
	public BST getRecommendationsBST() {
		return recommendationsBST;
	}

}
