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

    public void print(Day d) {
        System.out.println("Printing day");
    }
    
}