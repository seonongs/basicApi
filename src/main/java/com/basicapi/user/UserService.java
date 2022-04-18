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

    public UserDto findUserBySeq(Long seq) {
        return userRepository.findUserBySeq(seq);
    }
    @Transactional
    public UserDto changeUser(Long seq, UserDto userDto) {

        LocalDateTime date = LocalDateTime.now();

        User user = userRepository.findById(seq).orElseThrow(()->new IllegalArgumentException("등록된 사용자가 아닙니다."));
        User savedUser = user.changeUser(seq, userDto);

        userDto = UserDto.builder()
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .phone(savedUser.getPhone())
                .modifiedDate(date)
                .build();

        return userDto;
    }
    @Transactional
    public Long deleteUser(Long seq) {
        User user = userRepository.findById(seq).orElseThrow(()->new IllegalArgumentException("등록된 사용자가 아닙니다."));
        userRepository.delete(user);
        return seq;
    }
}
