package oschneider.cdi.demo.observer;

import javax.enterprise.event.Observes;

import oschneider.cdi.demo.qualifier.event.GenericNotification;



public class ConsoleNotificationObserver implements NotificationObserver
{

	@Override
	public void onInfo(
			@Observes @GenericNotification( severity = "info" ) String message )
	{
		System.out.println( "INFO : " + message );

	}

	@Override
	public void onWarn(
			@Observes @GenericNotification( severity = "warn" ) String message )
	{
		System.out.println( "WARN : " + message );
	}

	@Override
	public void onError(
			@Observes @GenericNotification( severity = "error" ) String message )
	{
		System.out.println( "ERROR : " + message );
	}
}
