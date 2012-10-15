package oschneider.cdi.demo.producer;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import oschneider.cdi.demo.qualifier.UID;



@ApplicationScoped
public class UIDProducer
{
	private Random random;

	@PostConstruct
	public void init()
	{
		random = new Random( System.currentTimeMillis() );
	}

	@Produces
	@UID
	public long generateId()
	{
		long uid = random.nextInt( 10000 );
		uid += System.currentTimeMillis();
		return uid;
	}

}
