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
package com.capitole.price.adapter.jpa.h2.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.capitole.price.core.entity.Price;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRICE")
public class PriceEntity {
	@Id
	@Column(name = "PRICE_ID", nullable = false, unique = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long priceId;
	@Column(name = "BRAND_ID", nullable = false, unique = false)
	private Integer brandId;
	@Column(name = "START_DATE", nullable = false, unique = false)
	private LocalDateTime startDate;
	@Column(name = "END_DATE", nullable = false, unique = false)
	private LocalDateTime endDate;
	@Column(name = "PRICE_LIST", nullable = false, unique = false)
	private Integer priceList;
	@Column(name = "PRODUCT_ID", nullable = false, unique = false)
	private Long productId;
	@Column(name = "PRIORITY", nullable = false, unique = false)
	private Integer priority;
	@Column(name = "PRICE_SALE", nullable = false, unique = false)
	private BigDecimal priceSale;
	@Column(name = "CURRENCY_CODE", nullable = true, unique = false)
	private String currencyCode;
	@Column(name = "CREATE_DATE", nullable = true, unique = false)
	private LocalDateTime createDate;
	@Column(name = "UPDATE_DATE", nullable = true, unique = false)
	private LocalDateTime updateEnd;
	@Column(name = "USERNAME", nullable = true, unique = false)
	private String username;
}
