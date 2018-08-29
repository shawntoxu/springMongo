package com.test.app.util;

import java.nio.charset.Charset;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestTempletUtil {
	
	public static void main(String[] args) {
		String  url = "https://www.baidu.com" ;
		//set response charset 
		StringHttpMessageConverter m = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		
		RestTemplate restTemplate = new RestTemplateBuilder().additionalMessageConverters(m).build();
		HttpHeaders  headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<String>  body = new HttpEntity<>(headers);
		
		String result = restTemplate.postForObject(url, body, String.class) ;
		System.out.println(result);
	}

}
