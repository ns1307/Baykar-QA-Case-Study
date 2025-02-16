package utilities;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupScraper {


    private Document doc;

    // Constructor
    public JsoupScraper(String pageHTML) {
        this.doc=Jsoup.parse(pageHTML);
    }
    public Document getDoc() {
        return doc;
    }

    public Elements selectElements(String id) {
        return doc.select(id);
    }
    public Element getElementById(String id) {
        return doc.getElementById(id);
    }

}
