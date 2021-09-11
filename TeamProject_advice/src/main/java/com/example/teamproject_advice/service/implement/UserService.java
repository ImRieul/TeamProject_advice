package com.example.teamproject_advice.service.implement;

import com.example.teamproject_advice.model.entity.User;
import com.example.teamproject_advice.repository.UserRepository;
import com.example.teamproject_advice.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    @Override
    public List<String> clotheStyleList() {
        List<String> list = new ArrayList<>();
        list.add("없음");
        list.add("깔끔");
        list.add("편함");
        list.add("꾸안꾸");
        list.add("캐주얼");
        list.add("포멀");
        list.add("스트릿");
        list.add("미니멀");
        list.add("아메카지");
        list.add("락시크");
        return list;
    }

    @Override
    public void registerUser(User user) {
        User createUser = user;

        user.setCreatedAt(LocalDateTime.now())
                .setCreatedBy("admin")
                .setRegisteredAt(LocalDateTime.now())
                .setStatus("exist");

        userRepository.save(user);
    }

    @Override
    public boolean isUser(String account, String password) {
        User user = userRepository.findByAccountAndPassword(account, password);

        if ( user == null ) { return false; } else { return true; }
    }

    @Override
    public boolean isAccount(String account) {
        User user = userRepository.findByAccount(account);

        if ( user == null ) { return false; } else { return true; }
    }

    @Override
    public boolean isPhoneNumber(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber);

        if ( user == null ) { return false; } else { return true; }
    }
}
