package com.springai.SpringAiDemo.controller;

import com.springai.SpringAiDemo.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
//  @ResponseBody // to tell the dispatcher servlet that this action wont return a view name
    public Country getFrance(){
        Country country = Country.of("France",40_000_000);
        return country;
    }
    // This is the classic way of returning data in http response and get http request

    @GetMapping("/turkey")
    public ResponseEntity<Country> getTurkey(){
        Country country = Country.of("Turkey",80_000_000);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "Asia")
                .header("capital", "Istanbul")
                .header("favorite_food", "kebab")
                .body(country);
    }





    @GetMapping("/countries")
    public List<Country> countries(){
        Country turkey = Country.of("Turkey",87_000_000);
        Country france = Country.of("France",40_000_000);
        List<Country> countries = List.of(turkey,france);
        return countries;
    }
}
