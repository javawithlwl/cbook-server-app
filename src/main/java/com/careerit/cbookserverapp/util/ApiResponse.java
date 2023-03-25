package com.careerit.cbookserverapp.util;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
      private HttpStatus httpStatus;
      private String message;
      private LocalDateTime date;
}
