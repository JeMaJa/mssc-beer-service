package com.yannick.msscbeerservice.web.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.yannick.msscbeerservice.domain.Beer;
import com.yannick.msscbeerservice.web.model.BeerDto;
@Mapper(componentModel = "spring", uses = {DateMapper.class})
//@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

  
    Beer beerDtoToBeer(BeerDto dto);

    BeerDto beerToBeerDtoWithInventory(Beer beer);
}
