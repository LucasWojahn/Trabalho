/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author lucas.wojahn
 */
public class NeoApi {
    private static final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/feed";
    private static final String API_KEY = "h37uPBAWHTLmSEEeBPUB0Bg7nNtGTVyZRhV7m0Bc"; // Substitua pela sua chave de API

    public NeoFeed fetchNeoData(String startDate, String endDate) throws IOException {
        String apiUrl = String.format(
            "%s?start_date=%s&end_date=%s&api_key=%s", BASE_URL, startDate, endDate, API_KEY
        );

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("API request failed with status code: " + responseCode);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        System.out.println(response.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        
        NeoFeed neoFeed = objectMapper.readValue(response.toString(), NeoFeed.class);
        return neoFeed;
    }
}
