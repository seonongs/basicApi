package com.basicapi.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long seq;

    private String id;

    private String pw;

    private String name;

    private String email;

    private String phone;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    public UserDto(User user) {
        this.seq = user.getSeq();
        this.id = user.getId();
        this.pw = user.getPw();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.createdDate = user.getCreatedDate();
        this.modifiedDate = user.getModifiedDate();

    }
}
