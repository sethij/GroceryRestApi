package com.grocery.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.entity.Grocery;

@Repository
public interface GroceryRepo extends JpaRepository<Grocery, BigInteger> {

}
