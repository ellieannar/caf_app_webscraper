import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/*
* This is the information regarding how to locate certain parts of data through the site
* this is the tab: System.out.println((item.parent().parent().parent().parent().parent().parent()));
* this is the meal: System.out.println("\t" + item.parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().attributes());
* this is the location: item.parent().parent().parent().parent().getElementsByTag("h3").text()
* these are the dietary restrictions: Elements dietary = item.child(0).children();
* this is the info about the item: System.out.println("\t" + item.parent().parent().child(1).text());
*/

public class App {

    public static void main(String[] args)  {

        // Get the date from the user
        Scanner scanner = new Scanner(System.in);
        String dateString = "";
        
        System.out.print("Enter the date in the following format yyyy-mm-dd: ");
    
        dateString = scanner.nextLine();
        dateString.concat("/");

        scanner.close();

        //Set up the url to access - use the dateString to specify
        final String biolaUrl = "https://cafebiola.cafebonappetit.com/cafe/cafe-biola/".concat(dateString);

        //Day to hold current day
        Day today = new Day();

        // Attempt to pull the data
        try {

            //get the site information
            final Document biolaSite = Jsoup.connect(biolaUrl).get();

            //All the food items for the given day
            Elements foodItems = biolaSite.getElementsByClass("h4 site-panel__daypart-item-title");
            

            
            for (Element item : foodItems) {
                //the tab, which needs to be 1
                Element tab = item.parent().parent().parent().parent().parent().parent();


                if (tab.hasAttr("data-loop-index") && tab.attr("data-loop-index").equals("1")) {
                    //the meal (1 = breakfast, 3 = lunch, 4 = dinner)
                    Element meal = tab.parent().parent().parent().parent();

                    //Breakfasts
                    if (meal.attr("data-daypart-id").equals("1")) {
                        //Temporary food item to keep track of the details
                        FoodItem food = new FoodItem();

                        food.title = item.text();

                        // Dietary restrictions associated with food item
                        if (!item.children().isEmpty()) {
                            Elements dietary = item.child(0).children();
                            for (Element restriction: dietary) {
                                food.addRestriction(restriction.attr("title"));
                            }
                        }

                        food.description = item.parent().parent().child(1).text();
                        food.location = item.parent().parent().parent().parent().getElementsByTag("h3").text();

                        //add food to breakfast items for today
                        today.breakfast.mealElements.add(food);
                    }
                    
                    //Lunches
                    else if (meal.attr("data-daypart-id").equals("3")) {
                        //Temporary food item to keep track of the details
                        FoodItem food = new FoodItem();
                        food.title = item.text();

                        //Dietary restrictions associated with food item
                        if (!item.children().isEmpty()) {
                            Elements dietary = item.child(0).children();
                        
                            for (Element restriction: dietary) {
                                food.addRestriction(restriction.attr("title"));
                            }
                        }
                        
                        food.description = item.parent().parent().child(1).text();
                        food.location = item.parent().parent().parent().parent().getElementsByTag("h3").text();

                        // add food to lunch items for today
                        today.lunch.mealElements.add(food);
                    }
                    

                    //Dinners
                    else if (meal.attr("data-daypart-id").equals("4")) {
                        //Temporary food item to keep track of the details
                        FoodItem food = new FoodItem();
                        food.title = item.text();

                        // Dietary restrictions associated with food item
                        if (!item.children().isEmpty()) {
                            Elements dietary = item.child(0).children();
                            for (Element restriction: dietary) {
                                food.addRestriction(restriction.attr("title"));
                            }
                        }

                        food.description = item.parent().parent().child(1).text();
                        food.location = item.parent().parent().parent().parent().getElementsByTag("h3").text();

                        // add food to lunch items for today
                        today.dinner.mealElements.add(food);
                    }

                }

            }

            // Display to log what day looks like
            today.print();
           

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        
    }

    

    
}
