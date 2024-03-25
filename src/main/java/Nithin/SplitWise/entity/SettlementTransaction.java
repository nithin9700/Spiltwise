package Nithin.SplitWise.entity;


import Nithin.SplitWise.entity.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Currency;

@Getter
@Setter
@Entity
public class SettlementTransaction extends BaseModel {
    @ManyToOne
    private User Lender;
    @ManyToOne
    private User borrower;
    private double amount;
    private Currency currency;

    public SettlementTransaction(User lender, User borrower, double amount) {
        Lender = lender;
        this.borrower = borrower;
        this.amount = amount;
    }
}
