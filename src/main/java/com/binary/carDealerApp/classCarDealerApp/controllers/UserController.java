package com.binary.carDealerApp.classCarDealerApp.controllers;

import com.binary.carDealerApp.classCarDealerApp.dto.PostNewUser;
import com.binary.carDealerApp.classCarDealerApp.dto.UserDto;
import com.binary.carDealerApp.classCarDealerApp.services.UserCredentialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserCredentialService userCredentialService;

    public UserController(UserCredentialService userCredentialService) {
        this.userCredentialService = userCredentialService;
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> postNewUser(@RequestBody PostNewUser postNewUser) {
        return new ResponseEntity<>(userCredentialService.createUser(postNewUser), HttpStatus.CREATED);
    }
}
