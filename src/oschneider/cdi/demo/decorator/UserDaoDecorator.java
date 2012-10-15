package oschneider.cdi.demo.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import oschneider.cdi.demo.bean.User;
import oschneider.cdi.demo.qualifier.UID;
import oschneider.cdi.demo.service.api.UserDao;



@Decorator
public abstract class UserDaoDecorator implements UserDao
{
	@Inject
	@Delegate
	@Any
	private UserDao userDao;
	@Inject
	@UID
	private long uid;

	@Override
	public void create( User user )
	{
		System.out.println( "User will be created... Adding it an UID" );
		user.setId( uid );
		userDao.create( user );
		System.out.println( "User sucessfully created with its uid" );

	}
}
