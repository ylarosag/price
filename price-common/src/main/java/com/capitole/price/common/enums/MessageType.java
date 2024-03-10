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
package com.capitole.price.common.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum MessageType {
	SUCCESS("S"), INFO("I"), WARNING("W"), ERROR("E");

	private final String id;
	private static final Map<String, MessageType> NAMES = new HashMap<>();

	static {
		Arrays.asList(values()).forEach(e -> NAMES.put(e.id, e));
	}

	private MessageType(String id) {
		this.id = id;
	}

	public String getLabel() {
		return this.id;
	}

	public static MessageType valueOfLabel(String label) {
		return NAMES.get(label);
	}
}
