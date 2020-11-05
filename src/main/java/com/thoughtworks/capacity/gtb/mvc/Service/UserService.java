package com.thoughtworks.capacity.gtb.mvc.Service;
import java.io.Console;
import java.util.HashMap;
import java.util.List;
import	java.util.Map;
import java.util.stream.Collectors;

import com.thoughtworks.capacity.gtb.mvc.Entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private Map<Integer, UserEntity> userEntityMap = new HashMap<>();

  public UserService(){
    userEntityMap.put(1, new UserEntity("KyleTwSeaCd","132928","xutianhao1994@163.com"));
    userEntityMap.put(2, new UserEntity("NicoleBMYY","133328","xutianhao1994@163.com"));
  }

  public void registerUser(UserEntity userEntity) {
    int size = userEntityMap.size();
    userEntityMap.put(size+1, userEntity);
    // return userEntityMap.size();
  }

  public List<UserEntity> getUsers() {
      return userEntityMap.values().stream().collect(Collectors.toList());
  }

  public Map<String,String> getUserMap(){
    List<UserEntity> userList = this.getUsers();
    return userList.stream().collect(Collectors.toMap(UserEntity::getUsername, UserEntity::getPassword));
  }

  public boolean ifUserExist(String username){
    Map<String,String> userMap = this.getUserMap();
    if (userMap.get(username) == null){
      return true;
    }
    return false;
  }

  public boolean ifPasswordRight(String username, String password){
    Map<String,String> userMap = this.getUserMap();
    if(!this.ifUserExist(username)){
      String user = userMap.get(username);
      if (userMap.get(username).equals(password)){
        return true;
      }
      return false;
    }
    return false;
  }

}
