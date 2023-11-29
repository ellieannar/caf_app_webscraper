import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Day {

    //Meals to keep track of breakfast, lunch, and dinner
    Meal breakfast = new Meal();
    Meal lunch = new Meal();
    Meal dinner = new Meal();

    //Constructor
    Day() {
        super();
    }


    public Day connect(String date) {
        //Set up the url to access - use the dateString to specify
        final String biolaUrl = "https://cafebiola.cafebonappetit.com/cafe/cafe-biola/".concat(date);

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

           

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return today;
    }
    //Print function to display in log what's in the Meals 
    public void print() {
        System.out.println("Breakfast: ");
        for (int i = 0; i < breakfast.mealElements.size(); i++) {
            FoodItem f = breakfast.mealElements.get(i);
            System.out.println("\t" + f.title);
            System.out.println("\t\tLocated at " + f.location);
            System.out.println("\t\tWith the description: " + f.description);
            System.out.println("\t\tAnd the following restrictions");
            for (int j = 0; j < f.restrictions.size(); j++) {
                System.out.println("\t\t\t" + f.restrictions.get(j));
            }
        }
        System.out.println("Lunch: ");
        for (int i = 0; i < lunch.mealElements.size(); i++) {
            FoodItem f = lunch.mealElements.get(i);
            System.out.println("\t" + f.title);
            System.out.println("\t\tLocated at " + f.location);
            System.out.println("\t\tWith the description: " + f.description);
            System.out.println("\t\tAnd the following restrictions");
            for (int j = 0; j < f.restrictions.size(); j++) {
                System.out.println("\t\t\t" + f.restrictions.get(j));
            }
        }
        System.out.println("Dinner: ");
        for (int i = 0; i < lunch.mealElements.size(); i++) {
            FoodItem f = lunch.mealElements.get(i);
            System.out.println("\t" + f.title);
            System.out.println("\t\tLocated at " + f.location);
            System.out.println("\t\tWith the description: " + f.description);
            System.out.println("\t\tAnd the following restrictions");
            for (int j = 0; j < f.restrictions.size(); j++) {
                System.out.println("\t\t\t" + f.restrictions.get(j));
            }
        }
    }
    
}