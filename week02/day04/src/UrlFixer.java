/**
 * Created by georgezsiga on 3/23/17.
 */
public class UrlFixer {
  public static void main(String... args){
    String url = "https//www.reddit.com/r/nevertellmethebots";

    // Accidentally I got the wrong URL for a funny subreddit. It's probably "odds" and not "bots"
    // Also, the URL is missing a crutial component, find out what it is and insert it too!
    // Try to solve it more than once using different String functions!

    String replacedUrl = url.replace("bot", "odd");
    String firstPart  = replacedUrl.substring(0, 5);
    String secondPart  = replacedUrl.substring(5);
    String fixedUrl = firstPart + ":" + secondPart;


    System.out.println(fixedUrl);
  }
}
