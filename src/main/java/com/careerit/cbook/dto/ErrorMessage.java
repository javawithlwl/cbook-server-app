package com.careerit.cbook.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

        private String message;
        private HttpStatus httpStatus;

}
