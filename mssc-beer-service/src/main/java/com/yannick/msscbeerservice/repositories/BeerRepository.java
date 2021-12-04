/**
 * 
 */
package com.yannick.msscbeerservice.repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.yannick.msscbeerservice.domain.Beer;

/**
 * @author yanni
 *
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
