import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class App {
    public static void main(String[] args)  {


        /*

         On the 27th:
            - the 27th lunch @ 1:13pm: 
            - the 28th lunch @ 1:11pm: 656505277da7f
            - the 29th lunch @ 1:11pm: 6565057634be1
            - the 30th lunch @ 1:12pm: 6565060853c07
         

            - the 27th lunch @ 7:51pm: 65655f6d42b6a
            - the 28th lunch @ 7:53pm: 656563c8c2100
            - the 29th lunch @ 7:53pm: 656563f70ed79
            - the 30th lunch @ 7:51pm: 6565641c5d70c


        On the 28th:
            - the 27th lunch @ 10:48am: 6566347fbb9c3
            - the 28th lunch @ 10:48am: 65663086a5cf2
            - the 29th lunch @ 10:48am: 6566341266f20
            - the 30th lunch @ 10:48am: 656635c6b8f6e

            - the 27th lunch @ 3:15pm: 65667431b79b6
            - the 28th lunch @ 3:15pm: 65667406dcf54
            - the 29th lunch @ 3:15pm: 656672395e9b5
            - the 30th lunch @ 3:15pm: 6566740223769

        
         
         */

        // for each day???
        // https://cafebiola.cafebonappetit.com/cafe/cafe-biola/2023-11-28/
        final String biolUrl = "https://cafebiola.cafebonappetit.com/cafe/cafe-biola/2023-11-29/";
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
            Element lunch = biolaSite.getElementById("tab-content-656505277da7f");
            

            for (Element a: lunch.children()) {
                for (Element b: a.children()) {
                    ArrayList<String> tempList = new ArrayList<>();
                    for (Element c: b.children()) {
                        if (c.hasClass("site-panel__daypart-station-title")) {
                            lunchMap.put(c.text(), new ArrayList<>());
                            tempList = lunchMap.get(c.text());
                        }
                        else if (c.hasClass("site-panel__daypart-item")) {
                            tempList.add(c.text());
                        }
                       
                    }
                }
            }


            //breakfast tab
            Element breakfast = biolaSite.getElementById("tab-content-6564fd399fbbe");
            

            for (Element a: breakfast.children()) {
                for (Element b: a.children()) {
                    ArrayList<String> tempList = new ArrayList<>();
                    for (Element c: b.children()) {
                        if (c.hasClass("site-panel__daypart-station-title")) {
                            breakfastMap.put(c.text(), new ArrayList<>());
                            tempList = breakfastMap.get(c.text());
                        }
                        else if (c.hasClass("site-panel__daypart-item")) {
                            tempList.add(c.text());
                        }
                       
                    }
                }
            }


            //dinner tab
            Element dinner = biolaSite.getElementById("tab-content-6564fd39a967b");
            

            for (Element a: dinner.children()) {
                for (Element b: a.children()) {
                    ArrayList<String> tempList = new ArrayList<>();
                    for (Element c: b.children()) {
                        if (c.hasClass("site-panel__daypart-station-title")) {
                            dinnerMap.put(c.text(), new ArrayList<>());
                            tempList = dinnerMap.get(c.text());
                        }
                        else if (c.hasClass("site-panel__daypart-item")) {
                            tempList.add(c.text());
                        }
                       
                    }
                }
            }

            Scanner scanner = new Scanner(System.in);
            boolean flag = true;
            while (flag == true) {
                System.out.print("Which meal do you want information about: ");
            
                String input = scanner.nextLine();
                if (input.equals("breakfast")) {
                    flag = false;
                    display(breakfastMap);
                } else if (input.equals("lunch")) {
                    flag = false;
                    display(lunchMap);
                } else if (input.equals("dinner")) {
                    flag = false;
                    display(dinnerMap);
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

    static void display( Map<String, ArrayList<String>> m) {
        for (Map.Entry<String, ArrayList<String>> key : m.entrySet()) {
            ArrayList<String> values = key.getValue();
            System.out.println(key.getKey() + ":");
            for (String value : values) {
                System.out.println("\t" + value);
            }
            System.out.println("\n");
        }
    }

    
}
