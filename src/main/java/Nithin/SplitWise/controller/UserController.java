package Nithin.SplitWise.controller;

import Nithin.SplitWise.dto.UserLoginRequestDTO;
import Nithin.SplitWise.dto.UserSignUpRequestDTO;
import Nithin.SplitWise.entity.User;
import Nithin.SplitWise.exception.UserLoginInvalidException;
import Nithin.SplitWise.exception.UserRegistrationInvalidDataException;
import Nithin.SplitWise.mapper.DTOEntityDTO;
import Nithin.SplitWise.mapper.EntityDTOMapper;
import Nithin.SplitWise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserSignUpRequestDTO userSignUpRequestDTO){
        User user = DTOEntityDTO.toEntity(userSignUpRequestDTO);
        signUpValidate(user);
        return ResponseEntity.ok(
                EntityDTOMapper.toDTO(
                        userService.signUp(
                                            userSignUpRequestDTO.getFirstName(), userSignUpRequestDTO.getLastName(),
                                            userSignUpRequestDTO.getEmail(), userSignUpRequestDTO.getPassword()
        )));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequestDTO userLoginrequestDTO){
        User user = DTOEntityDTO.toEntity(userLoginrequestDTO);
        loginValidate(user);

        return ResponseEntity.ok(
                EntityDTOMapper.toDTO(
                        userService.login(user.getEmail(), user.getPassword())
                )
        );
    }

    private void loginValidate(User user){
        if(user.getEmail() == null || user.getPassword() == null ){
            throw new UserLoginInvalidException("Invalid credentials");
        }
    }
    private void signUpValidate(User user){
        if(user.getEmail() == null ||
                user.getFirst_name() == null ||
                user.getLast_name() == null||
                user.getPassword() == null){
            throw new UserRegistrationInvalidDataException("Invalid sign up data");
        }
    }
}
