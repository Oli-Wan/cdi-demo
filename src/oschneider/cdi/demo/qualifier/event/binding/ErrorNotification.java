package oschneider.cdi.demo.qualifier.event.binding;

import javax.enterprise.util.AnnotationLiteral;

import oschneider.cdi.demo.qualifier.event.GenericNotification;



public class ErrorNotification extends
		AnnotationLiteral<GenericNotification> implements GenericNotification
{
	private static final long serialVersionUID = 1L;

	@Override
	public String severity()
	{
		return "error";
	}
}
