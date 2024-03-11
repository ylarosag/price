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

import com.capitole.price.common.enums.MessageType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Message of business", example = "2020-06-15T11:00:00", $comment = "ISO 8601")
public class MessageDto implements Serializable {
	private static final long serialVersionUID = -6485782108810420915L;
	@Schema(description = "System from which the message is launched")
	private String origin;
	@Schema(description = "Unique code that identifies the message", example = "1202")
	private String code;
	@Schema(description = "Descriptive text of the message")
	private String message;
	@Schema(description = "Message of business", example = "SUCCESS", $comment = "SUCCESS | INFO | WARNING | ERROR")
	private MessageType type;
}
