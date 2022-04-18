package com.basicapi.user;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long seq;

    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 20, nullable = false)
    private String pw;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 12, nullable = false)
    private String phone;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime modifiedDate = LocalDateTime.now();

    public User changeUser(Long seq, UserDto userDto) {

        LocalDateTime date = LocalDateTime.now();

        this.seq = seq;
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.phone = userDto.getPhone();
        this.modifiedDate = date;

        return this;

    }
}
