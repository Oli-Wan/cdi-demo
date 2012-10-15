package oschneider.cdi.demo.service.impl;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import oschneider.cdi.demo.bean.User;
import oschneider.cdi.demo.qualifier.UserDB;
import oschneider.cdi.demo.qualifier.event.Info;
import oschneider.cdi.demo.qualifier.event.Notification;
import oschneider.cdi.demo.qualifier.interceptor.Security;
import oschneider.cdi.demo.service.api.UserDao;



//@File
public class FileUserDao implements UserDao, Serializable
{
	private static final long serialVersionUID = 1L;
	@Inject
	@UserDB
	private RandomAccessFile file;

	@Inject
	@Notification
	@Info
	private Event<String> notificationInfoEvent;

	@Override
	@Security
	public List<User> readAll()
	{
		List<User> users = new ArrayList<User>();
		String currentLine;
		try
		{
			currentLine = file.readLine();
			while( currentLine != null )
			{
				String[] currentUser = currentLine.split( ":" );
				User user = new User();
				user.setId( Long.parseLong( currentUser[0] ) );
				user.setFirstName( currentUser[1] );
				user.setLastName( currentUser[2] );
				user.setEmail( currentUser[3] );
				users.add( user );
				currentLine = file.readLine();
			}
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void create( User user )
	{
		try
		{
			String lineToWrite = String.format( "%d:%s:%s:%s\n", user.getId(),
					user.getFirstName(), user.getLastName(), user.getEmail() );
			file.seek( file.length() );
			file.write( lineToWrite.getBytes() );
			notificationInfoEvent.fire( "User sucessfully created." );
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
	}
}
