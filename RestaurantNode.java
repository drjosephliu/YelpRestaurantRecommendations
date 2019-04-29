import java.util.HashMap;

public class RestaurantNode implements INode {
	private String id;
	private HashMap<String, Double> ratings = new HashMap<String, Double>();
	private double avgRating;
    /** Constructor
     * @param id
     * @param userID
     * @param rating*/
    public RestaurantNode(String id, String userID, Double rating){
        this.id = id;
        ratings.put(userID, rating);
        this.avgRating = getAvgRating();
    }
    
    public RestaurantNode(String id) {
    	this.id = id;
    	this.avgRating = getAvgRating();
    }
    
	public boolean isUser() {
		return false;
	}
	
    /** @return The restaurant id*/
	public String getID() {
		return id;
	}

	
    /** add a new review to the current restaurant
     * @param userID of the reviewer
     * @param rating */
	public void addRating(String userID, Double rating) {
		ratings.put(userID, rating);
	}
	
	/**
	 * Get average rating for restaurant
	 * @return average rating for restaurant
	 */
	public double getAvgRating() {
		if (!ratings.isEmpty()) {
			double sumRatings = 0;
			for (Double ratings : ratings.values()) {
				sumRatings += ratings;
			}
			avgRating = sumRatings / ratings.size();
		}
		else {
			avgRating = 0.0;
		}
		return avgRating;
	}
	
	public double getRating(String userID) {
		if (!ratings.containsKey(userID)) {
			throw new IllegalArgumentException("User didn't review this restaurant");
		}
		return ratings.get(userID);
	}
	
	/**@return number of reviews of restaurant*/
	public int getSize() {
		return ratings.size();
	}

}