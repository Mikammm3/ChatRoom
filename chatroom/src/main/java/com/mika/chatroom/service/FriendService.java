package com.mika.chatroom.service;


import com.mika.chatroom.mapper.FriendMapper;
import com.mika.chatroom.model.AddFriend;
import com.mika.chatroom.model.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {
    @Autowired
    private FriendMapper friendMapper;

    public List<Friend> getFriendsByUserId(Integer userId) {
        return friendMapper.getFriendsByUserId(userId);
    }

    public Integer addFriendRequired(AddFriend addFriend) {
        return friendMapper.addFriendRequired(addFriend);
    }

    public Friend isFriendShip(Integer userId, Integer friendId) {
        return friendMapper.isFriendShip(userId, friendId);
    }

    public AddFriend FindSameAddFriendRequired(Integer fromId, Integer targetId) {
        return friendMapper.FindSameAddFriendRequired(fromId, targetId);
    }

    public List<AddFriend> getAddRequire(Integer targetId) {
        return friendMapper.getAddRequire(targetId);
    }

    public Integer insertFriend(Integer userId, Integer friendId) {
        return friendMapper.insertFriend(userId, friendId);
    }

    public Integer deleteAddFriendRequire(Integer fromId, Integer targetId) {
        return friendMapper.deleteAddFriendRequire(fromId, targetId);
    }
}
