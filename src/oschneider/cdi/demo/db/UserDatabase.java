package oschneider.cdi.demo.db;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import oschneider.cdi.demo.bean.User;
import oschneider.cdi.demo.qualifier.UserDB;



@ApplicationScoped
@UserDB
public class UserDatabase
{
	private List<User> users;

	@PostConstruct
	public void initDb()
	{
		users = new ArrayList<User>();
		System.out.println( "Memory database of users initialized" );
	}

	public List<User> getUsers()
	{
		return users;
	}

	public void setUsers( List<User> users )
	{
		this.users = users;
	}

}
