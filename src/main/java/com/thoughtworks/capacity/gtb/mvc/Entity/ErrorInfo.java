package com.thoughtworks.capacity.gtb.mvc.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {
  private Integer errorCode;
  private String errorMessage;
}
