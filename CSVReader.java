//owner: Chris
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author TheSuperbGarfield
 *
 */
public class CSVReader {
	
  List<Graph> reviews;
  static BufferedReader br;

	public CSVReader() {
		reviews = new ArrayList<Graph>();
	}
	
	/**
	 * This method reads in a csv file, parses it, and returns a Graph object that encapsulates all user and restaurant nodes
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Graph readCSV(String filename) throws FileNotFoundException, IOException {
		// TODO: Auto-generated method stub
        return null;
    }
}
