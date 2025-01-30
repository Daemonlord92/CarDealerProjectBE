package com.binary.carDealerApp.classCarDealerApp.repositories;

import com.binary.carDealerApp.classCarDealerApp.entities.UserCredential;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserCredentialRepository extends ListCrudRepository<UserCredential, String> {
    Optional<UserCredential> findByUsername(String username);
}
