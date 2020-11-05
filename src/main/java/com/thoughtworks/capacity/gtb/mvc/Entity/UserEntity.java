package com.thoughtworks.capacity.gtb.mvc.Entity;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
  @NotNull
  // 用户名，不可重复，只能由字母、数字或下划线组成，并且长度为3到10位
  private String username;
  @NotNull
  // 密码，长度为5到12位
  private String password;
  @Email
  private String email;
}
