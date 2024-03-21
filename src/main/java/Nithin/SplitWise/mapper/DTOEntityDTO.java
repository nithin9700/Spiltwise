package Nithin.SplitWise.mapper;

import Nithin.SplitWise.dto.UserLoginRequestDTO;
import Nithin.SplitWise.dto.UserSignUpRequestDTO;
import Nithin.SplitWise.entity.User;

public class DTOEntityDTO {
    public static User toEntity(UserLoginRequestDTO userLoginRequestDTO){
        User user = new User();
        user.setPassword(userLoginRequestDTO.getPassword());
        user.setEmail(userLoginRequestDTO.getEmail());
        return user;
    }

    public static User toEntity(UserSignUpRequestDTO userSignUpRequestDTO){
        User user = new User();
        user.setPassword(userSignUpRequestDTO.getPassword());
        user.setEmail(userSignUpRequestDTO.getEmail());
        user.setFirst_name(user.getFirst_name());
        user.setLast_name(user.getLast_name());
        return user;
    }
}
