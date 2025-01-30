package com.binary.carDealerApp.classCarDealerApp.services;

import com.binary.carDealerApp.classCarDealerApp.dto.PostNewUser;
import com.binary.carDealerApp.classCarDealerApp.dto.UserDto;

public interface UserCredentialService {
    UserDto createUser(PostNewUser postNewUser);
}
