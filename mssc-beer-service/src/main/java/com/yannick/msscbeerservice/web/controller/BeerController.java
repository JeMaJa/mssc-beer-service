package com.yannick.msscbeerservice.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yannick.msscbeerservice.web.model.BeerDto;
import com.yannick.msscbeerservice.services.BeerService;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
	
	@Autowired
	private BeerService beerService;
	
	public BeerService getBeerService() {
		return beerService;
	}
	
	@GetMapping({"/{beerId}"})
	public ResponseEntity getBeerById(@PathVariable("beerId") UUID beerId){
		// to do implement
		return new ResponseEntity<>(BeerDto.builder().build(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BeerDto> saveNewBeer(@RequestBody @Validated BeerDto beerDto) {
		BeerDto beerSaved = beerService.saveNewBeer(beerDto);
		HttpHeaders headers = new HttpHeaders();
		// to do, make full URL in the location
		headers.add("Location", "/api/v1/beer/"+beerSaved.getId().toString());
		
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping({"/{beerId}"})
	public ResponseEntity updateBeerById(@PathVariable("beerID") UUID beerId, @RequestBody @Validated BeerDto beerDto) {
		//todo implement
		return new ResponseEntity<BeerDto>(HttpStatus.NO_CONTENT);
	}
	
	 

}
