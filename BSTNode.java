
public class BSTNode {
	
	private RestaurantWrapper restaurant;
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode() {
		this.restaurant = null;
		this.left = null;
		this.right = null;
	}
	
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
	
	/**
	 * Return RestaurantWrapper stored in this node
	 * @return restaurant
	 */
	public RestaurantWrapper getRestaurantWrapper() {
		return restaurant;
	}
	
	/**
	 * Get left child
	 * @return left child
	 */
	public BSTNode getLeft() {
		return left;
	}
	
	/**
	 * Get right child
	 * @return right child
	 */
	public BSTNode getRight() {
		return right;
	}
	
	/**
	 * Set new restaurant wrapper for this node
	 * @param newRestaurant
	 */
	public void setRestaurant(RestaurantWrapper newRestaurant) {
		this.restaurant = newRestaurant;
	}
	
	/**
	 * Set new left child
	 * @param newLeft
	 */
	public void setLeft(BSTNode newLeft) {
		this.left = newLeft;
	}
	
	/**
	 * Set new right child
	 * @param newRight
	 */
	public void setRight(BSTNode newRight) {
		this.right = newRight;
	}
	
}
