package com.binary.carDealerApp.classCarDealerApp.services;


import com.binary.carDealerApp.classCarDealerApp.dto.PostNewUser;
import com.binary.carDealerApp.classCarDealerApp.dto.UserDto;
import com.binary.carDealerApp.classCarDealerApp.entities.UserCredential;
import com.binary.carDealerApp.classCarDealerApp.exception.InvalidRoleException;
import com.binary.carDealerApp.classCarDealerApp.exception.UsernameTakenException;
import com.binary.carDealerApp.classCarDealerApp.repositories.UserCredentialRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCredentialServiceImpl implements UserCredentialService {

    private UserCredentialRepository userCredentialRepository;
    private PasswordEncoder passwordEncoder;

    public UserCredentialServiceImpl(UserCredentialRepository userCredentialRepository, PasswordEncoder passwordEncoder) {
        this.userCredentialRepository = userCredentialRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto createUser(PostNewUser postNewUser) {
        Optional<UserCredential> possibleNameTaken =
                userCredentialRepository
                        .findByUsername(postNewUser
                                .username()
                                .toLowerCase());
        if(possibleNameTaken.isPresent()){
            throw new UsernameTakenException("Username has been taken, Please choose another!");
        }
        if(postNewUser.role().equals("ADMIN")) {
            throw new InvalidRoleException("User cannot be created as ADMIN, has to be USER or DEALER");
        }
        UserCredential userCredential = new UserCredential(
                postNewUser.username().toLowerCase(),
                passwordEncoder.encode(postNewUser.password()),
                postNewUser.role().toUpperCase()
        );
        userCredential = userCredentialRepository.save(userCredential);
        UserDto userDto = new UserDto(userCredential.getUsername(), userCredential.getRole());

        return userDto;
    }
}
