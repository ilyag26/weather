import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

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
        Elements value = divWeather.select("div[class=main loaded]");
        for(Element name:names) {
            String date = name.select("div[class=main loaded]").text();
            System.out.println("              ночь             утро          день           вечер");
        }

    }
}
