import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class Main {


    public static void main(String[] args) throws IOException {


        Document doc2 = null;
        try {
            doc2 = Jsoup.connect("https://stadia.google.com/games")
                    .userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //System.out.println(doc2);

        //Element test = doc2.select(".Oou9nd");

        ArrayList<String> stadiaGameList = new ArrayList<>();
        Iterator it = doc2.select(".Oou9nd").iterator();
        while (it.hasNext()) {
            Element tdb = (Element) it.next();
            if(!stadiaGameList.contains(tdb.text())){
                stadiaGameList.add(tdb.text());
            }

        }

        int i = 0;
        for (String game : stadiaGameList) {
            System.out.println(game);
            i++;
        }

        System.out.println(i);

    }

}





