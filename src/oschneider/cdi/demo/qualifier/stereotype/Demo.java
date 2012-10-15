package oschneider.cdi.demo.qualifier.stereotype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;


@Stereotype
@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.TYPE )
@Named
@RequestScoped
public @interface Demo
{

}
