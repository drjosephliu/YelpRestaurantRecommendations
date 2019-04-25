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
    
	public boolean isUser() {
		return false;
	}
	
    /** @return The restaurant id*/
	public String getID() {
		return id;
	}
	
    /** add a new user review of a restaurant
     * @param restaurantID the user reviewed
     * @param rating */
	public void addRating(String restaurantID, Double rating) {
		// TODO Auto-generated method stub
	}
	
	/**@return number of reviews that the user wrote*/
	public int getSize() {
		return ratings.size();
	}
}