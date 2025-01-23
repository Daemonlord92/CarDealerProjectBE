package com.binary.carDealerApp.classCarDealerApp;

import com.binary.carDealerApp.classCarDealerApp.entities.Car;
import com.binary.carDealerApp.classCarDealerApp.entities.Dealer;
import com.binary.carDealerApp.classCarDealerApp.repositories.CarRepository;
import com.binary.carDealerApp.classCarDealerApp.repositories.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClassCarDealerAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClassCarDealerAppApplication.class, args);
	}

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private DealerRepository dealerRepository;

	@Override
	public void run(String... args) throws Exception {

		Dealer dealer = new Dealer();
		dealer.setDealerName("Toyota Dealership");

		Dealer dealer2 = new Dealer();
		dealer2.setDealerName("Volvo Dealership");
		System.out.println(dealer);
		System.out.println(dealer2);

		dealerRepository.save(dealer);
		dealerRepository.save(dealer2);

		System.out.println(dealer);
		System.out.println(dealer2);

		Car car = new Car("Toyota", "Camry", "red", "123ABC", "https://www.capovalleytoyota.com/new-vehicles/camry/", 2025, 35000, dealer);
		carRepository.save(car);

		Car car2 = new Car("Volvo", "XC60", "blue", "098ZYX", "https://www.cardekho.com/Volvo/Volvo_XC60/pictures", 2017, 50000, dealer2);
		carRepository.save(car2);

	}
}
