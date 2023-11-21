import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {
    public static void main(String[] args)  {
        final String biolUrl = "https://cafebiola.cafebonappetit.com/cafe/cafe-biola/";
        Map<String, ArrayList<String>> lunchMap = new HashMap<>();
        Map<String, ArrayList<String>> dinnerMap = new HashMap<>();
        Map<String, ArrayList<String>> breakfastMap = new HashMap<>();


        try {
            final Document biolaSite = Jsoup.connect(biolUrl).get();

            //issue: this prints too much stuff
            //System.out.println(biolaSite.outerHtml());
            

            //System.out.println(biolaSite.select("h2.site-section__title").text());
            //System.out.println(biolaSite.select(".site-panel__daypart-item-title.h4").text()); 
            //System.out.println(biolaSite.title());
            //System.out.println(biolaSite.select("c-tab__button site-panel__daypart-tab-btn").tagName());

            //the name of each food served - problem: selects everything, including what's just suggested
            /* 
            Elements foodItems = biolaSite.getElementsByClass("h4 site-panel__daypart-item-title");
            for (Element item : foodItems) {
                //System.out.println(item.text());
            }

            
            Elements locations = biolaSite.getElementsByClass("c-tab__content site-panel__daypart-tab-content tab-content- c-tab__content--active");
            for (Element item : locations) {
                //System.out.println(item.attributes());
                
            }
            */

            
            //Lunch tab
            Element lunch = biolaSite.getElementById("tab-content-655c2b5f49b22");
            

            for (Element a: lunch.children()) {
                for (Element b: a.children()) {
                    ArrayList<String> tempList = new ArrayList<>();
                    for (Element c: b.children()) {
                        if (c.hasClass("site-panel__daypart-station-title")) {
                            System.out.print(c.text() + ": ");
                            lunchMap.put(c.text(), new ArrayList<>());
                             tempList = lunchMap.get(c.text());
                        }
                        else if (c.hasClass("site-panel__daypart-item")) {
                            System.out.println(c.text());
                            tempList.add(c.text());
                        }
                       
                    }
                    System.out.println("\n\n");
                }
            }


            //breakfast tab
            Element breakfast = biolaSite.getElementById("tab-content-655c32bececa6");
            

            for (Element a: breakfast.children()) {
                for (Element b: a.children()) {
                    ArrayList<String> tempList = new ArrayList<>();
                    for (Element c: b.children()) {
                        if (c.hasClass("site-panel__daypart-station-title")) {
                            System.out.print(c.text() + ": ");
                            breakfastMap.put(c.text(), new ArrayList<>());
                            tempList = breakfastMap.get(c.text());
                        }
                        else if (c.hasClass("site-panel__daypart-item")) {
                            System.out.println(c.text());
                            tempList.add(c.text());
                        }
                       
                    }
                    System.out.println("\n\n");
                }
            }


            System.out.println(breakfastMap);
            

           

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
