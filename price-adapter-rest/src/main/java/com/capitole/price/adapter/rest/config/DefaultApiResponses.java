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
package com.capitole.price.adapter.rest.config;

import java.lang.annotation.Target;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * A convenient meta-annotation for Swagger API responses.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK. The request succeeded."),
		@ApiResponse(responseCode = "400", description = "Bad Request. The server cannot or will not process the request due to something that is perceived to be a client error."),
		@ApiResponse(responseCode = "401", description = "Unauthorized. The client must authenticate itself to get the requested response."),
		@ApiResponse(responseCode = "403", description = "Forbidden. The client does not have access rights to the content."),
		@ApiResponse(responseCode = "404", description = "Not Found. The server can not find the requested resource."),
		@ApiResponse(responseCode = "409", description = "Conflict. This response is sent when a request conflicts with the current state of the server."),
		@ApiResponse(responseCode = "500", description = "Internal Server Error. The server has encountered a situation it does not know how to handle."),
		@ApiResponse(responseCode = "502", description = "Bad Gateway. This error response means that the server, while working as a gateway to get a response needed to handle the request, got an invalid response.") })
public @interface DefaultApiResponses {
}
