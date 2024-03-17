package com.patika.kredinbizdenservice.service;

import com.patika.kredinbizdenservice.model.CreditCard;
import com.patika.kredinbizdenservice.model.Campaign;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kredikartilisteleme {

    // Kampanya sayisina gore kredi karti tekliflerini listeleyen metot
    public List<CreditCard> listCreditCardsByCampaignCount(List<CreditCard> creditCards) {
        return creditCards.stream()
                .sorted(Comparator.comparingInt(creditCard -> creditCard.getCampaignList().size()).reversed())
                .collect(Collectors.toList());
    }
}
