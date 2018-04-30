package de.paktosan.university.swt.leetspeek;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Leet {
    public static String toLeet(String normal) {
        LinkedHashMap<String, String> leetMap = new LinkedHashMap<>() {{
            put("elite", "1337");
            put("cool", "k3wl");
            put("!", "!!!11");
            put("ck", "xx");
            put("ers", "0rz");
            put("er", "0rz");
            put("en", "n");
            put("e", "3");
            put("t", "7");
            put("o", "0");
            put("a", "@");
        }};
        for (String key : leetMap.keySet()) {
            normal = normal.replace(key, leetMap.get(key));
        }
        return normal;
    }

    public static String[] allToLeet(String[] normals) {
        ArrayList<String> leets = new ArrayList<>();
        for (String normal : normals) {
            leets.add(toLeet(normal));
        }
        return leets.toArray(new String[0]);
    }
}
