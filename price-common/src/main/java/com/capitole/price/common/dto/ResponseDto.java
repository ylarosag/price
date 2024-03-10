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
package com.capitole.price.common.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.capitole.price.common.enums.MessageType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto<T> implements Serializable {

	private static final long serialVersionUID = -8113098782890579894L;

	@SuppressWarnings("java:S1948")
	private T data;
	private Set<MessageDto> messages;

	public ResponseDto() {
		this(null);
	}

	public ResponseDto(T data) {
		this(data, new HashSet<>());
	}

	public void addMessage(MessageDto... message) {
		this.messages.addAll(Arrays.asList(message));
	}

	public boolean getError() {
		return this.messages.stream().anyMatch(m -> m.getType().equals(MessageType.ERROR));
	}

}
