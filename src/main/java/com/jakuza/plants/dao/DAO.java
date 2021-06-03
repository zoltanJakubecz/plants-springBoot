package com.jakuza.plants.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DAO<T>{
	
	List<T> list();

	void create(T t);

	Optional<T> get(UUID id);


}
