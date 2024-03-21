package Nithin.SplitWise.service;


import Nithin.SplitWise.entity.User;
import Nithin.SplitWise.exception.UserLoginInvalidException;
import Nithin.SplitWise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public User signUp(String firstName, String lastName, String email, String password){
        User user = new User();
        user.setFirst_name(firstName);
        user.setLast_name(lastName);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        return userRepository.save(user);
    }
    public User login(String email, String password){
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UserLoginInvalidException("Please create a new account");
        }
        if(!bCryptPasswordEncoder.matches(password, user.getPassword()) || user.getEmail()== email){
            throw new UserLoginInvalidException("Invalid credentials");
        }
        return user;
    }

}
