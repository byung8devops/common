package com.byung8.code;

import java.nio.charset.Charset;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EntityScan
@EnableAutoConfiguration
@SpringBootApplication
public class CommonApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EvthookApplication.class, args);
		System.out.println( "==== Spring Boot Web Application ====" );
		SpringApplication app = new SpringApplication(CommonApplication.class);
		app.addListeners(new ApplicationPidFileWriter());
		app.run(args);
	}
/*
	@Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
*/
}
