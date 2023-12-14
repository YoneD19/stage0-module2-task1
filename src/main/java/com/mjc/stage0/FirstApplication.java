package com.mjc.stage0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FirstApplication {
    public static void main(String[] args) {
        String url = "https://webhook.site/5d190eb2-0947-4888-b975-95e896c816ab";

        try {
            URL webhookUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) webhookUrl.openConnection();

            // Set request method to GET
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Ping Response Code: " + responseCode);

            // Read and print the response content
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder responseContent = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }

            reader.close();

            System.out.println("Ping Response Content: " + responseContent.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
