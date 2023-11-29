import java.util.ArrayList;


public class FoodItem {

    // Each food item stores the title, desc, restrictions, and location
    String location;
    ArrayList<String> restrictions = new ArrayList<String>(); 
    String title;
    String description;

    FoodItem () {
        super();
    }
}