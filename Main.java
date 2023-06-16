package org.example;
import org.json.JSONObject;

import java.io.BufferedInputStream;
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

        URL url = null ;
        HttpURLConnection connection = null;
        int responseCode = 0;
        String urlString = "https://api.chucknorris.io/jokes/random";

        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            System.out.println("problem in URL");
        }

        try {
            connection = (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();
        } catch (Exception e) {
            System.out.println("Connection problem");
        }

        if (responseCode == 200) {
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            StringBuilder apiData = new StringBuilder();
            String readLine = null;

            while(true)
            {
                try {
                    if (!((readLine = in.readLine())!= null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                apiData.append(readLine);
            }

            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            JSONObject jsonAPIResponse = new JSONObject(apiData.toString());
            System.out.println(jsonAPIResponse.toString());
        }
        else {
            System.out.println("API call could not be made");
        }
    }
}