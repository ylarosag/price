
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

import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;

@Configuration
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
public class OpenApiConfig {

	@Value("${api.name:#{null}}")
	private String apiName;

	@Value("${info.component:#{null}}")
	private String infoComponent;

	@Value("${api.description:CAPITOLE TEST}")
	private String apiDescription;

	@Value("${api.version:not defined}")
	private String apiVersion;

	@Bean
	public OpenAPI springShopOpenAPI() {		
		String title = "API REST";
		
		if(Objects.nonNull(apiName)) {
			 title = apiName;
		}else if(Objects.nonNull(infoComponent)) {
			 title = infoComponent;
		}

		Info info = new Info();
		info.title(title);
		info.version(apiVersion);
		info.description(apiDescription);

		License license = new License();
		license.name("GPL v3.0");
		license.url("https://www.gnu.org/licenses/gpl-3.0.html");
		info.setLicense(license);

		Contact contact = new Contact();
		contact.setName("Team: Yudiel");
		contact.setUrl("https://www.linkedin.com/in/ylarosag");
		contact.email("ylarosag@gmail.com");
		info.setContact(contact);
		return new OpenAPI().info(info);
	}

}
