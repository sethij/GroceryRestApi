package com.grocery.service;

import java.math.BigInteger;
import java.util.Collection;

import com.grocery.entity.Grocery;

public interface GroceryService {
	
	public  Collection<Grocery> findAll();
	
	public Grocery findOne(BigInteger id);
	
	public Grocery create(Grocery obj);
	
	public Grocery update(Grocery obj);
	
	public boolean remove(BigInteger id);

}
