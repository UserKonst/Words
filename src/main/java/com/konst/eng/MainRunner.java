package com.konst.eng;

import java.io.IOException;
import java.util.Random;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MainRunner {

    private static String reguest = "http://wooordhunt.ru/word/";

    static String[] words = {
        "boring",
        "bored",
        "interesting",
        "interested",
        "amazing",
        "amazed",
        "surprising",
        "surprised",
        "tiring",
        "tired",
        "shocking",
        "shocked",
        "disappointing",
        "disappointed",
        "disgusting",
        "disgusted",
        "exciting",
        "excited",
        "worrying",
        "worried",
        "satisfying",
        "satisfied",
        "irritating",
        "irritated"
    };

    public static void main(String[] args) throws IOException {

        for (String word : words) {
            Connection con = Jsoup.connect(reguest + word)
                    .timeout(30000)
                    .followRedirects(true)
                    .ignoreContentType(true);

            Document doc = con.execute().parse();
            Elements elems = doc.select(".block .ex_o");

            if (elems.size() <= 5) {
                System.out.println("NOT FOUND SENTECNES FOR WORD: " + word + "\n");
                continue;
            }

            int num = new Random().nextInt(5);

            System.out.println(elems.get(num).text());
            //System.out.println(elems.get(num + 1).text());
            System.out.println("");
        }

    }

}
