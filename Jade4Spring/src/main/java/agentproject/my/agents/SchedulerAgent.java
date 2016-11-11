package agentproject.my.agents;

import java.util.Date;


import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import agentproject.my.delegate.UserProfileDelegate;
import agentproject.my.persistance.model.MessageRule;
import agentproject.my.persistance.model.UserProfiles;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class SchedulerAgent extends Agent {
	@Autowired
	UserProfileDelegate userProfileDelegate;
	int msgQueueMaxSize=60000;
	
	 
	protected void setup() {
		BirtDateCheckerBehaviour birtDateCheckerBehaviour= new BirtDateCheckerBehaviour(this, msgQueueMaxSize);
		birtDateCheckerBehaviour.setUserProfileDelegate(userProfileDelegate);
		addBehaviour(birtDateCheckerBehaviour);
	}
}
