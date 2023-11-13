package com.qortmdcks.session.repository;

import com.qortmdcks.session.payload.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


// 데이터베이스가 없기 때문에 UserRepository 생성
@Service
public class UserRepository {
    private List<UserDto> userList = new ArrayList<>(); // 1. 비어있는 공간 생성

    public Optional<UserDto> findByName(String name){  // 3. 넘어온 데이터가 일치한지 확인
        return userList
                .stream()
                .filter(it -> {
                    return it.getName().equals(name);
                })
                .findFirst();
    }


    @PostConstruct  // 2. init 할 때 데이터가 들어감
    public void init(){

        userList.add(
                new UserDto(
                        "홍길동",
                        "1234"
                )
        );

        userList.add(
                new UserDto(
                        "유관순",
                        "1234"
                )
        );

        userList.add(
                new UserDto(
                        "강감찬",
                        "1234"
                )
        );

    }
}
