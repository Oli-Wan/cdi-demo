package oschneider.cdi.demo.observer;

public interface NotificationObserver
{
	public void onInfo( String message );

	public void onWarn( String message );

	public void onError( String message );
}
