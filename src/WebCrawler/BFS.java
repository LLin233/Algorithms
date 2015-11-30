package WebCrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Le on 2015/11/30.
 */
public class BFS {
    private Queue<String> queue;
    private List<String> discoveredWebsiteList;

    public BFS() {
        this.queue = new LinkedList<>();
        this.discoveredWebsiteList = new ArrayList<>();
    }

    public void discoverWeb(String root) {
        this.queue.add(root);
        this.discoveredWebsiteList.add(root);

        while (!queue.isEmpty()) {
            String v = this.queue.remove();
            String rawHTML = readURL(v);

            String regexp = "http://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(rawHTML);
            while (matcher.find()) {
                String w = matcher.group();
                if (!discoveredWebsiteList.contains(w)) {
                    discoveredWebsiteList.add(w);
                    System.out.println("Website found with URL : " + w);
                    queue.add(w);
                }
            }
        }
    }

    private String readURL(String v) {
        String rawHTML = "";
        try {
            URL url = new URL(v);
            BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine = "";
            while ((inputLine = mBufferedReader.readLine()) != null) {
                rawHTML += inputLine;
            }
            mBufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rawHTML;
    }
}




