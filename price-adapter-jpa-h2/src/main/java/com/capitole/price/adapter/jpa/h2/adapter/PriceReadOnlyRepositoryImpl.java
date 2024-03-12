/*******************************************************************************
 * Copyright (C) 2024
 * @author https://www.linkedin.com/in/ylarosag/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.capitole.price.adapter.jpa.h2.adapter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.capitole.price.adapter.jpa.h2.entity.PriceEntity;
import com.capitole.price.adapter.jpa.h2.mapper.DaoMapper;
import com.capitole.price.adapter.jpa.h2.repository.PriceReadOnlyJpaRepository;
import com.capitole.price.application.port.output.repository.PriceReadOnlyRepository;
import com.capitole.price.common.Constant;
import com.capitole.price.core.entity.Price;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Component("PriceReadOnlyRepository")
public class PriceReadOnlyRepositoryImpl implements PriceReadOnlyRepository {
	private final DaoMapper daoMapper;
    private final PriceReadOnlyJpaRepository priceReadOnlyJpaRepository;

	@Override
	public Optional<Price> findFirstPrice(Integer brandId, Long productId, LocalDateTime applicationDate) {
		Pageable pageable = PageRequest.of(0, 1, Sort.by(Direction.DESC, "priority"));
		Page<PriceEntity> priceEntities = priceReadOnlyJpaRepository.findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(brandId, productId, applicationDate, applicationDate, pageable);
		
		if (priceEntities.isEmpty()) {
			throw new IllegalArgumentException(Constant.NOT_FOUND);
		}
		PriceEntity priceEntity = priceEntities.get().findFirst().orElseThrow(() -> new IllegalArgumentException(Constant.NOT_FOUND));
		return Optional.of(daoMapper.priceEntityToPrice(priceEntity));
	}
}
