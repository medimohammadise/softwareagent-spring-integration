package um.edu.agentcourse;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class MessageSender extends Agent{
	protected void setup() {
		System.out.println("hello agent my name is "+getLocalName());
		String localname = "Peter";
		AID id = new AID(localname, AID.ISLOCALNAME);
		addBehaviour(
				//do the job only once
		new OneShotBehaviour() {
			
			@Override
			public void action() {
				ACLMessage message=new ACLMessage(ACLMessage.INFORM);
				message.setContent("test message");
				message.addReceiver(new AID("MessageReciever",AID.ISLOCALNAME));
				send(message);
			}
		}
		);
	}
}
