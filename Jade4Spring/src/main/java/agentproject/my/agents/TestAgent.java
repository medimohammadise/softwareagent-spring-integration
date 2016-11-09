package agentproject.my.agents;

import javax.sql.DataSource;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import agentproject.my.delegate.UserProfileDelegate;
import jade.core.Agent;

public class TestAgent extends Agent {
	@Autowired
    UserProfileDelegate  userProfileDelegate;
	protected void setup() {
		System.out.println("Agent created"+userProfileDelegate.getUserProfiles());
		//System.out.println(appContext.getContextPath());
	}
	
}
