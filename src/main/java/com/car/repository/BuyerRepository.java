package com.car.repository;

import com.car.model.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer, String>{

	Optional<Buyer> findTopByOrderByIdDesc();

	Optional<Buyer> findByEmailIdAndPassword(String emailId, String password);

	Optional<Buyer> findByBuyerId(String string);

	Optional<Buyer> findByEmailId(String email);

}
