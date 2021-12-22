package com.yannick.msscbeerservice.web.mappers;

import org.mapstruct.Mapper;

import com.yannick.msscbeerservice.domain.Beer;
import com.yannick.msscbeerservice.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
	BeerDto BeerToBeerDto(Beer beer);
	Beer BeerDtoToBeer(BeerDto dto);

}