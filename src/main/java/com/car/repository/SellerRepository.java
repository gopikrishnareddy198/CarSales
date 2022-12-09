package com.car.repository;

import com.car.model.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends CrudRepository<Seller, String>{

	Optional<Seller> findTopByOrderByIdDesc();

	Optional<Seller> findByEmailIdAndPassword(String emailId, String password);

	Optional<Seller> findBySellerId(String string);

	Optional<Seller> findByEmailId(String s);
}
