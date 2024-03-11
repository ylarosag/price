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
package com.capitole.price.application.port.input.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Builder
@AllArgsConstructor
@Schema(description = "Price obtained as a result of the request")
public class GetPriceResponse {
	@Schema(description = "Product ID", example = "35455")
	private Long productId;
	@Schema(description = "Brand ID", example = "1")
	private Integer brandId;
	@Schema(description = "Price of List", example = "2")
	private Integer priceList;
	@Schema(description = "Price of List", example = "2020-06-15T11:00:00", $comment = "ISO 8601")
	private LocalDateTime startDate;
	@Schema(description = "Price of List", example = "2020-06-15T11:00:00", $comment = "ISO 8601")
	private LocalDateTime endDate;
	@Schema(description = "Price of List", example = "30.50")
	private BigDecimal priceSale;
}
