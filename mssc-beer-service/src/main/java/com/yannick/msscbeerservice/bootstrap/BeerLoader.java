package com.yannick.msscbeerservice.bootstrap;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yannick.msscbeerservice.domain.Beer;
import com.yannick.msscbeerservice.repositories.BeerRepository;
@Component
public class BeerLoader implements CommandLineRunner {

	@Autowired
	public BeerRepository beerRepository;
	@Override
	public void run(String... args) throws Exception {
		loadBeerObjects();
		
	}
	private void loadBeerObjects() {
		if(beerRepository.count() == 0) {
			beerRepository.save(Beer.builder()
					.beerName("Yerk Kluin")
					.beerStyle("Kluin")
					.minOnHand(20)
					.price(new BigDecimal("12.95"))
					.quantityToBrew(200)
					.upc(12000000981L)
					.build());
			beerRepository.save(Beer.builder()
					.beerName("Galaxy Cat")
					.beerStyle("PALE_ALE")
					.minOnHand(20)
					.price(new BigDecimal("11.95"))
					.quantityToBrew(200)
					.upc(12000000982L)
					.build());
		}
	//	System.out.println("Loaded beers: " + beerRepository.count());
		
	}
	

}
