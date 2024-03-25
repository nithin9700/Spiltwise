package Nithin.SplitWise.mapper;

import Nithin.SplitWise.entity.User;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserAmount {
    private User user;
    private Double balance;

    public UserAmount(User user, Double balance){
        this.user  = user;
        this.balance = balance;
    }
}
