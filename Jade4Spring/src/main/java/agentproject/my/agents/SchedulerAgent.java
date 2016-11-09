package agentproject.my.agents;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;

import agentproject.my.delegate.UserProfileDelegate;
import agentproject.my.persistance.model.MessageRule;
import agentproject.my.persistance.model.UserProfiles;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class SchedulerAgent extends Agent {
	@Autowired
	UserProfileDelegate userProfileDelegate;
	protected void setup() {
		addBehaviour(new TickerBehaviour(this, 10000) {
			
			@Override
			protected void onTick() {
		
				for (UserProfiles userProfile: userProfileDelegate.getUserProfiles())
				{
					DateTime birthDate = new DateTime(userProfile.getBirthDate());
					DateTime now =new DateTime( new Date());
					
					if (DateTimeComparator.getDateOnlyInstance().compare(birthDate, now)==0)
					{
						System.out.println("Happy BirthDay "+userProfile.getName());
						
						Years age = Years.yearsBetween(birthDate, now);
						MessageRule messageRule= userProfileDelegate.getMessageRules(age.getYears());
						System.out.println("Happy BirthDay "+messageRule.getMessage());
					}
				}
				
			}
		});
	}
}
