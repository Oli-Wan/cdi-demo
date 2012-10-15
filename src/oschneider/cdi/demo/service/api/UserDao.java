package oschneider.cdi.demo.service.api;

import java.util.List;

import oschneider.cdi.demo.bean.User;



public interface UserDao
{
	public List<User> readAll();

	public void create( User user );

}
