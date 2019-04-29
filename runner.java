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
		Graph g = reader.readCSV(args[0]);
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
				g.getRecommendationsWithMinRating(userID, thredhold); 
				//TODO: printout list of restaurants
			}
			System.out.println("Would you like another try? Enter Y or N:");
			flag = sc.nextLine();
		}
		System.out.println("Thank you for using the recommendation System");
		
		//user "RQU7dwZTdCLfy7DQU2TYlQ" no rec found as he only reviews one rest and he is the only one who reviewed the rest 
		//user "4OrFB2TDRsbokoYMhUf1EA" reviewed rest VeiGa7h8p1I2yAIfgZjgtw
		
		
		

	}

}
