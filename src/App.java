import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {

    public static void main(String[] args)  {


       
         String dateString = "2023-11-29/";
        // https://cafebiola.cafebonappetit.com/cafe/cafe-biola/2023-11-28/
        final String biolaUrl = "https://cafebiola.cafebonappetit.com/cafe/cafe-biola/".concat(dateString);


        try {
            final Document biolaSite = Jsoup.connect(biolaUrl).get();

            //this is the tab: System.out.println((item.parent().parent().parent().parent().parent().parent()));
            // this is the meal: System.out.println("\t" + item.parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().attributes());
            // this is the location: item.parent().parent().parent().parent().getElementsByTag("h3").text()
            // these are the dietary restrictions: Elements dietary = item.child(0).children();
            // this is the info about the item: System.out.println("\t" + item.parent().parent().child(1).text());
             
            Elements foodItems = biolaSite.getElementsByClass("h4 site-panel__daypart-item-title");
            //print JUST the elements that are served today

            Day today = new Day();
            //today.breakfast.mealElements.add(null);
            //System.out.println("BREAKFASTS");
            for (Element item : foodItems) {
                Element tab = item.parent().parent().parent().parent().parent().parent();
                Element meal = tab.parent().parent().parent().parent();
                //String location = item.parent().parent().parent().parent().getElementsByTag("h3").text();

                //Breakfasts
                if (tab.hasAttr("data-loop-index") && tab.attr("data-loop-index").equals("1") && meal.attr("data-daypart-id").equals("1")) {
                    FoodItem food = new FoodItem();
                    food.title = item.text();
                    // Dietary restrictions associated with food item
                    if (!item.children().isEmpty()) {
                        Elements dietary = item.child(0).children();
                    
                        for (Element restriction: dietary) {
                            food.restrictions.add(restriction.attr("title"));
                            //System.out.println(restriction.attr("title"));
                        }
                    }
                    food.description = item.parent().parent().child(1).text();
                    food.location = item.parent().parent().parent().parent().getElementsByTag("h3").text();
                    //System.out.println("\t" + item.parent().parent().child(1).text());
                    //System.out.println("\t" + location + ": " + item.text());
                    today.breakfast.mealElements.add(food);
                }
                 
                //Lunches
                else if (tab.hasAttr("data-loop-index") && tab.attr("data-loop-index").equals("1") && meal.attr("data-daypart-id").equals("3")) {
                    FoodItem food = new FoodItem();
                    food.title = item.text();
                    // Dietary restrictions associated with food item
                    if (!item.children().isEmpty()) {
                        Elements dietary = item.child(0).children();
                    
                        for (Element restriction: dietary) {
                            food.restrictions.add(restriction.attr("title"));
                            //System.out.println(restriction.attr("title"));
                        }
                    }
                    

                    food.description = item.parent().parent().child(1).text();
                    food.location = item.parent().parent().parent().parent().getElementsByTag("h3").text();
                    //System.out.println("\t" + item.parent().parent().child(1).text());
                    //System.out.println("\t" + location + ": " + item.text());
                    today.lunch.mealElements.add(food);
                }
                

                //Dinners
                if (tab.hasAttr("data-loop-index") && tab.attr("data-loop-index").equals("1") && meal.attr("data-daypart-id").equals("4")) {
                    FoodItem food = new FoodItem();
                    food.title = item.text();
                    // Dietary restrictions associated with food item
                    if (!item.children().isEmpty()) {
                        Elements dietary = item.child(0).children();
                    
                        for (Element restriction: dietary) {
                            food.restrictions.add(restriction.attr("title"));
                            //System.out.println(restriction.attr("title"));
                        }
                    }
                    food.description = item.parent().parent().child(1).text();
                    food.location = item.parent().parent().parent().parent().getElementsByTag("h3").text();
                    //System.out.println("\t" + item.parent().parent().child(1).text());
                    //System.out.println("\t" + location + ": " + item.text());
                    today.dinner.mealElements.add(food);
                }
                


    
            }

            Scanner scanner = new Scanner(System.in);
            boolean flag = true;
            while (flag == true) {
                System.out.print("Which meal do you want information about: ");
            
                String input = scanner.nextLine();
                if (input.equals("breakfast")) {
                    flag = false;
                } else if (input.equals("lunch")) {
                    flag = false;
                } else if (input.equals("dinner")) {
                    flag = false;
                } else {
                    System.out.println("There was an error with your entry. Try using all lowercase letters.");
                    System.out.println(input);
                }
                

            }
            

           scanner.close();
           

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        
    }

    

    
}
