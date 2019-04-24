import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class CSVReaderTest {

	
	@Test
	public void testReadCSV() throws FileNotFoundException, IOException {
		try {
			CSVReader.readCSV("fake_file.csv");
		} catch (Exception e){
			assertTrue(e instanceof FileNotFoundException);
		}
		Graph g = CSVReader.readCSV("yelp_subset2.csv");
		
	}

}
