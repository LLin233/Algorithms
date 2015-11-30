package WebCrawler;

/**
 * Created by Le on 2015/11/30.
 */
public class App {
    public static void main(String[] args) {
        String root = "http://www.codepath.com/";
        BFS bfs = new BFS();
        bfs.discoverWeb(root);
    }
}
