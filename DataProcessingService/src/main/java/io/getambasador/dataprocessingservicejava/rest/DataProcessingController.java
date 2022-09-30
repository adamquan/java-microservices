package io.getambasador.dataprocessingservicejava.rest;

import java.util.Collections;
import java.util.List;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.getambasador.dataprocessingservicejava.dto.EdgyMerch;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RestController
@RequestMapping("/")
public class DataProcessingController {

    @Value("${app.default.color}")
    private String defaultColor;
    @Value("${app.default.env}")
    private String defaultEnv;
    @Value("${app.default.datastore.url}")
    private String defaultDatastoreUrl;

    @GetMapping()
    public ResponseEntity<String> root() {
        return ResponseEntity.ok("root endpoint entry (DataProcessingServiceJava)");
    }

    @GetMapping("color")
    public ResponseEntity<String> color() {
        return ResponseEntity.ok(defaultColor);
    }

    @GetMapping("environment")
    public ResponseEntity<String> environment() {
        return ResponseEntity.ok(defaultEnv);
    }

    @GetMapping("recordCount")
    public ResponseEntity<String> recordCount() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(defaultDatastoreUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build();
        DataStoreClient service = retrofit.create(DataStoreClient.class);
        try {
            Response<String> response = service.getRecordCount().execute();
            String recordCount = response.body();
            return ResponseEntity.ok(recordCount);
        } catch (Exception ex) { 
            System.out.println(ex);
            return ResponseEntity.badRequest().build();
         }
    }

    @GetMapping("findMerch")
    public ResponseEntity<List<EdgyMerch>> findMerch(@RequestParam String country, @RequestParam String season) {
        URL url;
        try {
            url = new URL("http://44.195.23.39/welcome");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
		    System.out.println("GET Response Code :: " + responseCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(defaultDatastoreUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build();
        DataStoreClient service = retrofit.create(DataStoreClient.class);
        try {
            Response<List<EdgyMerch>> response = service.findEdgyMerch(country, season).execute();
            List<EdgyMerch> merchs = response.body();
            return ResponseEntity.ok(merchs);
        } catch (Exception ex) { 
            System.out.println(ex);
            return ResponseEntity.badRequest().build();
        }

    }
}
