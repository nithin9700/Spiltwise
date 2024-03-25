package Nithin.SplitWise.controller;


import Nithin.SplitWise.dto.FriendListDTO;
import Nithin.SplitWise.dto.UserFriendDTO;
import Nithin.SplitWise.dto.UserFriendsDTO;
import Nithin.SplitWise.entity.User;
import Nithin.SplitWise.mapper.DTOEntityDTO;
import Nithin.SplitWise.service.FriendService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class FriendController {
    @Autowired
    private FriendService friendService;

    @PostMapping("/addFriend")
    public ResponseEntity addFriend(@RequestBody UserFriendsDTO userFriendsDTO) {
        User user = DTOEntityDTO.toEntity(userFriendsDTO);
        User user1 = new User();
        user1.setEmail(userFriendsDTO.getUserFriendDTO().getEmail());
        friendService.addFriend(user, user1);
        FriendListDTO friendListDTO = sendResponseToFrontEnd(user.getFriends());
        return ResponseEntity.ofNullable(friendListDTO);
    }

    @PostMapping("/removeFriend")
    public ResponseEntity removeFriendS(@RequestBody UserFriendsDTO userFriendsDTO) {
        User user = DTOEntityDTO.toEntity(userFriendsDTO);
        User user1 = new User();
        user1.setEmail(userFriendsDTO.getUserFriendDTO().getEmail());
        friendService.removeFriend(user, user1);
        return null;
    }
    private FriendListDTO sendResponseToFrontEnd(List<User> friends) {
        FriendListDTO friendListDTO = new FriendListDTO();
        List<String> friend = new ArrayList<>();
        for (User user : friends){
            friend.add(user.getFirst_name()+", "+user.getLast_name());
        }
        friendListDTO.setFriend(friend);
        return friendListDTO;
    }
}
