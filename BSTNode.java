
public class BSTNode {
	
	private RestaurantWrapper restaurant;
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode(RestaurantWrapper restaurant) {
		this.restaurant = restaurant;
		this.left = null;
		this.right = null;
	}
	
	public BSTNode(RestaurantWrapper restaurant, BSTNode left, BSTNode right) {
		this.restaurant = restaurant;
		this.left = left;
		this.right = right;
	}
	
	public RestaurantWrapper getRestaurant() {
		return restaurant;
	}
	
	public BSTNode getLeft() {
		return left;
	}
	
	public BSTNode getRight() {
		return right;
	}
	
	public void setRestaurant(RestaurantWrapper newRestaurant) {
		this.restaurant = newRestaurant;
	}
	
	public void setLeft(BSTNode newLeft) {
		this.left = newLeft;
	}
	
	public void setRight(BSTNode newRight) {
		this.right = newRight;
	}
	
}
