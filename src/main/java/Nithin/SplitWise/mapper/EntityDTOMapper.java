package Nithin.SplitWise.mapper;

import Nithin.SplitWise.dto.UserResponseDTO;
import Nithin.SplitWise.entity.User;

public class EntityDTOMapper {


    public static UserResponseDTO toDTO(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getFirst_name() + ", " + user.getLast_name());
        userResponseDTO.setEmail(user.getEmail());

        return userResponseDTO;
    }


}
