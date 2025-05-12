import com.google.gson.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TipoDeCambioAPI {
    private static final String API_KEY = "5e2d6f3da9504ab9222993d2"; // esta es mi apikey de la pagina de exchange rate
    private static final String DIRECCION_URL = "https://v6.exchangerate-api.com/v6/" + "5e2d6f3da9504ab9222993d2" + "/pair/";

    public double getRate(String from, String to) throws IOException, InterruptedException {
        String url = DIRECCION_URL + from + "/" + to;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new GsonBuilder().create();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        if (jsonObject.has("conversion_rate")) {
            return jsonObject.get("conversion_rate").getAsDouble();
        } else {
            throw new IOException("No se pudo obtener la tasa de conversión");
        }
    }
}
