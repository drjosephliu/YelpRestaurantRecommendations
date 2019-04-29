import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class runner {

/**
 * This is the main funtion .
 * @author Rongrong Liu
 * @throws IOException 
 * @throws FileNotFoundException 
 * 
 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		CSVReader reader = new CSVReader();
		//Graph g = reader.readCSV(args[0]);
		String flag = "Y";
		System.out.println("Welcome to Restaruant Recommendation System");		
		while (flag.equals("Y")) {
			System.out.println("Please enter the user ID: ");
			Scanner sc = new Scanner(System.in);
			String userID = sc.nextLine();
			
			System.out.println("Please set a thredhold of the minimal rating: ");
			double thredhold = Double.parseDouble(sc.nextLine());
			if (thredhold > 5 || thredhold < 0) {
				System.out.println("thredhold must be between 0 to 5");
			}
			else {
				//g.getRecommendationsWithMinRating(userID, thredhold); 
				System.out.println("The restaurant recommended to" + userID +" is");
				//TODO: printout list of restaurants
			}
			System.out.println("Would you like another try? Enter Y or N:");
			flag = sc.nextLine();
		}
		System.out.println("Thank you for using the recommendation System");
		
		//the user had two reviews, both with 4 star
		//restaurant "IMnTtFn3c5qZ7gW0gWqPzA", "omCROJcbZC1qqdQw47LRQA"
		//11 people reviewed the first rest, 9 people reviewed the second rest 
		
		
		

	}

}
