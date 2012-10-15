package oschneider.cdi.demo.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import oschneider.cdi.demo.bean.User;
import oschneider.cdi.demo.db.UserDatabase;
import oschneider.cdi.demo.qualifier.UserDB;
import oschneider.cdi.demo.service.api.UserDao;



@Alternative
// @Specializes
// @Memory
public class MemoryUserDao implements UserDao, Serializable
{
	private static final long serialVersionUID = 1L;

	@Inject
	@UserDB
	private UserDatabase userDb;

	@Override
	public List<User> readAll()
	{
		return userDb.getUsers();
	}

	@Override
	public void create( User user )
	{
		userDb.getUsers().add( user );
	}

}
