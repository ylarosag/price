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
package com.capitole.price.adapter.jpa.h2.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capitole.price.adapter.jpa.h2.entity.PriceEntity;
import com.capitole.price.common.Constant;

@Transactional(readOnly = true, timeout = Constant.QUERY_TIMEOUT)
@Repository("PriceReadOnlyJpaRepository")
public interface PriceReadOnlyJpaRepository extends JpaRepository<PriceEntity, Long> {

	Page<PriceEntity> findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Integer brandId, Long productId,
			LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
}
