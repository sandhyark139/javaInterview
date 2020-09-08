package com.example.User;

import static  org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.Exceptions.UserNotFoundException;

@RestController
public class UserController {
	@Autowired
	private DaoService service;
		
	@GetMapping(path="/Users")
	public List<User> Getallusers()
	{
		return service.findAll();
		
		
	}
	
	@GetMapping("/Users/{id}")
	public Resource<User> getUserdata(@PathVariable int id )
	{User user=service.findOne(id);
			if(user==null)
			{
				throw  new UserNotFoundException("id-value "+id);
			}
						
		Resource<User> resource=new Resource<User>(user);
		
		ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).Getallusers());
		 resource.add(linkTo.withRel("all-users"));;
		 return resource;
	}
	
	@DeleteMapping("/Users/{id}")
	public ResponseEntity<Object> removeUser(@PathVariable int id)
	{
		
	User user=service.Delete(id);
	if(user==null)
	{
		throw new UserNotFoundException("id-value"+id);
	}
		
	return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/Users")
	public ResponseEntity<Object> AddUser(@Valid @RequestBody User user)
	{
		User saverobj=service.save(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(saverobj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}

