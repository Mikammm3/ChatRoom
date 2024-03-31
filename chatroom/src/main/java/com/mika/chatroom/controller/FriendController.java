package com.mika.chatroom.controller;


import com.mika.chatroom.constant.Constant;
import com.mika.chatroom.model.AddFriend;
import com.mika.chatroom.model.Friend;
import com.mika.chatroom.model.User;
import com.mika.chatroom.service.FriendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private FriendService friendService;

    @RequestMapping("/getFriendList")
    public List<Friend> getFriendList(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }
        User user = (User) session.getAttribute(Constant.USER_SESSION);
        if (user == null) return null;
        return friendService.getFriendsByUserId(user.getUserId());

    }

    @RequestMapping("/getAddRequire")
    public List<AddFriend> getAddRequire(HttpServletRequest request) {
        // 首先判断是否登录
        HttpSession session = request.getSession(false);
        if (session == null) {
            log.error("用户未登录!");
            return null;
        }
        User user = (User) session.getAttribute(Constant.USER_SESSION);
        if (user == null || user.getUserId() < 1) {
            log.error("用户未登录!");
            return null;
        }
        // 根据 target_id 查找数据库
        List<AddFriend> addRequires = friendService.getAddRequire(user.getUserId());
        return addRequires;
    }

}
