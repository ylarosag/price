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
import org.mapstruct.MappingConstants.ComponentModel;

import com.capitole.price.application.port.input.service.dto.response.GetPriceResponse;
import com.capitole.price.core.entity.Price;

@Mapper(componentModel = ComponentModel.SPRING)
public interface DtoMapper {
	
	/**
     * Busca el precio para un producto y cadena en una fecha determinada, 
     * devolviendo el que tenga mayor prioridad en caso de haber más de uno.
     *
     * @param productId Identificador del producto
     * @param brandId Identificador de la cadena
     * @param date Fecha para la que se quiere buscar el precio
     * @return PrioritizedPriceResponseDTO con el precio encontrado
     */
	GetPriceResponse priceToGetPriceResponse(Price price);

	Price priceResponseToPrice(GetPriceResponse priceResponse);
}
