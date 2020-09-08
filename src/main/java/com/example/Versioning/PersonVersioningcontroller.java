package com.example.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningcontroller {

	@GetMapping("/v1/person")
	public PersonV1 PersonV1data()
		{
		return new PersonV1("sandhya Rani");
		
	}
	@GetMapping("/v2/person")
	public PersonV2 PersonV2data()
		{
		return new PersonV2(new Name("sandhya", "Rani"));
		
	}
	
	@GetMapping(value="/person/param",params="version=1")
	public PersonV1 paramPersonv1()
		{
		return new PersonV1("sandhya Rani");
		
	}
	@GetMapping(value="/person/param",params="version=2")
	public PersonV2 paramPersonv2()
		{
		return new PersonV2(new Name("sandhya", "Rani"));
		
	}
	@GetMapping(value="/person/header",headers="X-API-VERSION=1")
	public PersonV1 headerPersonv1()
		{
		return new PersonV1("sandhya Rani");
		
	}
	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public PersonV2 headerPersonv2()
		{
		return new PersonV2(new Name("sandhya", "Rani"));
		
	}
	@GetMapping(value="/person/produces",produces="application/vnd.company.app.v1+json")
	public PersonV1 producesPersonv1()
		{
		return new PersonV1("sandhya Rani");
		
	}
	@GetMapping(value="/person/produces",produces="application/vnd.company.app.v2+json")
	public PersonV2 producesPersonv2()
		{
		return new PersonV2(new Name("sandhya", "Rani"));
		
	}
}
