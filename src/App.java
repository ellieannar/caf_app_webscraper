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


        try {
            final Document biolaSite = Jsoup.connect(biolUrl).get();

            //issue: this prints too much stuff
            //System.out.println(biolaSite.outerHtml());
            

            //System.out.println(biolaSite.select("h2.site-section__title").text());
            //System.out.println(biolaSite.select(".site-panel__daypart-item-title.h4").text()); 
            //System.out.println(biolaSite.title());
            //System.out.println(biolaSite.select("c-tab__button site-panel__daypart-tab-btn").tagName());

            //the name of each food served - problme: selects everything, including what's just suggested
            Elements foodItems = biolaSite.getElementsByClass("h4 site-panel__daypart-item-title");
            for (Element item : foodItems) {
                //System.out.println(item.text());
            }

            
            Elements locations = biolaSite.getElementsByClass("c-tab__content site-panel__daypart-tab-content tab-content- c-tab__content--active");
            for (Element item : locations) {
                //System.out.println(item.attributes());
                
            }

            
            //Lunch tab
            Element lunch = biolaSite.getElementById("tab-content-655c2b5f49b22");
            

            for (Element a: lunch.children()) {
                for (Element b: a.children()) {
                    String tempLoc = "";
                    ArrayList<String> myList = new ArrayList<>();
                    for (Element c: b.children()) {
                        if (c.hasClass("site-panel__daypart-station-title")) {
                            System.out.print(c.text() + ": ");
                            tempLoc = c.text();
                            lunchMap.put(c.text(), new ArrayList<>());
                             myList = lunchMap.get(c.text());
                        }
                        else if (c.hasClass("site-panel__daypart-item")) {
                            System.out.println(c.text());
                            myList.add(c.text());
                        }
                       
                    }
                    System.out.println("\n\n");
                }
            }


            System.out.println(lunchMap);
            

           

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
