package oschneider.cdi.demo.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import oschneider.cdi.demo.qualifier.interceptor.Security;



@Security
@Interceptor
public class SecurityInterceptor
{
	@AroundInvoke
	public Object manageSecurity( InvocationContext ctx ) throws Exception
	{
		System.out.println( "Critical ressource being accessed" );
		System.out.println( "Method : " + ctx.getMethod() );
		System.out.println( "Parameters : " + ctx.getParameters() );
		System.out.println( "Access granted." );
		return ctx.proceed();
	}
}
