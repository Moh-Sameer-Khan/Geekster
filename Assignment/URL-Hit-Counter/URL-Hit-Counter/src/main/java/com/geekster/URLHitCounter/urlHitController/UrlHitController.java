package com.geekster.URLHitCounter.urlHitController;

import com.geekster.URLHitCounter.urlHitService.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/visitor-count-app")
// after using @RequestMapping, we should have to pass this path as postman http method to get API after that write that api method path
public class UrlHitController {
    @Autowired
    UrlHitService urlHitService;

//    Task -- 1 --> GetMapping

//    Postman use this path to get API -- > localhost:8080/api/v1/visitor-count-app/counts
    @GetMapping("counts")
    public int getUrlHitCount() {
        return urlHitService.countHitIncrement();
    }

//    Task -- 2 --> GetMapping but with PathVariable
//    Postman --> use this path to get API --> localhost:8080/api/v1/visitor-count-app/username/same/count
    @GetMapping("username/{myUserName}/count")
    public String getUrlHitCountsWithUsername(@PathVariable String myUserName) {
        Integer getUrlHitCounts = urlHitService.getHitCounts(myUserName); // it will give the hitting the count by user

//        return the format what write in the Task
        String str ="\u201CcountHit\u201C" + ":" + getUrlHitCounts;  // \u201C --> i used for double quotes in output
        return "{\n   \u201Cusername\u201C" + ":" + "\u201C" + myUserName + "\u201C" + ",\n   " + str +" \n}";
    }

}
