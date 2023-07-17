package com.example.vegapay.assessment.Controller;

import com.example.vegapay.assessment.Entity.OfferLimitEntity;
import com.example.vegapay.assessment.Enum.Status;
import com.example.vegapay.assessment.Model.AccountModel;
import com.example.vegapay.assessment.Model.OfferLimitModel;
import com.example.vegapay.assessment.Service.OfferLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/offerLimit")
public class OfferLimitController {

    private final OfferLimitService offerLimitService;

    @Autowired
    public OfferLimitController(OfferLimitService offerLimitService) {
        this.offerLimitService = offerLimitService;
    }


    /**
     * use this api to create offer
     *
     * @param offerLimitEntity
     * @return
     */
    @PostMapping("/createOffer")
    public OfferLimitModel createLimitOffer(@RequestBody OfferLimitEntity offerLimitEntity){
        return offerLimitService.createOfferLimit(offerLimitEntity);
    }

    /**
     * fetch all active offers
     *
     * @param accountId
     * @return
     */
    @GetMapping("/activeOffers")
    public List<OfferLimitModel> getAllActiveOffers(@RequestParam String accountId){
        return offerLimitService.getAllActiveOffers(accountId);
    }

    /**
     * this api is for updating the existing limit
     * @param limitOfferId
     * @param status
     * @return
     */
    @GetMapping("/updateOffer")
    public AccountModel updateLimitOffer(@RequestParam String limitOfferId, @RequestParam Status status){
        return offerLimitService.updateAccountLimit(limitOfferId, status);
    }




}
