package com.grocery.controller;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.entity.Grocery;
import com.grocery.service.GroceryService;

@RestController
@CrossOrigin(origins="http://localhost")
@RequestMapping(value = "api/grocery")
public class GroceryApi {

	@Autowired
	GroceryService service;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Grocery>> findAll() {

		Collection<Grocery> groceryList = service.findAll();
		if (groceryList == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<Collection<Grocery>>(groceryList, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Grocery> findOne(@PathVariable("id") BigInteger id) {
		Grocery grocery = service.findOne(id);

		if (grocery == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Grocery>(grocery, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Grocery> createGrocery(@RequestBody Grocery grocery) {

		Grocery savedGrocery = service.create(grocery);
		if (savedGrocery == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Grocery>(savedGrocery, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Grocery> updateGrocery(@RequestBody Grocery grocery) {

		Grocery updatedGrocery = service.update(grocery);
		if (updatedGrocery == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Grocery>(updatedGrocery, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Grocery> deleteGrocery(@PathVariable("id") BigInteger id) {

		boolean status = service.remove(id);
		if(status)
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	

}
