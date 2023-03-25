package com.careerit.cbookserverapp.api;

import com.careerit.cbookserverapp.util.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/greet")
public class GreetingController {

      @GetMapping("/")
      public ResponseEntity<ApiResponse> greet(){
          ApiResponse apiResponse = ApiResponse.builder()
              .message("Welcome to spring boot world")
              .httpStatus(HttpStatus.OK)
              .date(LocalDateTime.now())
              .build();
          return ResponseEntity.ok(apiResponse);
      }
}
