package um.edu.agentcourse;

import jade.Boot;
import jade.core.Agent;

public class MainAppBoot extends Agent {

	public static void main(String[] args) {
		
		if
		(args.length == 0) {
		String[] args1 = {"-gui","-agents","\"MessageSender\":um.edu.agentcourse.MessageSender;\"MessageReciever\":um.edu.agentcourse.MessageReciever;\"SchedulerAgent\":um.edu.agentcourse.SchedulerAgent;"};
		args = args1;
		}
		Boot b=new Boot();
		b.main(args);
		

	}
	 protected void setup() {
		System.out.println("Hello");
		Object[] o=getArguments();
		System.out.println(o[1].toString());
		
	}

}
