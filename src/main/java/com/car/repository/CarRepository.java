package com.car.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.car.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, String>{

	Optional<Car> findTopByOrderByIdDesc();

	Optional<Car> findByCarId(String carid);

	Optional<List<Car>> findBySellerId(String string);

	Optional<List<Car>> findAllBySellerId(String string);

	Optional<List<Car>> findAllByStatus(String string);

	Optional<List<Car>> findAllBySellerIdAndStatus(String uid, String string);

}
