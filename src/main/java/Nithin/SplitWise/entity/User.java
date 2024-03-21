package Nithin.SplitWise.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "SPILTWISE_USER")
public class User extends BaseModel{
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    @ManyToMany
    private List<User> friends;
    @ManyToMany
    private List<Group> groupList;
}
