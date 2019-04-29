import java.util.*;

/**
 * 
 * @author TheSuperbGarfield
 *
 */
public class BST {

	BSTNode root;
	private int nodeCount;

	/**
	 * This is the constructor that takes in a BSTNode2 and sets it as the root
	 * 
	 * @param root
	 */
	public BST() {
		root = null;
		nodeCount = 0;
	}

	/**
	 * This returns the number of nodes in the BST.
	 * 
	 * @return nodeCount
	 */
	public int size() {
		return nodeCount;
	}
	
	/**
	 * This method creates a BSTNode2 from a RestaurantWrapper. If the
	 * RestaurantWrapper doesn't already exist in the BST, it gets inserted in the
	 * appropriate location. If it already exists, nothing is done.
	 * 
	 * @param key
	 */
	public void insert(RestaurantWrapper key) {
		root = insertHelper(root, key);
		nodeCount++;
	}

	/**
	 * This is a helper method that uses recursion to insert the RestaurantWrapper.
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	private BSTNode insertHelper(BSTNode root, RestaurantWrapper key) {
		if (root == null)
			return new BSTNode(key);
		if (root.getRestaurantWrapper().compareTo(key) >= 0)
			root.setLeft(insertHelper(root.getLeft(), key));
		else
			root.setRight(insertHelper(root.getRight(), key));
		return root;
	}

	/**
	 * This method removes a RestaurantWrapper and returns it. If it doesn't exist,
	 * return null.
	 * 
	 * @param key
	 * @return
	 */
	public RestaurantWrapper remove(RestaurantWrapper key) {
		RestaurantWrapper temp = findHelper(root, key);
		if (temp != null) {
			root = removeHelper(root, key);
			nodeCount--;
		}
		return temp;
	}

	/**
	 * This is a recursive helper method for removing a RestaurantWrapper
	 * from the BST.
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	private BSTNode removeHelper(BSTNode root, RestaurantWrapper key) {
		if (root == null)
			return null;
		if (root.getRestaurantWrapper().compareTo(key) < 0) {
			root.setRight(removeHelper(root.getRight(), key));
		} else if (root.getRestaurantWrapper().equals(key)) {
			if (root.getLeft() == null) {
				return root.getRight();
			}
			if (root.getRight() == null) {
				return root.getLeft();
			}
			BSTNode temp = getMax(root.getLeft());
			root.setRestaurant(temp.getRestaurantWrapper());
			root.setLeft(deleteMax(root.getLeft()));
		} else {
			root.setLeft(removeHelper(root.getLeft(), key));
		}
		return root;
	}

	/**
	 * This method finds and returns a query RestaurantWrapper. If it doesn't exist,
	 * return null.
	 * 
	 * @param key
	 * @return
	 */
	public RestaurantWrapper find(RestaurantWrapper key) {
		return findHelper(root, key);
	}

	/**
	 * This is a helper method that recursively finds a RestaurantWrapper.
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	private RestaurantWrapper findHelper(BSTNode root, RestaurantWrapper key) {
		if (root == null)
			return null;
		if (root.getRestaurantWrapper().compareTo(key) < 0) {
			return findHelper(root.getRight(), key);
		}
		if (root.getRestaurantWrapper().equals(key)) {
			return root.getRestaurantWrapper();
		}
		return findHelper(root.getLeft(), key);
	}

	/**
	 * Return a list of recommended restaurants equal or above a certain rating
	 * 
	 * @param threshold is threshold rating
	 * @return list of recommended restaurants that meet the threshold
	 */
	public List<RestaurantWrapper> findThreshold(double threshold) {
		List<RestaurantWrapper> ret = new ArrayList<>();
		inOrderTraversal(root, ret, threshold);
		return ret;
	}

	/**
	 * This method performs an in order traversal for nodes with average rating
	 * greater than or equal to the threshold. The list parameter is populated
	 * with the RestaurantWrappers encapsulated by each node.
	 * 
	 * @param root
	 * @param list
	 * @param threshold
	 */
	private void inOrderTraversal(BSTNode root, List<RestaurantWrapper> list, double threshold) {
		if (root == null) {
			return;
		}
		System.out.println("root: " + root.getRestaurantWrapper().getAvgRating() + ", threshold: " + threshold);	
		if (threshold <= root.getRestaurantWrapper().getAvgRating()) {
			inOrderTraversal(root.getLeft(), list, threshold);
			list.add(root.getRestaurantWrapper());
		}

		inOrderTraversal(root.getRight(), list, threshold);

	}

	/**
	 * This is a helper method that deletes the maximum element from the BST through
	 * recursion.
	 * 
	 * @param root
	 * @return
	 */
	private BSTNode deleteMax(BSTNode root) {
		if (root.getRight() == null)
			return root.getLeft();
		root.setRight(deleteMax(root.getRight()));
		return root;
	}

	/**
	 * This is a helper method that retrieves and returns the maximum element from
	 * the BST through recursion.
	 * 
	 * @param root
	 * @return
	 */
	private BSTNode getMax(BSTNode root) {
		if (root.getRight() == null)
			return root;
		return getMax(root.getRight());
	}

}
