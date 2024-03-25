package Nithin.SplitWise.service;

import Nithin.SplitWise.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FriendService {
    List<User> addFriend(User user, User friend);
    List<User> removeFriend(User user, User friend);
}
