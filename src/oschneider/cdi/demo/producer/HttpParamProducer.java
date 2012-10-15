package oschneider.cdi.demo.producer;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.servlet.ServletRequest;

import oschneider.cdi.demo.qualifier.HttpParam;



public class HttpParamProducer
{
	@Inject
	private ServletRequest request;

	@Produces
	@HttpParam( "" )
	public String getParam( InjectionPoint ip )
	{
		return request.getParameter( ip.getAnnotated()
				.getAnnotation( HttpParam.class ).value() );
	}
}
