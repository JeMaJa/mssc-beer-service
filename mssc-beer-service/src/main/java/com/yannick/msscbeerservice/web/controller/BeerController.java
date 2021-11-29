package com.yannick.msscbeerservice.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yannick.msscbeerservice.web.model.BeerDto;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
	
	@GetMapping({"/{beerId}"})
	public ResponseEntity getBeerById(@PathVariable("beerId") UUID beerId){
		// to do implement
		return new ResponseEntity<>(BeerDto.builder().build(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto) {
		// todo implement
		return new ResponseEntity<BeerDto>(HttpStatus.CREATED);
	}
	
	@PutMapping({"/{beerId}"})
	public ResponseEntity updateBeerById(@PathVariable("beerID") UUID beerId, @RequestBody BeerDto beerDto) {
		//todo implement
		return new ResponseEntity<BeerDto>(HttpStatus.NO_CONTENT);
	}

}
