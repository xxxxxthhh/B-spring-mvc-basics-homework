package com.thoughtworks.capacity.gtb.mvc.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capacity.gtb.mvc.Entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.ResultMatcher.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.doclint.Entity.not;
import static org.assertj.core.api.AssertionsForClassTypes.not;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.JsonPathResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
  @Autowired
  MockMvc mockMvc;

  @Test
  void userRegister() throws Exception {
    UserEntity userEntity = new UserEntity("abcdasa","abcdfe","ashdsjao@163.com");
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(userEntity);
    mockMvc.perform(post("/register").content(json).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
  }

  @Test
  void userList() throws Exception {
    mockMvc.perform(get("/users")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)));
  }
}