package com.car.repository;

import com.car.model.Finance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FinanceRepository extends CrudRepository<Finance, String>{

	Optional<Finance> findByBookingId(String id);

	Optional<List<Finance>> findAllByBuyerId(String uid);

	Optional<Finance> findById(String financeId);


}
