package com.grocery.service;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.entity.Grocery;
import com.grocery.repository.GroceryRepo;

@Service
public class GroceryServiceBean implements GroceryService {

	@Autowired
	GroceryRepo repo;
	
	@Override
	public Collection<Grocery> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Grocery findOne(BigInteger id) {
		
		return repo.findOne(id);
	}

	@Override
	public Grocery create(Grocery obj) {
		if(obj.getId() != null)
			return null;
		return repo.save(obj);
	}

	@Override
	public Grocery update(Grocery obj) {
		if(obj.getId() == null)
			return null;
		return repo.save(obj);
	}

	@Override
	public boolean remove(BigInteger id) {
		
		if(findOne(id) != null){
		repo.delete(id);
		return true;
		}
		return false;
	}

}
