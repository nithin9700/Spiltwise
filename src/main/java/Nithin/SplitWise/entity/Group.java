package Nithin.SplitWise.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "SPLITWISE_GROUP")
public class Group extends BaseModel{
    private String groupName;
    @ManyToOne
    private User createdBy;
    private LocalDateTime createdAt;
    private double totalAmount;
    @ManyToMany
    private List<User> member;
    @OneToMany
    private List<Expense> expenses;
    @OneToMany
    private List<SettlementTransaction> settlementTransactions;

}
