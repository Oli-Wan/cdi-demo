package oschneider.cdi.demo.producer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import oschneider.cdi.demo.qualifier.UserDB;



public class UserDBProducer
{
	@Produces
	@UserDB
	public RandomAccessFile getFileDB()
	{
		RandomAccessFile randomAccessFile = null;
		try
		{
			File file = new File( System.getProperty( "user.home" )
					+ "/.cdidemo/file_db" );
			if( !file.exists() )
			{
				file.getParentFile().mkdirs();
				file.createNewFile();
			}

			randomAccessFile = new RandomAccessFile( file, "rw" );
		}
		catch( FileNotFoundException e )
		{
			System.out.println( "Could not open the file" );
		}
		catch( IOException e )
		{
			System.out.println( "Could not create file" );
		}
		return randomAccessFile;
	}

	public void closeFile( @Disposes @UserDB RandomAccessFile file )
	{
		System.out.println( "Closing file" );
		try
		{
			file.close();
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
	}
}
