package com.thoughtworks.capacity.gtb.mvc.ExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResult {
  private Integer errorCode;
  private String message;
}
