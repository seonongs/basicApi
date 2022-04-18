package com.basicapi.user;

import com.basicapi.common.response.SingleResult;
import com.basicapi.common.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")

public class UserController {

    private final UserService userService;
    private final ResponseService responseService;

    @PostMapping("/saveUser")
    public SingleResult<UserDto> saveUser(@RequestBody UserDto userDto){
        return responseService.getSingleResult(userService.save(userDto));
    }

    @GetMapping("/findAllUsers")
    public Page<UserDto> findAllUsers(Pageable pageable) {
        Page<User> page = userService.findAllUsers(pageable);
        return page.map(UserDto::new);
    }

    @GetMapping("/findUserBySeq/{seq}")
    public SingleResult<UserDto> findUserBySeq(@PathVariable Long seq){
        return responseService.getSingleResult(userService.findUserBySeq(seq));
    }

    @PutMapping("/userChange/{seq}")
    public SingleResult<UserDto> changeUser(@PathVariable Long seq, @RequestBody UserDto userDto){
        return responseService.getSingleResult(userService.changeUser(seq, userDto));
    }
    @DeleteMapping("/userDelete/{seq}")
    public Long deleteUser(@PathVariable Long seq){
        return userService.deleteUser(seq);
    }
}
