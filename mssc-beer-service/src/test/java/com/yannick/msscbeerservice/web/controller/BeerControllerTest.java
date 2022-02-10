package com.yannick.msscbeerservice.web.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yannick.msscbeerservice.bootstrap.BeerLoader;
import com.yannick.msscbeerservice.services.BeerService;
import com.yannick.msscbeerservice.web.model.BeerDto;
import com.yannick.msscbeerservice.web.model.BeerStyleEnum;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired 
	ObjectMapper objectMapper;
	
	//not in course but needed for test to pass
	@MockBean
	BeerService beerService;
	
	@Test
	void getBeerById() {
		given(beerService.getById(any())).willReturn(getValidBeerDto());
		try {
			mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	void saveNewBeer() throws Exception {
		BeerDto beerDto = getValidBeerDto();
        String beerDtoJson = null;
        given(beerService.saveNewBeer(any())).willReturn(getValidBeerDto());
		try {
			beerDtoJson = objectMapper.writeValueAsString(beerDto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    
	}
	@Test
	void updateBeerById() throws Exception {
		given(beerService.updateBeer(any(), any())).willReturn(getValidBeerDto());
		 BeerDto beerDto = getValidBeerDto();
	        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

	        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(beerDtoJson))
	                .andExpect(status().isNoContent());
	}
	
	BeerDto getValidBeerDto() {
		return BeerDto.builder()
				.beerName("My test beer")
				.beerStyle(BeerStyleEnum.PILSNER)
				.upc(BeerLoader.BEER_1_UPC)
				//.id(UUID.randomUUID())
				.price(new BigDecimal("1.0"))
				.build();
	}

}
