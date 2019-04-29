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
	public Graph readCSV(String filename) throws FileNotFoundException, IOException {
		Graph g = new Graph();
		br = new BufferedReader(new FileReader(filename));
		br.readLine(); // throw away header
		String line = "";
		String tokens[];
		String del = ",";
		while((line = br.readLine()) != null){
			tokens = line.split(del); // first token is index (thrown away)
			String userId = tokens[1].substring(1,tokens[1].length()-1); // second token is user_id
			String restaurantId = tokens[2].substring(1,tokens[2].length()-1); // third token is restaurant_id
			String ratingStr = tokens[3]; // fourth token is rating
			int rating = Integer.parseInt(ratingStr);
			g.addEdge(userId, restaurantId, rating);
		}
        return g;
    }
}
