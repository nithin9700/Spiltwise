package Nithin.SplitWise.entity;


import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.asm.IProgramElement;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;

@Setter
@Getter
@Entity
public class Expense extends BaseModel {
    private String description;
    private double amount;
    private LocalDateTime dateOfExpense;
    @ManyToOne
    private User addedBy;
    private Currency currency;
    @OneToMany
    private List<UserExpense> userExpenses;
}
