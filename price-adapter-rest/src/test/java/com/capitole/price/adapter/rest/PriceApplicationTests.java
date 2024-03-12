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
package com.capitole.price.adapter.rest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.EnabledIf;
import org.springframework.util.StopWatch;
import org.springframework.web.util.UriComponentsBuilder;

import com.capitole.price.application.port.input.service.dto.response.GetPriceResponse;
import com.capitole.price.common.dto.ResponseDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceApplicationTests {
	private TestRestTemplate restTemplate = new TestRestTemplate();
	
    private String url;
    
    @LocalServerPort
    private int port;
    
	void contextLoads() {
	}
	
    @BeforeEach
    public void setUp() {
        url = String.format("http://localhost:%d/price-adapter-rest/price", port);
    }
    
    @Test
    @EnabledIf(expression = "#{environment['spring.profiles.active'] != 'prod'}", loadContext = true)
    void getPriceTest1() {
		genericTest(1, 35455L, "2020-06-14T10:00:00",  1, BigDecimal.valueOf(35.5));
    }    

    @Test
    @EnabledIf(expression = "#{environment['spring.profiles.active'] != 'prod'}", loadContext = true)
    void getPriceTest2() {
		genericTest(1, 35455L, "2020-06-14T15:00:00",  2, BigDecimal.valueOf(25.45));
    }
    
    @Test
    @EnabledIf(expression = "#{environment['spring.profiles.active'] != 'prod'}", loadContext = true)
    void getPriceTest3() {
		genericTest(1, 35455L, "2020-06-14T21:00:00",  1, BigDecimal.valueOf(35.5));
    }    

    @Test
    @EnabledIf(expression = "#{environment['spring.profiles.active'] != 'prod'}", loadContext = true)
    void getPriceTest4() {
		genericTest(1, 35455L, "2020-06-15T10:00:00",  3, BigDecimal.valueOf(30.5));
    }
    
    @Test
    @EnabledIf(expression = "#{environment['spring.profiles.active'] != 'prod'}", loadContext = true)
    void getPriceTest5() {
		genericTest(1, 35455L, "2020-06-16T21:00:00",  4, BigDecimal.valueOf(38.95));
    }   
    
    private void genericTest(@NonNull Integer brandId, @NonNull Long productId, 
    		@NonNull String datetimeString, @NonNull Integer priceList, @NonNull BigDecimal priceSale) {
        	//Headers
            //HttpHeaders headers = new HttpHeaders();
            
            //Path Variables
            Map<String, String> urlParams = new HashMap<>();
            urlParams.put("brandId", String.valueOf(1));
            urlParams.put("productId", String.valueOf(35455));
            
            //Query Params
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).path("/").path(String.valueOf(brandId)).path("/").path(String.valueOf(productId)).queryParam("applicationDate", datetimeString);
            String urlPrice = builder.toUriString();
            
            //Log info
            log.info("URL TEST {}", urlPrice);
            
            //CALL
            StopWatch stopWatch = new StopWatch("CALL REST");
            stopWatch.start();
    		ResponseEntity<String> responseString = restTemplate.exchange(urlPrice, HttpMethod.GET, null, String.class);
    		stopWatch.stop();
    		log.info("Response string {}", responseString.getBody());
    		
            //TESTs
    		assertEquals(200, responseString.getStatusCode().value(), "HTTP Status Code 200 OK");		
    		Gson gson = new GsonBuilder()
    			    .registerTypeAdapter(LocalDateTime.class, new LocalDateTypeAdapter())
    			    .create();
    		Type type = new TypeToken<ResponseDto<GetPriceResponse>> () {}.getType();
    		final ResponseDto<GetPriceResponse> response = gson.fromJson(responseString.getBody(), type);
    		
    		assertAll("Assertions of Price",
    				  () -> assertEquals(priceList, response.getData().getPriceList(), "Result OK to priceList"),
    				  () -> assertEquals(priceSale, response.getData().getPriceSale(), "Result OK to priceSale"),
    				  () -> assertTrue(3000 > stopWatch.getTotalTimeSeconds(), "Execution Time OK: < 3000ms")
    				 );
        } 
    

}
