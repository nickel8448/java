package main.java.leetcode.String;

import java.util.HashMap;
import java.util.Random;

public class Codec {

  private String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private HashMap<String, String> urlMap = new HashMap<>();

  private String getRandKey() {
    Random r = new Random();
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < 6; i++) {
      int rand = r.nextInt(62);
      str.append(letters.charAt(rand));
    }
    return str.toString();
  }

  public String encode(String longUrl) {
    String key = getRandKey();
    while (urlMap.containsKey(key)) {
      key = getRandKey();
    }
    urlMap.put(key, longUrl);
    return "http://tinyurl.com/" + key;
  }

  public String decode(String shortUrl) {
    return urlMap.get(shortUrl.replace("http://tinyurl.com/", ""));
  }

  public static void main(String[] args) {
    Codec c = new Codec();
    System.out.println(
        c.encode("https://leetcode.com/problems/encode-and-decode-tinyurl/solution/"));
  }
}
