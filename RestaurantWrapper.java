import java.util.HashMap;

public class RestaurantWrapper implements Comparable<RestaurantWrapper> {
	
	private RestaurantNode restaurant;
	private HashMap<String, Double> ratingsByCoReviewers;
	private double avgRating;
	
	public RestaurantWrapper(RestaurantNode restaurant) {
		this.restaurant = restaurant;
		ratingsByCoReviewers = new HashMap<>();
		this.avgRating = getAvgRating();
	}
	
	/**
	 * Get restaurant's ID
	 * @return restaurant's ID
	 */
	public String getID() {
		return restaurant.getID();
	}
	
	public RestaurantNode getRestaurant() {
		return restaurant;
	}
	
	public HashMap<String, Double> getRatingsByCoReviewers() {
		return ratingsByCoReviewers;
	}
	
	/**
	 * Add co-reviewer's rating for this restaurant
	 * @param userId
	 * @param rating
	 */
	public void addRating(String userId, double rating) {
		ratingsByCoReviewers.put(userId, rating);
		avgRating = getAvgRating(); 
	}
	
	/**
	 * Return average rating by co-reviewers
	 * @return average rating by co-reviewers
	 */
	public double getAvgRating() {
		if (!ratingsByCoReviewers.isEmpty()) {
			double sumRatings = 0;
			for (Double ratings : ratingsByCoReviewers.values()) {
				sumRatings += ratings;
			}
			avgRating = sumRatings / ratingsByCoReviewers.size();
		}
		else {
			avgRating = 0.0;
		}
		return avgRating;
	}
	
	/**
	 * Compare restaurants by their average rating
	 */
	public int compareTo(RestaurantWrapper o) {
		if (avgRating < o.getAvgRating()) {
			return -1;
		}
		else if (avgRating > o.getAvgRating()) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * Check if two RestaurantWrapper objects are equal by their 
	 * restaurant ID
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (!(o instanceof RestaurantWrapper)) {
			return false;
		}
		
		RestaurantWrapper restaurant = (RestaurantWrapper) o;
		return this.restaurant.getID().equals(restaurant.getID());
	}
}
