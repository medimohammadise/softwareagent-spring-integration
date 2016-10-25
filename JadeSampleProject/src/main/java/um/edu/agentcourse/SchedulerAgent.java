package um.edu.agentcourse;

import java.util.Date;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class SchedulerAgent extends Agent {
	protected void setup() {
		addBehaviour(new TickerBehaviour(this, 10000) {
			
			@Override
			protected void onTick() {
				System.out.println(new Date());
				
			}
		});
	}
}
