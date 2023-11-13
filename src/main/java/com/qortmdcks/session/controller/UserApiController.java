package com.qortmdcks.session.controller;


import com.qortmdcks.session.payload.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 나에 정보를 불러오는 API
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @GetMapping("/me")
    public UserDto me(
            HttpSession httpSession
    ){
        var userObject = httpSession.getAttribute("USER");

        if(userObject != null){
            var userDto = (UserDto) userObject;
            return userDto;
        } else {
            return null;
        }
    }
}
