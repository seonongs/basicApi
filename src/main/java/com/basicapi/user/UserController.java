package com.basicapi.user;

import com.basicapi.common.response.SingleResult;
import com.basicapi.common.service.ResponseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Api(tags = "002.User")
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

    @GetMapping("/findUserById/{id}")
    public SingleResult<UserDto> findUserById(@PathVariable String id){

        return responseService.getSingleResult(userService.findUserById(id));

    }


}
