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
package com.capitole.price.adapter.rest.controller;

import java.time.LocalDateTime;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.price.application.port.input.service.PriceInputPortService;
import com.capitole.price.application.port.input.service.dto.response.GetPriceResponse;
import com.capitole.price.common.dto.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
public class PriceController {

	private final PriceInputPortService pricePortService;

	@Operation(security = @SecurityRequirement(name = "bearerAuth"), summary = "Find price")
	@GetMapping(path = "/event/{brandId}/{productId}")
	public ResponseEntity<ResponseDto<GetPriceResponse>> eventOrder(@PathVariable("brandId") Integer brandId, @PathVariable("productId") Long productId,
			@RequestParam(name = "applicationDate") LocalDateTime applicationDate) {
		return ResponseEntity.ok(pricePortService.getPrice(brandId, productId, applicationDate));
	}

}
