import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Day {
    Meal breakfast = new Meal();
    Meal lunch = new Meal();
    Meal dinner = new Meal();
    Day() {
        super();
    }

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