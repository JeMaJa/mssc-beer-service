package com.yannick.msscbeerservice.services;

import java.util.UUID;

import org.springframework.data.domain.PageRequest;

import com.yannick.msscbeerservice.web.model.BeerDto;
import com.yannick.msscbeerservice.web.model.BeerPagedList;
import com.yannick.msscbeerservice.web.model.BeerStyleEnum;

public interface BeerService {
    //BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    //BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

   // BeerDto getByUpc(String upc);

	BeerDto getById(UUID beerId);
}
