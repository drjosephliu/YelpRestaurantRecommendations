import java.util.HashMap;

/**
 * This class represents a restaurant record. Instances of this class are used
 * to create BST nodes.
 * 
 * @author Joseph Liu
 *
 */
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
	 * 
	 * @return restaurant's ID
	 */
	public String getID() {
		return restaurant.getID();
	}

	/**
	 * Gets the RestaurantNode associated with this RestaurantWrapper
	 * 
	 * @return RestaurantNode
	 */
	public RestaurantNode getRestaurant() {
		return restaurant;
	}

	/**
	 * Returns the ratings by co-reviewers.
	 * 
	 * @return HashMap<String, Double>
	 */
	public HashMap<String, Double> getRatingsByCoReviewers() {
		return ratingsByCoReviewers;
	}

	/**
	 * Add co-reviewer's rating for this restaurant
	 * 
	 * @param userId
	 * @param rating
	 */
	public void addRating(String userId, double rating) {
		ratingsByCoReviewers.put(userId, rating);
		avgRating = getAvgRating();
	}

	/**
	 * Returns average rating by co-reviewers
	 * 
	 * @return double
	 */
	public double getAvgRating() {
		if (!ratingsByCoReviewers.isEmpty()) {
			double sumRatings = 0;
			for (Double ratings : ratingsByCoReviewers.values()) {
				sumRatings += ratings;
			}
			avgRating = sumRatings / ratingsByCoReviewers.size();
		} else {
			avgRating = 0.0;
		}
		return avgRating;
	}

	/**
	 * Compare restaurants by their average rating
	 * 
	 * @return int
	 */
	public int compareTo(RestaurantWrapper o) {
		if (avgRating < o.getAvgRating()) {
			return -1;
		} else if (avgRating > o.getAvgRating()) {
			return 1;
		}
		return 0;
	}

	/**
	 * Check if two RestaurantWrapper objects are equal by their restaurant ID
	 * 
	 * @return boolean value
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
