package com.binary.carDealerApp.classCarDealerApp.repositories;

import com.binary.carDealerApp.classCarDealerApp.entities.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {
}
