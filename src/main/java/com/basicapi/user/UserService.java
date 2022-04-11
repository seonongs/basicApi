package com.basicapi.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll () {
        return new ArrayList<>(userRepository.findAll());
    }


}
