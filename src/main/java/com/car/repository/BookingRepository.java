package com.car.repository;

import com.car.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends CrudRepository<Booking, String>{


	Optional<Booking> findTopByOrderByIdDesc();

	Optional<List<Booking>> findAllByBuyerId(String string);
	Optional<List<Booking>> findAllBySellerId(String string);

	Optional<List<Booking>> findAllByCarIdIn(List<String> soldCarIds);

	Optional<Booking> findByCarId(String carId);

	Optional<List<Booking>> findAllBySellerIdAndStatus(String uid, String string);

	Optional<List<Booking>> findAllByStatus(String string);

	Optional<List<Booking>> findAllByBuyerIdAndStatusIs(String uid, String string);
	Optional<List<Booking>> findAllBySellerIdAndStatusIs(String uid, String string);

	Optional<List<Booking>> findAllByBuyerIdAndStatusEquals(String uid, String string);
	Optional<List<Booking>> findAllBySellerIdAndStatusEquals(String uid, String string);


	

}
