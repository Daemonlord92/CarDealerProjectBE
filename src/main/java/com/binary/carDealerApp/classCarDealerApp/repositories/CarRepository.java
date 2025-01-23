package com.binary.carDealerApp.classCarDealerApp.repositories;

import com.binary.carDealerApp.classCarDealerApp.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
