package com.market.her.web.controller;


import com.market.her.domain.User;
import com.market.her.domain.dto.AuthenticationRequest;
import com.market.her.domain.dto.LoginRequest;
import com.market.her.domain.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    @ApiOperation("Get all supermarket products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<User>  createLogin(@RequestBody AuthenticationRequest request) {
            System.out.println(request.getUsername());
            Optional<User> resp = userService.userLogin(request.getUsername(),request.getPassword());
            return new ResponseEntity<>(resp.get(), HttpStatus.OK);

    }

}
