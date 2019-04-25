
public class RestaurantWrapper {
	
	private RestaurantNode restaurant;
	private double avgRating;
	
	public RestaurantWrapper() {
		restaurant = null;
		avgRating = 0;
	}
	
	public RestaurantWrapper(RestaurantNode restaurant) {
		this.restaurant = restaurant;
		this.avgRating = 0;
	}
	
	public String getID() {
		return restaurant.getID();
	}
	
	public int getSize() {
		return restaurant.getSize();
	}
}
