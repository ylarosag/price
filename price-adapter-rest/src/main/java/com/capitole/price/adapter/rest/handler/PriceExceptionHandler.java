/*******************************************************************************
 * Copyright (C) 2024 
 * Authors: Yudiel La Rosa G.
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
package com.capitole.price.adapter.rest.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capitole.price.common.dto.MessageDto;
import com.capitole.price.common.dto.ResponseDto;
import com.capitole.price.common.enums.MessageType;
import com.capitole.price.core.exception.PriceException;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class PriceExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String LOG_FORMAT = "CATCH_EXCEPTION_IN_HANDLER={} | {}";

	@Value("${info.component}")
	private String infoComponent;

	@Value("${web.aspect.enable:true}")
	private boolean aspectEnable;

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ PriceException.class })
	@ResponseBody
	public ResponseDto<Object> customExceptionHandler(PriceException exception) {
		if (aspectEnable) {
			log.error(LOG_FORMAT, "exceptionHandler", exception);
		}
		return createResponseDtoFromException(exception);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ 
		ConstraintViolationException.class,
		org.springframework.web.server.ServerWebInputException.class, 
		IllegalArgumentException.class,
		HttpClientErrorException.BadRequest.class 
	})
	@ResponseBody
	public ResponseDto<Object> badRequestHandler(Exception exception) {
		if (aspectEnable) {
			log.error(LOG_FORMAT, "badRequestHandler", exception);
		}
		return createResponseDtoFromException(exception);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public ResponseDto<Object> exceptionHandler(Exception exception) {
		if (aspectEnable) {
			log.error(LOG_FORMAT, "exceptionHandler", exception);
		}
		return createResponseDtoFromException(exception);
	}

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler({ HttpClientErrorException.Conflict.class })
	public void conflictRequestHandler(Exception exception) {
		log.error(LOG_FORMAT, "conflictRequestHandler", exception);
	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler({ HttpClientErrorException.Forbidden.class })
	public void forbiddenRequestHandler(Exception exception) {
		log.error(LOG_FORMAT, "forbiddenRequestHandler", exception);
	}

	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	@ExceptionHandler({ HttpServerErrorException.BadGateway.class })
	public void badGatewayHandler(Exception exception) {
		log.error(LOG_FORMAT, "badGatewayHandler", exception);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ HttpClientErrorException.NotFound.class })
	public void notFoundRequestHandler(Exception exception) {
		log.error(LOG_FORMAT, "notFoundRequestHandler", exception);
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException exception) {
		if (aspectEnable) {
			log.error(LOG_FORMAT, "handleMethodArgumentNotValid", exception.getMessage());
		}
		ResponseDto<Object> response = new ResponseDto<>();
		response.setData(null);
		for (final FieldError error : exception.getBindingResult().getFieldErrors()) {
			response.addMessage(createMessageDtoByField(error.getField(), error.getDefaultMessage()));
		}
		for (final ObjectError error : exception.getBindingResult().getGlobalErrors()) {
			response.addMessage(createMessageDtoByField(error.getObjectName(), error.getDefaultMessage()));
		}
		log.error("handle", exception);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	private MessageDto createMessageDtoByField(String element, String message) {
		message = message.contains("#hideField#") ? message.replace("#hideField#", "") : element + ": " + message;
		return new MessageDto(infoComponent, String.valueOf(HttpStatus.BAD_REQUEST.value()), message,
				MessageType.ERROR);
	}

	public ResponseDto<Object> createResponseDtoFromException(Exception exception) {
		ResponseDto<Object> response = new ResponseDto<>();
		response.setData(null);

		if (exception instanceof ConstraintViolationException) {
			response.addMessage(new MessageDto(infoComponent, String.valueOf(HttpStatus.BAD_REQUEST.value()),
					exception.getMessage(), MessageType.ERROR));
		} else if (exception instanceof Exception) {
			response.addMessage(new MessageDto(infoComponent, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
					"Unknown exception", MessageType.ERROR));
		}
		return response;
	}

}
