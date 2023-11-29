import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class FoodItem {
    String location;
    ArrayList<String> restrictions = new ArrayList<String>(); 
    String title;
    String description;
}