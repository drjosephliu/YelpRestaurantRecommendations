import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class Runner {

	/**
	 * This class contains the main method. See the readme for a detailed
	 * explanation of how to use this program.
	 * 
	 * Credit to http://patorjk.com/ and https://www.asciiart.eu/ for the ascii art.
	 * 
	 * @author Keenan Park and Rongrong Liu
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */

	public static void main(String[] args) throws FileNotFoundException, IOException {
		CSVReader reader = new CSVReader();
		Graph g = reader.readCSV(args[0]);
		String flag = "Y";
		String option = "0";
		int recListSize = 10; // modify this var to get more than 10 recommendations
		DecimalFormat df = new DecimalFormat("0.00");
		Scanner in = new Scanner(System.in);

		System.out.println(
				"===============================================================================================");
		System.out.println("\r\n"
				+ " __        __   _                            _         __   __   _         _     _ _       _ \r\n"
				+ " \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___   \\ \\ / /__| |_ __   | |   (_) |_ ___| |\r\n"
				+ "  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\   \\ V / _ \\ | '_ \\  | |   | | __/ _ \\ |\r\n"
				+ "   \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) |   | |  __/ | |_) | | |___| | ||  __/_|\r\n"
				+ "    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/    |_|\\___|_| .__/  |_____|_|\\__\\___(_)\r\n"
				+ "                                                                  |_|                        \r\n"
				+ "");
		System.out.println(
				"===============================================================================================");
		while (flag.equals("Y")) {
			String userID;
			while (true) {
				System.out.print("Please enter your user ID: ");
				userID = in.nextLine();
				try {
					g.getUser(userID);
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("User not found. Please try again.");
				}
			}

			System.out.println("\n------------------------------------------------------------");
			System.out.println("                           Menu");
			System.out.println("------------------------------------------------------------");
			System.out.println("(1) Restaurant recommendations above a particular rating");
			System.out.println("(2) Restaurant recommendations with at least x co-reviewers");
			System.out.print("Enter your selection here: ");
			option = in.nextLine();

			while (!(option.equals("1") || option.equals("2"))) {
				System.out.print("Please enter either 1 or 2: ");
				option = in.nextLine();
			}
			if (option.equals("1")) {

				// get minimum rating from console
				double threshold;
				while (true) {
					System.out.print("Please enter a minimum rating: ");
					String strInput = in.nextLine();
					try {
						threshold = Double.parseDouble(strInput);
						if (threshold > 5 || threshold < 0) {
							System.out.println("Minimum rating must be between 0 and 5 inclusive.");
						} else {
							break;
						}
					} catch (Exception e) {
						System.out.println("Minimum rating must be a floating point value.");
					}
				}

				List<RestaurantWrapper> recs = g.getRecommendationsWithMinRating(userID, threshold);
				if (recs.size() == 0) {
					System.out.println("No recommendations found!");
				} else {
					if (recs.size() < 5) {
						recListSize = recs.size();
					}
					System.out.println("\n------------------------------------------------------------");
					System.out.println("                    Recommendations:");
					System.out.println("------------------------------------------------------------");
					for (int ii = 0; ii < recListSize; ii++) {
						RestaurantWrapper rw = recs.get(ii);
						System.out.println(String.format("%2d", ii + 1) + ". " + "Restaurant ID: " + rw.getID()
								+ ", Co-Reviewer Rating: " + df.format(rw.getAvgRating()) + ", Overall Rating: "
								+ df.format(rw.getRestaurant().getAvgRating()));
					}
				}
			} else {

				int threshold;
				while (true) {
					System.out.print("Please enter the minimum number of co-reviewers: ");
					String strInput = in.nextLine();
					try {
						threshold = Integer.parseInt(strInput);
						if (threshold < 0) {
							System.out.println("Minimum co-reviewers must be greater than 0.");
						} else {
							break;
						}
					} catch (Exception e) {
						System.out.println("Minimum co-reviewers must be an integer.");
					}
				}
				List<RestaurantWrapper> recs = g.getRecommendationsWithMinCoReviewers(userID, threshold);
				if (recs.size() == 0) {
					System.out.println("No recommendations found!");
				} else {
					if (recs.size() < 10) {
						recListSize = recs.size();
					}
					System.out.println("\n------------------------------------------------------------");
					System.out.println("                    Recommendations");
					System.out.println("------------------------------------------------------------");
					for (int ii = 0; ii < recListSize; ii++) {
						RestaurantWrapper rw = recs.get(ii);
						System.out.println(String.format("%2d", ii + 1) + ". " + "Restaurant ID: " + rw.getID()
								+ ", Co-Reviewer Rating: " + df.format(rw.getAvgRating()) + ", Overall Rating: "
								+ df.format(rw.getRestaurant().getAvgRating()));
					}
				}
			}
			System.out.println("\nWould you like to make another query?");
			System.out.print("Press Y to do so, or press any other key to quit: ");
			flag = in.nextLine().toUpperCase();
		}
		System.out.println("\n------------------------------------------------------------");
		System.out.println("            Thank you for using Yelp Lite!");
		System.out.println("------------------------------------------------------------");
		System.out.println("                   o           o \r\n" + "                      o   o    \r\n"
				+ "                         o         o\r\n" + "\r\n" + "                     o       o  o \r\n"
				+ "                  ________._____________\r\n" + "                  |   .                |\r\n"
				+ "                  |^^^.^^^^^.^^^^^^.^^^|\r\n" + "                  |     .   .   .      |\r\n"
				+ "                   \\      . . . .     /\r\n" + "C H E E R S !!!      \\     .  .     / \r\n"
				+ "                       \\    ..    / \r\n" + "                         \\      /\r\n"
				+ "                           \\  /\r\n" + "                            \\/\r\n"
				+ "                            ||\r\n" + "                            ||\r\n"
				+ "                            ||\r\n" + "                            ||\r\n"
				+ "                            ||\r\n" + "                            /\\\r\n"
				+ "                           /;;\\\r\n" + "                      ==============");

		// EXAMPLE USERS
		// User "RQU7dwZTdCLfy7DQU2TYlQ": no recommendations found, as he only
		// reviewed one restaurant, and he is the only one who reviewed that restaurant.
		// User "4OrFB2TDRsbokoYMhUf1EA": reviewed restaurant VeiGa7h8p1I2yAIfgZjgtw
	}
}
