package com.patika.kredinbizdenservice.manager;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.model.*;

import java.math.BigDecimal;
import java.util.List;

public class 3.soru {

    private static ProductManager instance;

    private ProductManager() {
        
    }

    public static synchronized ProductManager getInstance() {
        if (instance == null) {
            instance = new ProductManager();
        }
        return instance;
    }

    public Loan createLoan(LoanType loanType, BigDecimal amount, Integer installment, Double interestRate) {
        switch (loanType) {
            case IHTIYAC_KREDISI:
                return new ConsumerLoan(amount, installment, interestRate);
            case KONUT_KREDISI:
                return new HouseLoan(amount, installment, interestRate);
            case ARAC_KREDISI:
                return new VechileLoan(amount, installment, interestRate);
            default:
                throw new IllegalArgumentException("Geçersiz kredi türü");
        }
    }

    public CreditCard createCreditCard(BigDecimal fee, List<Campaign> campaignList) {
        return new CreditCard(fee, campaignList);
    }
}