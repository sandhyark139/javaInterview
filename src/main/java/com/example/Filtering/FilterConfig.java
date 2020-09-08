package com.example.Filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterConfig {
	
	@GetMapping("/filters")
	public someBean actionBeans()
	{
		return new someBean("value1","value2","value3");
	}

	
	@GetMapping("/filters-list")
	public List<someBean> listactionBeans()
	{
		return Arrays.asList(new someBean("value1","value2","value3"),
				new someBean("value1","value2","value3"),
				new someBean("value1","value2","value3"));
	}
	
	
	
	@GetMapping("/filters-dynamic")
	public MappingJacksonValue actionBeansdynamic()
	{
		someBean somebean= new someBean("value1","value2","value3");
		
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("value1","value2");
		
		FilterProvider filters=new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		
		MappingJacksonValue mapping=new  MappingJacksonValue(somebean);
		mapping.setFilters(filters);
		return mapping;
	}

	

}
