package oschneider.cdi.demo.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.New;
import javax.inject.Inject;
import javax.inject.Named;

import oschneider.cdi.demo.bean.User;
import oschneider.cdi.demo.service.api.UserDao;



@Named
@ConversationScoped
public class UserConversationController implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Inject
	private Conversation conversation;
	@Inject
	@New
	private User user;

	@Inject
	private UserDao userDao;

	@PostConstruct
	public void postConstruct()
	{
		conversation.begin();
	}

	public String create()
	{
		userDao.create( user );
		conversation.end();
		return "/demo?faces-redirect=true";
	}

	public User getUser()
	{
		return user;
	}

	public void setUser( User user )
	{
		this.user = user;
	}

	public Conversation getConversation()
	{
		return conversation;
	}
}
