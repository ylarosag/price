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
package com.capitole.price.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.capitole.price.application.port.input.service.dto.response.GetPriceResponse;
import com.capitole.price.core.entity.Price;

@Mapper
public interface MapStructConverter extends Converter {
	MapStructConverter MAPPER = Mappers.getMapper(MapStructConverter.class);

	@Override
	GetPriceResponse convert(Price price);
}
