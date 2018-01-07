package com.springjpa.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springjpa.model.Number;

public interface NumberRepository extends CrudRepository<Number, Long>{
	Number findTop1ByOrderByIdDesc();
}