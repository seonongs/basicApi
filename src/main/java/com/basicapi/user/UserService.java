package com.basicapi.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserDto save(UserDto userDto) {

        LocalDateTime date = LocalDateTime.now();

        User user = userRepository.save(User.builder()
                .id(userDto.getId())
                .pw(userDto.getPw())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .createdDate(date)
                .build());

        return UserDto.builder()
                .id(user.getId())
                .pw(user.getPw())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .createdDate(user.getCreatedDate())
                .build();
    }

    public Page<User> findAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public UserDto findUserById(String id) {
        return userRepository.findUserById(id);
    }

}
