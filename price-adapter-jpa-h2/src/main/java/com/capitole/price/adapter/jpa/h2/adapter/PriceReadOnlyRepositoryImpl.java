package com.capitole.price.adapter.jpa.h2.adapter;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.capitole.price.adapter.jpa.h2.entity.PriceEntity;
import com.capitole.price.adapter.jpa.h2.repository.PriceReadOnlyJpaRepository;
import com.capitole.price.application.port.output.repository.PriceReadOnlyRepository;
import com.capitole.price.core.entity.Price;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Component("PriceReadOnlyRepository")
public class PriceReadOnlyRepositoryImpl implements PriceReadOnlyRepository {

    //private final PriceReadOnlyJpaRepository priceReadOnlyJpaRepository;

	@Override
	public Optional<Price> findFirstPrice(Integer brandId, Long productId, LocalDateTime applicationDate) {
//		Pageable pageable = PageRequest.of(0, 1, Sort.by(Direction.DESC, "priority"));
//		Optional<PriceEntity> price = priceReadOnlyJpaRepository.findFirstByBrandIdAndProductIdAndApplicationDate(brandId, productId, applicationDate, pageable);
		
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}
