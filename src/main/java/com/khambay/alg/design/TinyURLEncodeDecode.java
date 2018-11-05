package com.khambay.alg.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Mix of base64 encoding and random
 * - Cannot be predicted
 * - Number of URls that can be encoded is large - (10 + 26 * 2) ^ 6.
 *   Its better than just hashCode which is limited by size of int
 */
public class TinyURLEncodeDecode {

    private static final String URL = "http://tinyurl.com/";
    private static final int KEY_SIZE = 6;

    private String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Map<String, String> map;
    private Random rand;

    public TinyURLEncodeDecode() {
        map = new HashMap<>();
        rand = new Random();
    }

    public String encode(String longUrl) {
        String key = generateKey();
        while (map.containsKey(key)) {
            key = generateKey();
        }
        map.put(key, longUrl);
        return URL + key;
    }

    public String decode(String shortUrl) {
        String key = shortUrl.substring(shortUrl.lastIndexOf("/")+1);
        return map.getOrDefault(key, "");
    }

    private String generateKey() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < KEY_SIZE; i++) {
            sb.append(alphabet.charAt(rand.nextInt(alphabet.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TinyURLEncodeDecode tinyURLEncodeDecode = new TinyURLEncodeDecode();
        String url = "https://leetcode.com/problems/design-tinyurl";
        String tinyUrl = tinyURLEncodeDecode.encode(url);
        System.out.println("Encode = " + tinyUrl);
        System.out.println("Decode = " + tinyURLEncodeDecode.decode(tinyUrl));
    }
}
