import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class CSVReaderTest {

	
	@Test
	public void testReadCSV(){
		try {
			CSVReader.readCSV("fake_file.csv");
		} catch (Exception e){
			assertTrue(e instanceof FileNotFoundException);
		}
		Graph g;
		try{
			CSVReader.readCSV("yelp_subset_cleaned.csv");
		} catch(Exception e) {
			
		}
		
	}

}
