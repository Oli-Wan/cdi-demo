package oschneider.cdi.demo.controller;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import oschneider.cdi.demo.qualifier.UID;
import oschneider.cdi.demo.qualifier.event.Info;
import oschneider.cdi.demo.qualifier.event.Notification;
import oschneider.cdi.demo.qualifier.event.binding.ErrorNotification;
import oschneider.cdi.demo.qualifier.event.binding.InfoNotification;
import oschneider.cdi.demo.qualifier.event.binding.WarnNotification;



@Named
@RequestScoped
public class MessageDemoController
{
	@Inject
	@Notification
	@Info
	private Event<String> notificationInfoEvent;
	@Inject
	private Event<String> genericNotificationEvent;

	@Inject
	@UID
	private long randomNb;

	public String sendMessage()
	{
		notificationInfoEvent.fire( "Hello word!" );
		return "";
	}

	public String sendRandomMessage()
	{
		int test = (int) randomNb % 3;
		switch( test )
		{
		case 0:
			genericNotificationEvent.select( new InfoNotification() )
					.fire( "info" );
			break;
		case 1:
			genericNotificationEvent.select( new WarnNotification() )
					.fire( "warn" );
			break;
		case 2:
			genericNotificationEvent.select( new ErrorNotification() )
					.fire( "error" );
			break;
		default:
			genericNotificationEvent.select( new ErrorNotification() )
					.fire( "error" );
			break;
		}
		return "";
	}
}
