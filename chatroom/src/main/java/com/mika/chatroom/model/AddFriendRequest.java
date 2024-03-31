package com.mika.chatroom.model;


import com.mika.chatroom.constant.Constant;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddFriendRequest {
    private String type = Constant.ADD_FRIEND_REQUIRE;
    private String addReason;
    private Integer friendId;

    // 用来处理接受/拒绝好友申请
    private Integer fromId;
}
