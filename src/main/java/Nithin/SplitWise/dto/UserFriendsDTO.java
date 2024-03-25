package Nithin.SplitWise.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFriendsDTO {
    private long id;
    private String email;
    private UserFriendDTO userFriendDTO;

}
