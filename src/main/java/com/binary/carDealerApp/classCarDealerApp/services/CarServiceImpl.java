package com.binary.carDealerApp.classCarDealerApp.services;

import com.binary.carDealerApp.classCarDealerApp.entities.Car;
import com.binary.carDealerApp.classCarDealerApp.exception.CarNotFoundException;
import com.binary.carDealerApp.classCarDealerApp.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car createCar(Car car) {
        if(car.getYear() < 1908) throw new IllegalArgumentException("Cars weren't invented till 1908 anything before is unknown");
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Car car, Long id) {
        return null;
    }

    @Override
    public void deleteCarById(Long id) {

    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(1L)
                .orElseThrow(() ->
                        new CarNotFoundException("Car with id of " +
                                id +
                                " is not found"));
    }
}
