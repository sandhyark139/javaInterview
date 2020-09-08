package com.example.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class DaoService {

	//
	
	public static List<User> users=new ArrayList<>();
	public static int UserCount=4;
	
	static
	{
		users.add(new User(1,"sandhya",new Date()));
		users.add(new User(2,"rani",new Date()));
		users.add(new User(3,"ravi",new Date()));
		users.add(new User(4,"Ashrith",new Date()));
		
	}
	
	
	public List<User> findAll()
	{
	return users;	
		}
	
	
	public User save(User user)
	{
		if(user.getId()==null)
		{
			user.setId(++UserCount);
		}
		users.add(user);
		return user;
	}
	public User findOne(int id)
	
	{
		for(User user:users)
		{
			if(user.getId()==id)
			{
				return user;
			}
	}
	return null;	
	}
	
	public User Delete(int id)
	{
		Iterator<User> useriterator=users.iterator();
		while (useriterator.hasNext())
		{
			User user=useriterator.next();
			if(user.getId()==id)
			{
				useriterator.remove();
				return user;
			}
			
		}
		
		return null;	
	}
}
