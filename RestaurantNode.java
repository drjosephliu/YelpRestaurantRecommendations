import java.util.HashMap;

public class RestaurantNode implements INode {
	private String id;
	private HashMap<String, Double> ratings = new HashMap<String, Double>();

    /** Constructor
     * @param id
     * @param userID
     * @param rating*/
    public RestaurantNode(String id, String userID, Double rating){
        this.id = id;
        ratings.put(userID, rating);
    }
    
	@Override
	public boolean isUser() {
		return true;
	}
	
    /** @return The restaurant id*/
	public String getID() {
		return id;
	}

	
    /** add a new review to the current restaurant
     * @param userID of the reviewer
     * @param rating */
	public void addRating(String userID, Double rating) {
		// TODO Auto-generated method stub
	}
//	
//    /** get average rating of current rating 
//     * @param userID of the input
//     * @return The element value */
//	public Double getAvgRating(String userID) {
//		// TODO Auto-generated method stub
//		return 0.0;
//	}
	
	/**@return number of reviews of restaurant*/
	public int getSize() {
		return ratings.size();
	}
}