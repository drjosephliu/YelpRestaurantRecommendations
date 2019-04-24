
public class RestaurantWrapper {
	
	private RestaurantNode restaurant;
	private double avgRating;
	
	public RestaurantWrapper(RestaurantNode restaurant) {
		this.restaurant = restaurant;
	}
	
	public String getID() {
		return restaurant.getID();
	}
	
	public int getSize() {
		return restaurant.getSize();
	}
}
