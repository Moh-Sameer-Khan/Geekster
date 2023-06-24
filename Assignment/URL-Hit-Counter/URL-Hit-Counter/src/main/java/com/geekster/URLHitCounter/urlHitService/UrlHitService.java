package com.geekster.URLHitCounter.urlHitService;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlHitService {
    Map<String, Integer> hitCounts = new HashMap<>();

    private Integer countHit = 1;
    public int countHitIncrement() {
        return countHit ++;
    }

    public Integer getHitCounts(String myUserName) {
        incrementHitCounts(myUserName);
        return hitCounts.get(myUserName);
    }

    private void incrementHitCounts(String myUserName) {
        int hitCount = hitCounts.getOrDefault(myUserName, 0);
//        System.out.println(hitCount); // just for practice
        hitCount ++;
        hitCounts.put(myUserName, hitCount);
//        System.out.println(hitCounts);  // just for practice check tha data
        countHit ++;
    }
}
