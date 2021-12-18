package com.yannick.msscbeerservice.services;

import java.util.UUID;

import com.yannick.msscbeerservice.web.model.BeerDto;

public interface BeerService {

	

	BeerDto getBeerById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	

	void updateBeer(UUID beerId, BeerDto beerDto);

	void deleteBeer(UUID beerId);

	

}
