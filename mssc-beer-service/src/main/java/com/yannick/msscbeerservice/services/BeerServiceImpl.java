package com.yannick.msscbeerservice.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.yannick.msscbeerservice.web.model.BeerDto;
import com.yannick.msscbeerservice.web.model.BeerStyleEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerId) {
		// TODO Auto-generated method stub
		return BeerDto.builder().id(UUID.randomUUID())
				.beerName("Galaxy Cat")
				.beerStyle(BeerStyleEnum.IPA).build();
	}

	public BeerDto saveNewBeer(BeerDto beerDto) {
		
		return BeerDto.builder().id(UUID.randomUUID())
				.build();
	}

	
	

	@Override
	public void updateBeer(UUID beerId, BeerDto beerDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBeer(UUID beerId) {
		// TODO Auto-generated method stub
		
	}

	

}
 