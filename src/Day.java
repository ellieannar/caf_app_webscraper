public class Day {

    //Meals to keep track of breakfast, lunch, and dinner
    Meal breakfast = new Meal();
    Meal lunch = new Meal();
    Meal dinner = new Meal();

    //Constructor
    Day() {
        super();
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