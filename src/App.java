import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/*
* This is the information regarding how to locate certain parts of data through the site
* this is the tab: System.out.println((item.parent().parent().parent().parent().parent().parent()));
* this is the meal: System.out.println("\t" + item.parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().attributes());
* this is the location: item.parent().parent().parent().parent().getElementsByTag("h3").text()
* these are the dietary restrictions: Elements dietary = item.child(0).children();
* this is the info about the item: System.out.println("\t" + item.parent().parent().child(1).text());
*/

public class App {

    public static void main(String[] args)  {

        // Get the date from the user
        Scanner scanner = new Scanner(System.in);
        String dateString = "";
        
        System.out.print("Enter the date in the following format yyyy-mm-dd: ");
    
        dateString = scanner.nextLine();
        dateString.concat("/");

        scanner.close();

        Day d = new Day();
        d = d.connect(dateString);
        d.print();


        
    }

    

    
}
