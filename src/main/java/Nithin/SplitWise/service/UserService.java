package Nithin.SplitWise.service;

import Nithin.SplitWise.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User signUp(String firstName, String lastName, String email, String password);
    User login(String email, String password);
}
