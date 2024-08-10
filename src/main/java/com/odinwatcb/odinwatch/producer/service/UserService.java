package com.odinwatcb.odinwatch.producer.service;

import com.odinwatcb.odinwatch.producer.entities.UserEntity;
import com.odinwatcb.odinwatch.producer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUser(UserEntity user) {
        user.setCreatedAt(new Date());
        return userRepository.save(user);
    }

    public Optional<UserEntity> getUserById(int id) {
        return userRepository.findById(id);
    }

    public Optional<UserEntity> getUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public UserEntity createUser(String email, String password) {
        UserEntity user = new UserEntity(email, password);

        return userRepository.save(user);
    }

}
