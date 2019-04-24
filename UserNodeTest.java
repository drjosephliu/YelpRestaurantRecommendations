import static org.junit.Assert.*;

import org.junit.Test;

public class UserNodeTest {

	@Test
	public void testIsUser() {
		UserNode u1 = new UserNode("user11","rest11",3.7);
		assertTrue(u1.isUser());
	}

	@Test
	public void testGetID() {
		UserNode u1 = new UserNode("user11","rest11",3.7);
		assertEquals(u1.getID(), "user11");
	}

	@Test
	public void testAddRating() {
		UserNode u1 = new UserNode("user11","rest11",3.7);
		u1.addRating("rest12", 4.5);
		assertEquals(u1.getSize(), 2);
	}


	@Test
	public void testGetSize() {
		UserNode u1 = new UserNode("user11","rest11",3.7);
		assertEquals(u1.getSize(), 1);
	}

}
