package com.huseyin.Api.service;

import com.huseyin.Api.model.Purchase;
import com.huseyin.Api.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;


    public PurchaseService(PurchaseRepository purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }


    public List<Purchase> getAllPurchases(){
        return purchaseRepository.listAllPurchases();
    }

    public List<Purchase> getPurchase(int id){
        return purchaseRepository.listAllPurchases(id);
    }


    public void storePurchase(Purchase purchase){
        purchaseRepository.storePurchase(purchase);
    }
    public void deletePurchase(int id){
         purchaseRepository.deletePurchase(id);
    }
    public void clearPurchases(){
        purchaseRepository.deleteALlPurchases();
    }


}
