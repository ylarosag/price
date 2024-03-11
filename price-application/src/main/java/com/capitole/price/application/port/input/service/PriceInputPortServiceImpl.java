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
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.capitole.price.application.mapper.MapStructConverter;
import com.capitole.price.application.port.input.service.dto.response.GetPriceResponse;
import com.capitole.price.application.port.output.repository.*;
import com.capitole.price.common.Constant;
import com.capitole.price.common.dto.MessageDto;
import com.capitole.price.common.dto.ResponseDto;
import com.capitole.price.common.enums.MessageType;
import com.capitole.price.core.entity.Price;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PriceInputPortServiceImpl implements PriceInputPortService {

	private final PriceReadOnlyRepository priceReadOnlyRepository;

	@Override
	public ResponseDto<GetPriceResponse> getPrice(@NonNull Integer brandId, @NonNull Long productId,
			@NonNull LocalDateTime applicationDate) {
		Price price = priceReadOnlyRepository.findFirstPrice(brandId, productId, applicationDate)
				.orElseThrow(() -> new IllegalArgumentException(Constant.NOT_FOUND));
		return ResponseDto.<GetPriceResponse>builder().data(MapStructConverter.MAPPER.convert(price))
				.messages(new HashSet<>(Arrays.asList(
					MessageDto.builder()
					.code("1202")
					.origin("price-component")
					.type(MessageType.SUCCESS)
					.build())
				))
				.build();
	}

}
