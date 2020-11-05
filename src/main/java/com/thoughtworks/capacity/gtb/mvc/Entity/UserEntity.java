package com.thoughtworks.capacity.gtb.mvc.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
  @NotNull
  private String username;
  @NotNull
  private String password;
  @Email
  private String email;
}
