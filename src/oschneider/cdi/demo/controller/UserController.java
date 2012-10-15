package oschneider.cdi.demo.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.New;
import javax.inject.Inject;
import javax.inject.Named;

import oschneider.cdi.demo.bean.User;
import oschneider.cdi.demo.service.api.UserDao;



@Named
@RequestScoped
public class UserController
{
	@Inject
	private UserDao userDao;
	private List<User> users;

	@Inject
	@New
	private User user;

	public String create()
	{
		userDao.create( user );
		return "/demo.xhml?faces-redirect=true";
	}

	public List<User> getUsers()
	{
		/** lazy loading **/
		if( users == null )
			users = userDao.readAll();
		return users;
	}

	public void setUsers( List<User> users )
	{
		this.users = users;
	}

	public UserDao getUserDao()
	{
		return userDao;
	}

	public void setUserDao( UserDao userDao )
	{
		this.userDao = userDao;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser( User user )
	{
		this.user = user;
	}

}
