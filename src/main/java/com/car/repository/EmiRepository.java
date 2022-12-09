package com.car.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.car.model.Emi;

@Repository
public interface EmiRepository extends CrudRepository<Emi, String>{

	Optional<List<Emi>> findAllByFinanceId(String id);

	Optional<List<Emi>> findAllById(String id);

}
