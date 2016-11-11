package agentproject.my.agents;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Years;

import agentproject.my.delegate.UserProfileDelegate;
import agentproject.my.persistance.model.MessageRule;
import agentproject.my.persistance.model.UserProfiles;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class BirtDateCheckerBehaviour extends TickerBehaviour {
	UserProfileDelegate userProfileDelegate;
	public UserProfileDelegate getUserProfileDelegate() {
		return userProfileDelegate;
	}
	public void setUserProfileDelegate(UserProfileDelegate userProfileDelegate) {
		this.userProfileDelegate = userProfileDelegate;
	}
	public BirtDateCheckerBehaviour(Agent a, long period) {
		super(a, period);

	}
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
				System.out.println("Looking for age : "+age);
				MessageRule messageRule= userProfileDelegate.getMessageRules(age.getYears());
				System.out.println("Happy BirthDay "+messageRule.getMessage());
				/*final SimpleMailMessage email = constructEmailMessage(messageRule.getMessage());
		         this.mailSender.send(email);*/
				ACLMessage message=new ACLMessage(ACLMessage.INFORM);
				message.setContent(messageRule.getMessage());
				message.addReceiver(new AID("emailAgent",AID.ISLOCALNAME));
				this.getAgent().send(message);
				System.out.println("Message Sent");
			}
		}
	}

}
