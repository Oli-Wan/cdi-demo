package oschneider.cdi.demo.producer;

import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;


public class ServletRequestProducer
{
	@Produces
	public ServletRequest getJsfRequest()
	{
		return (ServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}
}
