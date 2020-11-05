package com.thoughtworks.capacity.gtb.mvc.Entity;

import lombok.*;
import lombok.experimental.Tolerate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
  @NotNull(message = "用户名不为空")
  // @Length(min = 3, max = 10)
  @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{3,10}$", message = "用户名不合法")
  // 用户名，不可重复，只能由字母、数字或下划线组成，并且长度为3到10位
  private String username;
  @NotNull(message = "密码不为空")
  // @Length(min = 5, max = 12)
  // 密码，长度为5到12位
  @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{5,12}$", message = "密码不合法")
  private String password;
  @Email(message = "邮箱地址不合法")
  private String email;
}
