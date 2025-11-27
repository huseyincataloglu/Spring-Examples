package com.huseyin.Api.controller;

import com.huseyin.Api.model.Purchase;
import com.huseyin.Api.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class NewsApiRestController {

    private PurchaseService purchaseService;

    public NewsApiRestController(PurchaseService purchaseService){
        this.purchaseService = purchaseService;
    }
    @PostMapping("/postpurchase")
    public ResponseEntity<Purchase> postPurchase(
            @RequestBody Purchase purchase
    ){
       purchaseService.storePurchase(purchase);
       return ResponseEntity.created(URI.create("/getpurchase/"+purchase.getId())).body(purchase);
    }

    @GetMapping("/getpurchase")
    public ResponseEntity<List<Purchase>> getPurchase(
            @RequestParam(name = "id") int id
    ){
        List<Purchase> purchases = purchaseService.getPurchase(id);
        return ResponseEntity.status(HttpStatus.OK).body(purchases);
    }

    //PATH VARIABLE USAGE SUİTS WELL İN TERMS OF REST
    @GetMapping("/getpurchase/{id}")
    public ResponseEntity<List<Purchase>> getPurchasepath(
            @PathVariable int id
    ){
        List<Purchase> purchases = purchaseService.getPurchase(id);
        return ResponseEntity.status(HttpStatus.OK).body(purchases);
    }


    @GetMapping("/getAllPurchases")
    public ResponseEntity<List<Purchase>> getAllPurchases(
    ){
        List<Purchase> purchases = purchaseService.getAllPurchases();
        return ResponseEntity.status(HttpStatus.OK).body(purchases);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePurchase(
            @PathVariable int id
    ){
        purchaseService.deletePurchase(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAll(
    ){
        purchaseService.clearPurchases();
        return ResponseEntity.noContent().build();
    }

}
