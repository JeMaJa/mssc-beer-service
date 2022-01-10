package com.yannick.msscbeerservice.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.yannick.msscbeerservice.domain.Beer;
import com.yannick.msscbeerservice.repositories.BeerRepository;
import com.yannick.msscbeerservice.web.controller.NotFoundException;
import com.yannick.msscbeerservice.web.mappers.BeerMapper;
import com.yannick.msscbeerservice.web.model.BeerDto;
import com.yannick.msscbeerservice.web.model.BeerStyleEnum;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
 