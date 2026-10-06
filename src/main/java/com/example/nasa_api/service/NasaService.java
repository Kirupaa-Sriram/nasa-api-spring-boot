package com.example.nasa_api.service;

import com.example.nasa_api.client.NasaClient;
import com.example.nasa_api.dto.NasaResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NasaService {
    private final NasaClient nasaClient;

    public NasaService(NasaClient nasaClient){
        this.nasaClient = nasaClient;
    }

    public List<NasaResponse> getApod(String date){
        return nasaClient.getApod(date);
    }
}
