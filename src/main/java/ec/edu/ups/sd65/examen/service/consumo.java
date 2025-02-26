package ec.edu.ups.sd65.examen.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Path("/characters")
public class consumo {

    private static final String API_URL = "https://rickandmortyapi.com/api/character";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCharacters() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            Scanner scanner = new Scanner(url.openStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();
            conn.disconnect();
            
            return response.toString();
        } catch (IOException e) {
            return "{\"error\": \"Failed to fetch data\"}";
        }
    }
}
