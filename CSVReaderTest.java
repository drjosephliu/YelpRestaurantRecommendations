import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class CSVReaderTest {

	@Test
	public void testReadCSV() {
		CSVReader reader = new CSVReader();
		try {
			reader.readCSV("fake_file.csv");
		} catch (Exception e) {
			assertTrue(e instanceof FileNotFoundException);
		}
		Graph g;
		try {
			reader.readCSV("yelp_subset_cleaned.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
