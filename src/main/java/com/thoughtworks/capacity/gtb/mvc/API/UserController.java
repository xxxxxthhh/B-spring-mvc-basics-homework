package com.thoughtworks.capacity.gtb.mvc.API;

import com.thoughtworks.capacity.gtb.mvc.Entity.UserEntity;
import com.thoughtworks.capacity.gtb.mvc.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public ResponseEntity UserRegister(@RequestBody @Valid UserEntity userEntity) {
    return ResponseEntity.ok().body(userService.registerUser(userEntity));
  }

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public ResponseEntity UserList(){
    return ResponseEntity.ok().body(userService.getUsers());
  }
}
