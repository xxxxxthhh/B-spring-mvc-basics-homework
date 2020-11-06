package com.thoughtworks.capacity.gtb.mvc.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thoughtworks.capacity.gtb.mvc.Entity.UserEntity;
import com.thoughtworks.capacity.gtb.mvc.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Service;
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
    if (userService.ifUserExist(newUserEntity.getUsername())){
      userService.registerUser(newUserEntity);
      return ResponseEntity.status(201).build();
    }
    return ResponseEntity.badRequest().body("用户已存在");
  }

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public ResponseEntity UserList(){
    return ResponseEntity.ok().body(userService.getUsers());
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ResponseEntity UserLogin(@RequestParam("username") String userName, @RequestParam("password") String passWord) throws JsonProcessingException {
    if (userService.ifUserExist(userName)){
      return ResponseEntity.badRequest().body("用户名错误请重试");
    }
    if (userService.ifPasswordRight(userName, passWord)){
      String userInfo = userService.loginUserEntity(userName);
      return ResponseEntity.ok().body(userInfo);
    }
    return ResponseEntity.badRequest().body("密码错误");
  }
}
