
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;

public class Parser {

    private static Document getPage() throws IOException {
        String url = "https://sinoptik.ua/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static void main(String[] args) throws IOException {
        Document page = getPage();
        Element divWeather = page.select("div[id=leftCol]").first();
        Elements names = divWeather.select("div[class=tabs]");
        for (Element name : names) {
            String date = name.select("div[class=main loaded]").text();
            System.out.println("егодня: "+date);
        }
        for (Element name : names) {
            String date = name.select("div[class=main]").first().text();
            System.out.println("завтра: "+date);
        }

        for (int i = 3; i < 8; i++) {
            for (Element name : names) {
                String date = name.select("div[id=bd"+i+"]").text();
                System.out.println("        "+date);
            }
        }
    }
}
