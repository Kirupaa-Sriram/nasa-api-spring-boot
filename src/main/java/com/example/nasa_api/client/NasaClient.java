package com.example.nasa_api.client;

import com.example.nasa_api.dto.NasaResponse;
import com.example.nasa_api.exception.NasaApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Component
public class NasaClient {

    private final RestClient restClient;
    private final String apiKey;

    public NasaClient(RestClient restClient,
                      @Value("${nasa.api.key}") String apiKey){
        this.restClient = restClient;
        this.apiKey = apiKey;
    }

    public List<NasaResponse> getApod(String date){

        try{
            return restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .scheme("https")
                            .host("science.nasa.gov")
                            .path("/wp-json/wp/v2/apod-basic")
                            .queryParam("api_key", apiKey)
                            .queryParam("date", date)
                            .build())
                    .retrieve().body(new ParameterizedTypeReference<List<NasaResponse>>() {
                    });
        }catch(RestClientException e){
            throw new NasaApiException("Failed to fetch data from NASA");
        }

    }
}
