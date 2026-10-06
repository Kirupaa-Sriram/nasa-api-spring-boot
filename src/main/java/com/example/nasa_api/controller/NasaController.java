package com.example.nasa_api.controller;

import com.example.nasa_api.dto.NasaResponse;
import com.example.nasa_api.exception.InvalidDateException;
import com.example.nasa_api.exception.NasaApiException;
import com.example.nasa_api.service.NasaService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
public class NasaController {

   private final NasaService nasaService;

   public NasaController(NasaService nasaService){
       this.nasaService = nasaService;
   }

   @GetMapping("/apod")
   public List<NasaResponse> getApod(@RequestParam String date){
       try{
           LocalDate.parse(date);
       }catch(DateTimeParseException e){
           throw new InvalidDateException(
                   "Invalid date. Expected format: yyyy-MM-dd"
           );
       }
        return nasaService.getApod(date);
   }
}
