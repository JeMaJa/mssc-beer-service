package com.yannick.msscbeerservice.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {  
	
	@Null
	private UUID id;
	
	@NotBlank
	private String beerName;
	@Positive
	@NotNull
	private Long upc;
	
	private Integer quantityOnHand;
	
	@Positive
	@NotNull
	private BigDecimal price;
	@NotNull
	private BeerStyleEnum beerStyle;
	@Null
	private OffsetDateTime createdDate;
	@Null
	private OffsetDateTime lastModifiedDate;
	@Null
	private Integer version;

}
