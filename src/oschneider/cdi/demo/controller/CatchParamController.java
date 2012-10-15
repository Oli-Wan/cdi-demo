package oschneider.cdi.demo.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import oschneider.cdi.demo.bean.User;
import oschneider.cdi.demo.qualifier.HttpParam;



@Named
@RequestScoped
public class CatchParamController
{
	private User user = new User();

	public CatchParamController()
	{
	}

	@Inject
	public CatchParamController( @HttpParam( "firstName" ) String firstName,
			@HttpParam( "lastName" ) String lastName,
			@HttpParam( "email" ) String email )
	{
		System.out.println( String.format(
				"I got some params : firstName = %s, lastName = %s, email=%s",
				firstName, lastName, email ) );
		user.setFirstName( firstName );
		user.setLastName( lastName );
		user.setEmail( email );
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
