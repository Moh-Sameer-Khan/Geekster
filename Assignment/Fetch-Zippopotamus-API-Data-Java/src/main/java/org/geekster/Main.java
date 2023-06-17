package org.geekster;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        String urlString = "https://api.zippopotam.us/us/33162";

        URL url = null;
        HttpURLConnection connection = null;
        int responseCode = 0;

        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);  // By default
            System.out.println("Problem in URL... Please check it...");
        }

//        Making a connection
        try {
            connection = (HttpURLConnection) url.openConnection();

            responseCode = connection.getResponseCode();
        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println("Connection Problem .... Please check it");
        }

        if(responseCode == 200) {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } catch (IOException e) {
//                throw new RuntimeException(e);
                System.out.println("InputStream Problem...");
            }
            StringBuilder apiData = new StringBuilder();
            String readLine = null;
            while(true) {
                try {
                    if (!((readLine = bufferedReader.readLine()) != null)) break;
                } catch (IOException e) {
//                    throw new RuntimeException(e);
                    System.out.println("ReaderLine Problem...Please check it..");
                }
                apiData.append(readLine);
            }
//            close the connection
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//            make an object JSONObject --> Provided by java
            JSONObject jsonAPIResponse = new JSONObject(apiData.toString());

            try {

                System.out.println("Below showing whole code of API in JSON Form....👇");
                System.out.println();
                System.out.println(jsonAPIResponse.toString());

                System.out.println();
                System.out.println();

                System.out.println("Fetching-Zippopotamus-API Data Using JAVA Code are showing Below....👇");
                System.out.println();
                System.out.println(jsonAPIResponse.get("post code"));
                System.out.println(jsonAPIResponse.get("country"));
                System.out.println(jsonAPIResponse.get("country abbreviation"));
                System.out.println(jsonAPIResponse.get("places"));

            } catch (Exception e) {
                System.out.println("You pass wrong Parameter .. Please check it");
            }

        }else {
            System.out.println("API call could not be made!!!");
        }
    }
}