package Nithin.SplitWise.entity;


import Nithin.SplitWise.entity.Enum.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private double amount;

}
