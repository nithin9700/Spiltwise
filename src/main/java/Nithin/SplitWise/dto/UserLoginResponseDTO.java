package Nithin.SplitWise.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;


@Getter
@Setter
public class UserLoginResponseDTO{
    private long id;
    private String name;
    private String email;
    private List<UserFriendDTO> userFriendList;
    private List<UserGroupDTO> userGroupList;
}
