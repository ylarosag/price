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
package com.capitole.price.core.exception;

import lombok.*;

@Value
@Builder
@EqualsAndHashCode(callSuper = true)
public class PriceException extends RuntimeException {

	private static final long serialVersionUID = -6712971081707709844L;
	private final String statusCode;
	private static final String DEFAULT_STATUS_CODE = "500";
	private final Exception exception;

	public PriceException(String message, Exception exception) {
		super(message);
		this.statusCode = DEFAULT_STATUS_CODE;
		this.exception = exception;
	}

	public PriceException(String message, String statusCode, Exception exception) {
		super(message);
		this.statusCode = statusCode;
		this.exception = exception;
	}

	public PriceException(String message) {
		this(message, DEFAULT_STATUS_CODE);
	}

	public PriceException(String message, String statusCode) {
		this(message, statusCode, null);
	}

}
