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
package com.capitole.price.core.property;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Validated
@AllArgsConstructor
@ConfigurationProperties(prefix = "source.template", ignoreUnknownFields = true)
public class SourceDomainProperties {

	@Value("${source.price.locs:}")
	private List<Long> locs;
	
	@Value("${source.template.integration.tables:ITEM_LOC}")
	private List<String> integrationTables;
	
	@Value("${source.template.log.general.enable:1}")
	private Integer logGeneralEnable;	

	@Value("${source.template.log.while.enable:1}")
	private Integer logWhileEnable;

}
