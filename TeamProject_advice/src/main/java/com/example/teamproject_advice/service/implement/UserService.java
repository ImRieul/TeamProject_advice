package com.example.teamproject_advice.service.implement;

import com.example.teamproject_advice.model.entity.User;
import com.example.teamproject_advice.repository.UserRepository;
import com.example.teamproject_advice.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public List<User> list() throws Exception {
        System.out.println("UserService : " + userRepository.findAll().toString());
        return userRepository.findAll();
    }
}
