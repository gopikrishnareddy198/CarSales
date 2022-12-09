package com.car.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.car.model.Buyer;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer, String>{

	Optional<Buyer> findTopByOrderByIdDesc();

	Optional<Buyer> findByEmailIdAndPassword(String emailId, String password);

	Optional<Buyer> findByBuyerId(String string);


}
