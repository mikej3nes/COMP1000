import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MyTravelPlanner {

    private String apiKey = "XXXXXX"; // concealed to protect privacy

    public String getWeatherPrediction(LocalDate date) throws IOException, InterruptedException {
        String uri = "https://api.tomorrow.io/v4/timelines?location=YOUR_LOCATION&fields=weatherCode&units=metric&apikey=" + apiKey +
                     "&startTime=" + date.atStartOfDay() + "&endTime=" + date.plusDays(1).atStartOfDay();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        // Extract the weather condition from the JSON response here. The following line is pseudocode.
        String weatherCondition = jsonObject.get("data").getAsJsonObject().get("timelines").getAsJsonArray().get(0).getAsJsonObject().get("intervals").getAsJsonArray().get(0).getAsJsonObject().get("values").getAsJsonObject().get("weatherCode").getAsString();
        
        // Convert the weather condition code to your application's weather condition string
        // The mapping here is hypothetical. Check the actual API documentation for correct mappings.
        switch (weatherCondition) {
            case "1000":
                return "Sunny";
            case "1001":
                return "Cloudy";
            case "4200":
                return "Rainy";
            case "4000":
                return "Snowy";
            default:
                return "Unknown";
        }
    }
}
