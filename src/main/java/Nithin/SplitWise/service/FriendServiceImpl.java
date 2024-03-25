package Nithin.SplitWise.service;

import Nithin.SplitWise.entity.User;
import Nithin.SplitWise.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FriendServiceImpl implements FriendService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> addFriend(User user, User friend) {
        User user1 = userRepository.findByEmail(friend.getEmail());
        List<User> friendList = user.getFriends() == null ? new ArrayList<>() : user.getFriends();
        friendList.add(user1);
        return friendList;
    }

    public List<User> removeFriend(User user, User friend) {
        User user1 = userRepository.findByEmail(friend.getEmail());
        List<User> friendList = user.getFriends();
        friendList.remove(user1);
        return friendList;
    }
}
