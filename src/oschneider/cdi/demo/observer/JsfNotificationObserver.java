package oschneider.cdi.demo.observer;

import javax.enterprise.event.Observes;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oschneider.cdi.demo.qualifier.event.GenericNotification;
import oschneider.cdi.demo.qualifier.event.Info;
import oschneider.cdi.demo.qualifier.event.Notification;



public class JsfNotificationObserver implements NotificationObserver
{
	public void onInfoQualified( @Observes @Notification @Info String message )
	{
		System.out.println( "Sending message " + message + " to JSF." );
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO, message, "" );
		FacesContext.getCurrentInstance().addMessage( null, facesMessage );
	}

	public void onInfo(
			@Observes @GenericNotification( severity = "info" ) String message )
	{
		System.out.println( "Sending info message " + message + " to JSF." );
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO, message, "" );
		FacesContext.getCurrentInstance().addMessage( null, facesMessage );
	}

	public void onWarn(
			@Observes @GenericNotification( severity = "warn" ) String message )
	{
		System.out.println( "Sending warn message " + message + " to JSF." );
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_WARN, message, "" );
		FacesContext.getCurrentInstance().addMessage( null, facesMessage );
	}

	public void onError(
			@Observes @GenericNotification( severity = "error" ) String message )
	{
		System.out.println( "Sending error message " + message + " to JSF." );
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_ERROR, message, "" );
		FacesContext.getCurrentInstance().addMessage( null, facesMessage );
	}
}
