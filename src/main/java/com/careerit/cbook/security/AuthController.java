package com.careerit.cbook.security;

import com.careerit.cbook.dto.ApiResponse;
import com.careerit.cbook.security.domain.UserInfo;
import com.careerit.cbook.security.service.JwtUtilService;
import com.careerit.cbook.security.service.UserInfoService;
import com.careerit.cbook.security.util.JwtResponse;
import com.careerit.cbook.security.util.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
        @Autowired
        private UserInfoService userInfoService;
        @Autowired
        private AuthenticationManager authenticationManager;
        @Autowired
        private JwtUtilService jwtService;

        @PostMapping("/login")
        public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest){
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                            loginRequest.getPassword()));
            if (authentication.isAuthenticated()) {
                String token =  jwtService.generateToken(loginRequest.getUsername());
                JwtResponse jwtResponse = JwtResponse.builder().jwtToken(token).build();
                return ResponseEntity.ok(jwtResponse);
            } else {
                throw new UsernameNotFoundException("invalid user request !");
            }
        }
        @PostMapping("/register")
        public ResponseEntity<ApiResponse> register(@RequestBody UserInfo userInfo){
            String message = userInfoService.registerUser(userInfo);
            ApiResponse apiResponse = ApiResponse.builder().message(message).build();
            return ResponseEntity.ok(apiResponse);
        }
}
