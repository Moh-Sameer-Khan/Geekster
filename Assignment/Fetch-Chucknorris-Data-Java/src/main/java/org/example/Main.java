package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Fetching-Chucknorris-Jokes-Api Data Using JAVA Code are showing Given Below ..... ");
//        bcz we are using anywhere on other places but these properties was inside try catch so we use like this -- > who we can access anywhere
        URL url = null;  // error coming so we pass null // error In Connection
        HttpURLConnection connection = null; // error coming so we pass null // error comes in BufferReader
        int responseCode = 0; // // error coming so we pass 0 // if responseCode there error

//      Step -- 1 --> we need a url as a String Form

        String urlString = "https://api.chucknorris.io/jokes/random";

//        Step -- 2 --> Make an object for url link --> Pass a String in constructor(Check in URL(Ctrl + click))

//        --> URL throws exception so we will use try -catch
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
//            throw new RuntimeException(e); // By default
            System.out.println("Problem in URL... Please check it...");
        }

//        Step -- 3 --Make a connection(http)

//        now we need #CONNECTION --> Bcz we need to send any message client to server need an HTTP URL connection
//        --> we create object by other new way not by new keyword
//        --> In Java is available a http url connection known as HttpURLConnection
//        --> Open connection return URLConnection we need http connection so use after so typecasting = (HttpURLConnection) --> check By (Ctrl + click)
//        --> trycatch for openConnection()
        try {
            connection = (HttpURLConnection) url.openConnection(); // create a open connection on this on url object

//             Step -- 4 -- Make a response code

//            now we will get response in the form json -- > 200 means OK
//            Note -- Bcz Both Exception is same so we are using in single try catch -->(connction and responseCode)
            responseCode = connection.getResponseCode();

        } catch (Exception e) {
            System.out.println("Connection Problem .... Please check it");
        }

//        Extraa-Code --> Bcz connection and responseCode same type exception so we are using in same try catch
//        so its optional we can use this

//        try {
//            responseCode = connection.getResponseCode();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        Step -- 5 --> Extract Information from the connection Object

        if(responseCode == 200) { // 200 Mean -- OK(Working Code)
//            In Connection will be in Bytes Form and we want to get Reader Form
//            codes in Ntework --> Package --> Bytes / Stream

//            Step --5.1 --> Bytes into Reader Form
            BufferedReader bufferIn = null; // error in while--> if --so use null
            try {
                bufferIn = new BufferedReader(new InputStreamReader(connection.getInputStream()));  // getInputStream() -- Throws Exception
            } catch (IOException e) {
                System.out.println("InputStream Problem...");
            }

//            Step -- 5.2 --> we want to string Form -- use StringBuilder -- use bcz mutable can add data
            StringBuilder apiData = new StringBuilder();

//            Step -- 5.2 --> For reading --> Bcz data will comin in string type in API --> One by one
            String readLine = null; // error --> in where append the data

//            Step -- 5.3 --> untill null, its add the reading in apiData --> Reader Form into apiData --> readerLine throws Exception
            while(true) {  // we will not get untill null , it will work
                try {
                    if (!((readLine = bufferIn.readLine()) != null)) break;
                } catch (IOException e) {
                    System.out.println("ReaderLine Problem...Please check it..");
                }

                apiData.append(readLine); // append with apiData, who i'm reading
            }
//      Step -- 6   --> Close the connection -- here close but good use in finally block ,close --> its thrwos Exception
            try {
                bufferIn.close();
            } catch (IOException e) {
                System.out.println("Close the connection Problem");
            }

//      Step -- 7 --> StringBuilder into JsonFormat - Like Data show in Postman
//            make an object JSONObject --> Provided by java
            JSONObject jsonAPIResponse = new JSONObject(apiData.toString()); // pass apiData into constructor

//      Step -- 8 -->  Print the Output
           try {
               System.out.println(jsonAPIResponse.get("categories"));
               System.out.println(jsonAPIResponse.get("created_at"));
               System.out.println(jsonAPIResponse.get("icon_url"));
               System.out.println(jsonAPIResponse.get("id"));
               System.out.println(jsonAPIResponse.get("updated_at"));
               System.out.println(jsonAPIResponse.get("url"));
               System.out.println(jsonAPIResponse.get("value"));

               System.out.println();
               System.out.println("API Data in JSON Form.. Given Below");

//               it show all api data in the form of string
               System.out.println(jsonAPIResponse.toString());

//          shows all data
//               System.out.println(jsonAPIResponse);


//               it's passing wrong parameter
//               System.out.println(jsonAPIResponse.get("val"));
           }catch (Exception ee) {
               System.out.println("You pass wrong Parameter .. Please check it");
           }
        }else {
            System.out.println("API call could not be made!!!");
        }

    }
}
