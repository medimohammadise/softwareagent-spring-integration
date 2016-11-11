package um.edu.agentcourse;

import java.util.Date;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import um.edu.agentcourse.persistance.delegate.UserProfileDelegate;
@Component
public class SchedulerAgent extends Agent {
	@Autowired(required=false)
	ApplicationContext userProfileDelegate;
	protected void setup() {
		addBehaviour(new TickerBehaviour(this, 10000) {
			
			@Override
			protected void onTick() {
				System.out.println(new Date());
				System.out.println(userProfileDelegate);
				//userProfileDelegate.getUserProfiles();
				
			}
		});
	}
}
