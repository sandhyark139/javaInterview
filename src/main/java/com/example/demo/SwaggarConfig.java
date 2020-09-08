package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggarConfig {
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Sandhya Aplication docs", "done by Sandhya ", "1.0", "urn:tos",
	          "Contact Email:sandhyarani@gamil.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	
	public static final Set<String> PRODUCES_AND_CONSUME = new HashSet<String>(java.util.Arrays.asList("application/Json","application/XMl"));
	
	
	@Bean
	public Docket api(){
		 return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(PRODUCES_AND_CONSUME).consumes(PRODUCES_AND_CONSUME);
	}
	

}
