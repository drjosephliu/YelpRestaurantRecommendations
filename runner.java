import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
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
		String option = "0";
		System.out.println("Welcome to Restaruant Recommendation System");		
		while (flag.equals("Y")) {
			System.out.println("Please enter the user ID: ");
			Scanner sc = new Scanner(System.in);
			String userID = sc.nextLine();
			System.out.println("Do you want to set threshold of minimal rating or minimal number of co-reviewers? ");
			System.out.println("1 for minimal rating, 2 for minimal number of co-reviewer");
			option = sc.nextLine();
			if (option.equals("1")) {
				System.out.println("Please set a threshold of the minimal rating: ");
				double threshold = Double.parseDouble(sc.nextLine());
				if (threshold > 5 || threshold < 0) {
					System.out.println("threshold must be between 0 to 5");
				}
				else {
					List<RestaurantWrapper> recs = g.getRecommendationsWithMinRating(userID, threshold);
					if(recs.size() == 0) {
						System.out.println("No recommendations found!");
					} else {
						int size = 5;
						if(recs.size() < 5) {
							size = recs.size();
						}
						for(int ii = 0; ii < size; ii ++) {
							RestaurantWrapper rw = recs.get(ii);
							System.out.println("recommendation: " + rw.getID() + ", avgRating: " + rw.getAvgRating() + ", corating: " + rw.getAvgRating());
						}
					}
					//TODO: printout list of restaurants
				}
			}
			else if (option.equals("2")) {
				System.out.println("Please enter the minimal number of co-reviewers: ");
				int threshold = Integer.parseInt(sc.nextLine());
				List<RestaurantWrapper> recs = g.getRecommendationsWithMinCoReviewers(userID, threshold);
				if(recs.size() == 0) {
					System.out.println("No recommendations found!");
				} else {
					int size = 5;
					if(recs.size() < 5) {
						size = recs.size();
					}
					for(int ii = 0; ii < size; ii ++) {
						RestaurantWrapper rw = recs.get(ii);
						System.out.println("recommendation: " + rw.getID() + ", avgRating: " + rw.getAvgRating() + ", corating: " + rw.getAvgRating());
					}
				}
			}
			System.out.println("Would you like another try? Enter Y or N:");
			flag = sc.nextLine();
		}
		System.out.println("Thank you for using the recommendation System");
		
		//user "RQU7dwZTdCLfy7DQU2TYlQ" no rec found as he only reviews one rest and he is the only one who reviewed the rest 
		//user "4OrFB2TDRsbokoYMhUf1EA" reviewed rest VeiGa7h8p1I2yAIfgZjgtw
		}
}
