package oschneider.cdi.demo.qualifier.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;


@Qualifier
@Target( { ElementType.PARAMETER, ElementType.FIELD } )
@Retention( RetentionPolicy.RUNTIME )
public @interface GenericNotification
{
	String severity();
}
