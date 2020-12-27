package laba8;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CrawlerTask implements Runnable {

    public URLDepthPair depthPair;
    public URLPool pool;
    public CrawlerTask (URLPool newPool) {
        pool = newPool;
    }
    @Override
    public void run() {
        depthPair = pool.get();
        int depth = depthPair.getDepth();
        LinkedList<String> linksList = null;
        try {
            linksList = Crawler.getSites(depthPair);
        }
        catch (IOException ex) {
            Logger.getLogger(CrawlerTask.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        for (int counter = 0; counter < linksList.size(); ++counter) {
            String newURL = linksList.get(counter);
            URLDepthPair newDepthPair = new URLDepthPair(newURL, depth + 1);
            pool.put(newDepthPair);
        }
    }
}