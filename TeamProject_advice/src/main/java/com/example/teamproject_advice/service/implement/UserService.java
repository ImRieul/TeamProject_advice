package com.example.teamproject_advice.service.implement;

import com.example.teamproject_advice.model.entity.User;
import com.example.teamproject_advice.repository.UserRepository;
import com.example.teamproject_advice.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;


    @Override
    public boolean userLogin(String account, String password) {
        User user = userRepository.findByAccountAndPassword(account, password);

        if ( user == null ) { return false; }
        else { return true; }
    }

    @Override
    public boolean isAccount(String account) {
        User user = userRepository.findByAccount(account);

        if ( user == null ) { return false; }
        else { return true; }
    }

    @Override
    public boolean isPhoneNumber(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber);

        if ( user == null ) { return false; }
        else { return true; }
    }
}
