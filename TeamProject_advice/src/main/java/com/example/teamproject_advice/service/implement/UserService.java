package com.example.teamproject_advice.service.implement;

import com.example.teamproject_advice.model.entity.User;
import com.example.teamproject_advice.repository.UserRepository;
import com.example.teamproject_advice.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    @Override
    public void create(String account, String password, String phoneNumber) {
        User user = User.builder()
                .account(account)
                .password(password)
                .phoneNumber(phoneNumber)
                .status("ready")
                .registeredAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("userService")
                .build();

        userRepository.save(user);
    }

    @Override
    public User read(String account, String password) {
        User user = userRepository.findByAccountAndPassword(account, password);
        if ( user == null) {
        }

        System.out.println(user.toString());
        return user;

    }
}