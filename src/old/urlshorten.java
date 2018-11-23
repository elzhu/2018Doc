package old;

import java.util.HashMap;
import java.util.Map;

public class urlshorten {
    private static final String BASE_HOST = "http://tinyurl.com/";
    private static final String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private Map<String, String> keyToUrl = new HashMap<>();
    private Map<String, String> urlToKey = new HashMap<>();

    public String encode(String longUrl) {
        String key =  null;
        if (urlToKey.containsKey(longUrl)) {
            key = urlToKey.get(longUrl);
        }
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int r = (int)(Math.random() * SEED.length());
                sb.append(SEED.charAt(r));
            }
            key = sb.toString();
        } while (keyToUrl.containsKey(key));
        keyToUrl.put(key, longUrl);
        urlToKey.put(longUrl, key);
        return BASE_HOST + key;
    }

    public String decode(String shortUrl) {
        return keyToUrl.get(shortUrl.replace(BASE_HOST, ""));
    }

}
