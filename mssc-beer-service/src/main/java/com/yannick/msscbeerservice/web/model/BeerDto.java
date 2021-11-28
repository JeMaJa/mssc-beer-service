package com.yannick.msscbeerservice.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {  
	private UUID id;
	private String beerName;
	private Long upc;
	private Integer quantityOnHand;
	private BigDecimal price;
	private BeerStyleEnum beerStyle;
	private OffsetDateTime createdDate;
	private OffsetDateTime lastModifiedDate;
	private Integer version;

}
