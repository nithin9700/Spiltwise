package Nithin.SplitWise.mapper;

import Nithin.SplitWise.dto.UserFriendDTO;
import Nithin.SplitWise.dto.UserGroupDTO;
import Nithin.SplitWise.dto.UserLoginResponseDTO;
import Nithin.SplitWise.dto.UserSignUpResponseDTO;
import Nithin.SplitWise.entity.Group;
import Nithin.SplitWise.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EntityDTOMapper {


    public static UserSignUpResponseDTO toSignupDTO(User user){
        UserSignUpResponseDTO userSignUpResponseDTO = new UserSignUpResponseDTO();
        userSignUpResponseDTO.setId(user.getId());
        userSignUpResponseDTO.setName(user.getFirst_name() + ", " + user.getLast_name());
        userSignUpResponseDTO.setEmail(user.getEmail());
        return userSignUpResponseDTO;
    }

    public static UserLoginResponseDTO toLoginDTO(User user){
        UserLoginResponseDTO  userLoginResponseDTO = new UserLoginResponseDTO();
        userLoginResponseDTO.setId(user.getId());
        userLoginResponseDTO.setName(user.getFirst_name() +", "+ user.getLast_name());
        List<UserFriendDTO> list = new ArrayList<>();
        if(user.getFriends() == null) userLoginResponseDTO.setUserFriendList(list);
        else {
            list = user.getFriends().stream().map(EntityDTOMapper::addFriends).collect(Collectors.toList());
            userLoginResponseDTO.setUserFriendList(list);
        }

        List<UserGroupDTO> userGroup = new ArrayList<>();
        if(user.getGroupList() == null) userLoginResponseDTO.setUserGroupList(userGroup);
        else {
            userGroup = user.getGroupList().stream().map(EntityDTOMapper :: addGroup).collect(Collectors.toList());
            userLoginResponseDTO.setUserGroupList(userGroup);
        }
        return userLoginResponseDTO;
    }
    private static UserFriendDTO addFriends(User friend){
        UserFriendDTO userFriendDTO = new UserFriendDTO();
        userFriendDTO.setId(friend.getId());
        userFriendDTO.setName(friend.getFirst_name()+", "+ friend.getLast_name());
        return userFriendDTO;
    }
    private static UserGroupDTO addGroup(Group group){
        UserGroupDTO userGroupDTO = new UserGroupDTO();
        userGroupDTO.setId(group.getId());
        userGroupDTO.setName(group.getGroupName());
        return userGroupDTO;
    }


}
