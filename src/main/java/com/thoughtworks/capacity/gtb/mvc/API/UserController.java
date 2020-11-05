package com.thoughtworks.capacity.gtb.mvc.API;

import com.thoughtworks.capacity.gtb.mvc.Entity.UserEntity;
import com.thoughtworks.capacity.gtb.mvc.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public ResponseEntity UserRegister(@RequestBody @Valid UserEntity newUserEntity) {
    List<UserEntity> userList = userService.getUsers();
    Map<String,String> userMap = userList.stream().collect(Collectors.toMap(UserEntity::getUsername, UserEntity::getPassword));
    if (userMap.get(newUserEntity.getUsername()) == null){
      userService.registerUser(newUserEntity);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.badRequest().body("用户已存在");
  }

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public ResponseEntity UserList(){
    return ResponseEntity.ok().body(userService.getUsers());
  }
}
