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
package com.capitole.price.application.port.input.service;

import java.time.LocalDateTime;

import com.capitole.price.application.port.input.service.dto.response.GetPriceResponse;
import com.capitole.price.common.dto.ResponseDto;

import lombok.NonNull;

/**
 * <h1>Price Input Port</h1> This interface defines the operations to be
 * implemented in the application layer and to be exposed or used in the
 * adapters.
 *
 * @version 1.0.0
 */
public interface PriceInputPortService {

	/**
	 * This method allows obtaining the price data corresponding to the filters
	 * applied.
	 * 
	 * @param brandId         This parameter is required and refers to the
	 *                        identifier of the brand.
	 * @param productId       This parameter is required and refers to the
	 *                        identifier of the product.
	 * @param applicationDate This parameter allows you to filter by an application
	 *                        date to obtain the corresponding price.
	 * @return GetPriceResponse
	 * 
	 * @throws PriceException
	 */
	ResponseDto<GetPriceResponse> getPrice(@NonNull Integer brandId, @NonNull Long productId,
			@NonNull LocalDateTime applicationDate);
}